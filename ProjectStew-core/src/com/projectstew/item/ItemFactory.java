package com.projectstew.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.game.GameTime;

public class ItemFactory {

	public ItemFactory() {
		
	}
	
	public static Item createCarrot() {
		return new Item(new Texture(Gdx.files.internal("PStew_Carrot.png")), ItemType.CARROT, 1);
	}
	
	public static Item createPotato() {
		return new Item(new Texture(Gdx.files.internal("PStew_Potato.png")), ItemType.POTATO, 1);
	}
	
	public static Item createStick() {
		return new Item(new Texture(Gdx.files.internal("PStew_Stick.png")), ItemType.STICK, 1);
	}
	
	public static Item createStone() {
		return new Item(new Texture(Gdx.files.internal("PStew_Stones.png")), ItemType.STONE, 1);
	}
}
