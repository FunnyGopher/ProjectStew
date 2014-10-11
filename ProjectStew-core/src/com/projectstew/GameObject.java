package com.projectstew;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.game.GameTime;

public abstract interface GameObject {
	
	public abstract void update(GameTime gameTime);
	public abstract void draw(SpriteBatch spriteBatch);
	
}
