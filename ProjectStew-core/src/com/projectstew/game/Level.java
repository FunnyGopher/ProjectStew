package com.projectstew.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.projectstew.GameObject;
import com.projectstew.player.PlayerManager;

public class Level implements GameObject{
	private String tmxFileName;
	private TiledMap tiledMap;
	private OrthographicCamera camera;
	private TiledMapRendererWithSprites tiledMapRenderer;
	
	private PlayerManager players;
		
	public Level(String tmxFileName) {
		players = new PlayerManager();
		
		this.tmxFileName = tmxFileName;
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 1000);
		camera.update();
		this.tiledMap = new TmxMapLoader().load(this.tmxFileName);
		this.tiledMapRenderer = new TiledMapRendererWithSprites(tiledMap);
	}

	@Override
	public void update(GameTime gameTime) {
		camera.update();
		players.update(gameTime);
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		players.draw(spriteBatch);
	}
	
	public void drawLevel() {
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	}
}
