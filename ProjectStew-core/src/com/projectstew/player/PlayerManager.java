package com.projectstew.player;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.GameObject;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;
import com.projectstew.graphic.Direction;

public class PlayerManager implements GameObject {
	
	Player player1, player2, player3, player4;
	GamePad gamePad1, gamePad2, gamePad3, gamePad4;
	
	public PlayerManager() {
		gamePad1 = new GamePad();
		//gamePad2 = new GamePad();
		//gamePad3 = new GamePad();
		//gamePad4 = new GamePad();
		
		player1 = new Player(100, 100, Role.GATHERER, gamePad1);
		player1.setImgMap(getGathererImgMap());
		//player2 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Carrot.png")), gamePad2);
		//player3 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Stick.png")), gamePad3);
		//player4 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Potato.png")), gamePad4);
	}

	@Override
	public void update(GameTime gameTime) {
		player1.update(gameTime);
		//player2.update(gameTime);
		//player3.update(gameTime);
		//player4.update(gameTime);
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		player1.draw(spriteBatch);
		//player2.draw(spriteBatch);
		//player3.draw(spriteBatch);
		//player4.draw(spriteBatch);
	}
	
	private Map<Direction, String> getGathererImgMap() {
		Map<Direction, String> map = new HashMap<Direction, String>();
		map.put(Direction.WEST, "characters/gatherer/west.png");
		map.put(Direction.NORTH_WEST, "characters/gatherer/north_west.png");
		map.put(Direction.NORTH, "characters/gatherer/north.png");
		map.put(Direction.NORTH_EAST, "characters/gatherer/north_east.png");
		map.put(Direction.EAST, "characters/gatherer/east.png");
		map.put(Direction.SOUTH_EAST, "characters/gatherer/south_east.png");
		map.put(Direction.SOUTH, "characters/gatherer/south.png");
		map.put(Direction.SOUTH_WEST, "characters/gatherer/south_west.png");
		return map;
	}
}
