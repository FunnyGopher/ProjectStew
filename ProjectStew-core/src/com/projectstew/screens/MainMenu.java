package com.projectstew.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.projectstew.tween.ActorAccessor;

public class MainMenu implements Screen {
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton playButton, exitButton;
	private BitmapFont white;//, black;
	private Label heading;
	private Sprite title, splash;
	
	private TweenManager tweenManager;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		title.setY(160);
		stage.getBatch().begin();
		splash.draw(stage.getBatch());
		title.draw(stage.getBatch());
		stage.getBatch().end();
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		title.setSize(width, height);
		splash.setSize(width, height);
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		//black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
		Texture titleTexture = new Texture("img/title.png");
		title = new Sprite(titleTexture);
		
		Texture splashTexture = new Texture("img/splash.png");
		splash = new Sprite(splashTexture);
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = white;
		
		/*
		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		heading = new Label(ProjectStewGame.TITLE, headingStyle);
		heading.setFontScale(2);*/
		
		playButton = new TextButton("Play", textButtonStyle);
		playButton.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Play());
			}
			
		});
		
		exitButton = new TextButton("Exit", textButtonStyle);
		exitButton.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
				
		});
		table.padTop(250);
		table.add(playButton);
		table.getCell(playButton).spaceRight(64);
		table.add(exitButton);
		stage.addActor(table);
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createParallel().beginParallel()
			.push(Tween.from(playButton, ActorAccessor.ALPHA, 1.5f).target(0))
			.push(Tween.from(exitButton, ActorAccessor.ALPHA, 2f).target(0))
			.end().start(tweenManager);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();
		//black.dispose();
	}
}
