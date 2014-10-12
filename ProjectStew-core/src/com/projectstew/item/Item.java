package com.projectstew.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.game.GameTime;
import com.projectstew.graphic.Graphic;

public class Item extends Graphic {
	
	private ItemType type;
	private int quantity;
	
	public Item(Texture texture, ItemType type, int initialQuantity) {
		super(texture);
	}

	@Override
	public void update(GameTime gameTime) {
		
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		sprite.draw(spriteBatch);
	}
}
