package com.projectstew;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Graphic {
	
	private float x, y;
	
	public Player(float x, float y, Texture texture) {
		super(texture);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update(GameTime gameTime) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			sprite.translateX(-5);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			sprite.translateX(5);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			sprite.translateY(-5);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			sprite.translateY(5);
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
}
