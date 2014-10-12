package com.projectstew.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.projectstew.game.ProjectStewGame;
import com.projectstew.tween.ActorAccessor;

public class MainMenu implements Screen {
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton playButton, exitButton;
	private BitmapFont white;//, black;
	private Label heading;
	
	private TweenManager tweenManager;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		//black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
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
		
		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		heading = new Label(ProjectStewGame.TITLE, headingStyle);
		heading.setFontScale(2);
		
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
		
		table.add(heading);
		table.getCell(heading).spaceBottom(128);
		table.row();
		table.add(playButton);
		table.getCell(playButton).spaceBottom(64);
		table.row();
		table.add(exitButton);
		stage.addActor(table);
		
		//table.debug(); // Shows red cell lines
		
		tweenManager = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createParallel().beginParallel()
			.push(Tween.set(heading, ActorAccessor.Y_POSITION).target(525))
			.push(Tween.from(heading, ActorAccessor.Y_POSITION, 4f).target(720))
			.push(Tween.from(heading, ActorAccessor.ALPHA, 5f).target(0))
			.push(Tween.from(playButton, ActorAccessor.ALPHA, 6.5f).target(0))
			.push(Tween.from(exitButton, ActorAccessor.ALPHA, 7f).target(0))
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
