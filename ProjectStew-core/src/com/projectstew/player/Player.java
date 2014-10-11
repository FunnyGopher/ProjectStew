package com.projectstew.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.Graphic;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;

public class Player extends Graphic {
	
	private GamePad gamePad;
	private Role role;
	
	public Player(float x, float y, Texture texture, GamePad gamePad) {
		super(texture);
		this.x = x;
		this.y = y;
		this.gamePad = gamePad;
	}
	
	@Override
	public void update(GameTime gameTime) {
		sprite.translateX(gamePad.getLeftAxis().getX() * 5);
		sprite.translateY(gamePad.getLeftAxis().getY() * 5);
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch) {
		sprite.draw(spriteBatch);
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
}
