package com.projectstew.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.tween.SpriteAccessor;

public class Splash implements Screen {
	
	private SpriteBatch batch;
	private Sprite splash;
	private Sprite title;
	private TweenManager tweenManager;
	Music music;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,  0,  0,  1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		title.setY(160);
		batch.begin();
		splash.draw(batch);
		title.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		title.setSize(width, height);
		splash.setSize(width, height);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		music = Gdx.audio.newMusic(Gdx.files.internal("music/Carrot_Top2.mp3"));
		music.setLooping(true);
		music.play();
		
		Texture texture = new Texture("img/splash.png");
		splash = new Sprite(texture);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Texture titleTexture = new Texture("img/title.png");
		title = new Sprite(titleTexture);
		title.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		Timeline.createSequence().beginSequence()
			.push(Tween.set(title, SpriteAccessor.ALPHA).target(0))
			.push(Tween.from(splash, SpriteAccessor.ALPHA, 2).target(0))
			.push(Tween.to(title, SpriteAccessor.ALPHA, 3).target(1).delay(1.5f)).setCallback(new TweenCallback() {

				@Override
				public void onEvent(int type, BaseTween<?> source) {
					((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				}
				
			}).start(tweenManager);
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
		batch.dispose();
		splash.getTexture().dispose();
		title.getTexture().dispose();
	}
}
