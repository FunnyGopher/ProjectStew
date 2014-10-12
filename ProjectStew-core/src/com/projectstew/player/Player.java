package com.projectstew.player;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;
import com.projectstew.graphic.Direction;
import com.projectstew.graphic.Graphic;

public class Player extends Graphic {
	
	private GamePad gamePad;
	private Role role;
	private Map<Direction, String> imgMap;
	
	public Player(float x, float y, Texture texture, GamePad gamePad) {
		super(texture);
		this.x = x;
		this.y = y;
		this.gamePad = gamePad;
	}
	
	public Player(float x, float y, Role role, GamePad gamePad) {
		super(new Texture(Gdx.files.internal("characters/Unknown.png")));
		
		this.x = x;
		this.y = y;
		this.gamePad = gamePad;
	}
	
	@Override
	public void update(GameTime gameTime) {		
		if(gamePad.getLeftAxis().getX() < 0  & gamePad.getLeftAxis().getY() == 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.WEST))));
		
		if(gamePad.getLeftAxis().getX() < 0  & gamePad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.NORTH_WEST))));
		
		if(gamePad.getLeftAxis().getX() == 0  & gamePad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.NORTH))));
			
		if(gamePad.getLeftAxis().getX() > 0  & gamePad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.NORTH_EAST))));
		
		if(gamePad.getLeftAxis().getX() > 0  & gamePad.getLeftAxis().getY() == 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.EAST))));
		
		if(gamePad.getLeftAxis().getX() > 0  & gamePad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.SOUTH_EAST))));
		
		if(gamePad.getLeftAxis().getX() == 0  & gamePad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.SOUTH))));
		
		if(gamePad.getLeftAxis().getX() < 0  & gamePad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.SOUTH_WEST))));
		
		x += gamePad.getLeftAxis().getX() * 5;
		y += gamePad.getLeftAxis().getY() * 5;
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch) {
		spriteBatch.draw(sprite.getTexture(), x, y);
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setImgMap(Map<Direction, String> imgMap) {
		this.imgMap = imgMap;
		setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.SOUTH))));
	}
}
