package com.projectstew.graphic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.projectstew.GameObject;

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
	
	public void setTexture(Texture texture) {
		this.texture = texture;
		this.sprite = new Sprite(this.texture, (int) x, (int) y, texture.getWidth(), texture.getHeight());
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}
