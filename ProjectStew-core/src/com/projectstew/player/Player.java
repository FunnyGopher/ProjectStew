package com.projectstew.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.GamePad;
import com.projectstew.GameTime;
import com.projectstew.Graphic;

public class Player extends Graphic {
	
	private float x, y;
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
		sprite.translateX(gamePad.getLeftAxis().getX());
		sprite.translateY(gamePad.getLeftAxis().getY());
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
}
