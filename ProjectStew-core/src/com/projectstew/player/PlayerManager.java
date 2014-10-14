package com.projectstew.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.projectstew.gamepad.GamePad;
import com.projectstew.graphic.Direction;

public class PlayerManager {
	
	List<Player> players;
	List<GamePad> gamepads;
	
	public PlayerManager() {
		players = new ArrayList<Player>();
		gamepads = new ArrayList<GamePad>();
		
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		gamepads.add(new GamePad());
		
		players.add(new Player(10 * 64, 5 * 64, Role.GATHERER, gamepads.get(0)));
		players.get(0).setImgMap(getGathererImgMap());
		
		players.add(new Player(11 * 64, 5 * 64, Role.DEFENDER, gamepads.get(1)));
		players.get(1).setImgMap(getDefenderImgMap());
		
		players.add(new Player(12 * 64, 5 * 64, Role.DOG, gamepads.get(2)));
		players.get(2).setImgMap(getDogImgMap());
		
		players.add(new Player(13 * 64, 5 * 64, Role.FARMER, gamepads.get(3)));
		players.get(3).setImgMap(getFarmerImgMap());
	}

	public void draw(Batch batch ,TiledMap map) {
		for(Player player : players)
			player.draw(batch, (TiledMapTileLayer) map.getLayers().get("lowground"));
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
	
	private Map<Direction, String> getDefenderImgMap() {
		Map<Direction, String> map = new HashMap<Direction, String>();
		map.put(Direction.WEST, "characters/defender/west.png");
		map.put(Direction.NORTH_WEST, "characters/defender/north_west.png");
		map.put(Direction.NORTH, "characters/defender/north.png");
		map.put(Direction.NORTH_EAST, "characters/defender/north_east.png");
		map.put(Direction.EAST, "characters/defender/east.png");
		map.put(Direction.SOUTH_EAST, "characters/defender/south_east.png");
		map.put(Direction.SOUTH, "characters/defender/south.png");
		map.put(Direction.SOUTH_WEST, "characters/defender/south_west.png");
		return map;
	}
	
	private Map<Direction, String> getDogImgMap() {
		Map<Direction, String> map = new HashMap<Direction, String>();
		map.put(Direction.WEST, "characters/dog/west.png");
		map.put(Direction.NORTH_WEST, "characters/dog/north_west.png");
		map.put(Direction.NORTH, "characters/dog/north.png");
		map.put(Direction.NORTH_EAST, "characters/dog/north_east.png");
		map.put(Direction.EAST, "characters/dog/east.png");
		map.put(Direction.SOUTH_EAST, "characters/dog/south_east.png");
		map.put(Direction.SOUTH, "characters/dog/south.png");
		map.put(Direction.SOUTH_WEST, "characters/dog/south_west.png");
		return map;
	}
	
	private Map<Direction, String> getFarmerImgMap() {
		Map<Direction, String> map = new HashMap<Direction, String>();
		map.put(Direction.WEST, "characters/farmer/west.png");
		map.put(Direction.NORTH_WEST, "characters/farmer/north_west.png");
		map.put(Direction.NORTH, "characters/farmer/north.png");
		map.put(Direction.NORTH_EAST, "characters/farmer/north_east.png");
		map.put(Direction.EAST, "characters/farmer/east.png");
		map.put(Direction.SOUTH_EAST, "characters/farmer/south_east.png");
		map.put(Direction.SOUTH, "characters/farmer/south.png");
		map.put(Direction.SOUTH_WEST, "characters/farmer/south_west.png");
		return map;
	}
}
