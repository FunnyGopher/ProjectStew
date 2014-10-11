package com.projectstew.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.Graphic;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;

public class Player extends Graphic {
	
	private float x, y;
	private GamePad gamePad;
	
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
}
