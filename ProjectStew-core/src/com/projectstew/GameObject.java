package com.projectstew;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract interface GameObject {
	
	public abstract void update(GameTime gameTime);
	public abstract void draw(SpriteBatch spriteBatch);
	
}
