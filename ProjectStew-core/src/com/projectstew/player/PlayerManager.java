package com.projectstew.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.GameObject;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;
import com.projectstew.graphic.Direction;

public class PlayerManager implements GameObject {
	
	List<Player> players;
	List<GamePad> gamepads;
	
	public PlayerManager() {
		players = new ArrayList<Player>();
		gamepads = new ArrayList<GamePad>();
		
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		
		//players.add(new Player(100, 100, Role.GATHERER, gamepads.get(0)));
		players.get(0).setImgMap(getGathererImgMap());
	}
	
	@Override
	public void update(GameTime gameTime) {
		for(Player player : players) {
			//player.update(gameTime);
		}
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		for(Player player : players)
			player.draw(spriteBatch);
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
