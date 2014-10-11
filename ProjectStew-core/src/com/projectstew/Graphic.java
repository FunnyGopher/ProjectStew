package com.projectstew;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Graphic implements GameObject {

	protected Texture texture;
	protected Sprite sprite;
	
	public Graphic(Texture texture) {
		this.texture = texture;
		sprite = new Sprite(texture);
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void dispose() {
		texture.dispose();
	}
}
