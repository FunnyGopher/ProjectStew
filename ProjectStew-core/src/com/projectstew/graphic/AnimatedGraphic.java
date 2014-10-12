package com.projectstew.graphic;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.projectstew.GameObject;
import com.projectstew.game.GameTime;

public class AnimatedGraphic implements GameObject {
	
	private TextureAtlas textureAtlas;
	private Animation animation;
	private TextureRegion currentFrame;
	
	public AnimatedGraphic(TextureAtlas textureAtlas, Animation animation) {
		this.textureAtlas = textureAtlas;
		this.animation = animation;
	}

	public Animation getAnimation() {
		return animation;
	}

	public TextureAtlas getTextrueAtlas() {
		return textureAtlas;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public void setTextureAtlas(TextureAtlas textrueAtlas) {
		this.textureAtlas = textrueAtlas;
	}

	@Override
	public void update(GameTime gameTime) {
		currentFrame = animation.getKeyFrame(gameTime.getElapsedTime(), true);
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		spriteBatch.draw(currentFrame, 0, 0);
		
	}	
	
	public void resize(int width, int height) {
		// TODO Write resize
	}
	
	public void pause() {
		// TODO Write pause
	}
	

	public void resume() {
		// TODO Write resume
	}
}
