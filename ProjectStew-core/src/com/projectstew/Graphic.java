package com.projectstew;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Graphic implements GameObject {

	protected Texture texture;
	protected Sprite sprite;
	protected float x, y;
	
	public Graphic(Texture texture) {
		this.texture = texture;
		sprite = new Sprite(texture);
		x = 0;
		y = 0;
	}
	
	public void dispose() {
		texture.dispose();
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void set(float y) {
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
