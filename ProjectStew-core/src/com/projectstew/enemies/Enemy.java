package com.projectstew.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.game.GameTime;
import com.projectstew.graphic.Graphic;

public class Enemy extends Graphic {
	
	private int health;
	private boolean isAlive;
	
	public Enemy(Texture texture) {
		super(texture);
		health = 2;
		isAlive = true;
	}

	@Override
	public void update(GameTime gameTime) {
		while(isAlive) {
			if (health <= 0) {
				isAlive = false;
		}
			else {
				// TODO: Update
				// TODO: Moves closer to Item object of ItemType CARROT/POTATO
			}
		}
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		sprite.draw(spriteBatch);
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public void takeDamage() {
		health--;
	}
	
}
