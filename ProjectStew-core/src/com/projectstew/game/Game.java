package com.projectstew.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.player.PlayerManager;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	GameTime time;
	PlayerManager players;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		time = new GameTime();
		players = new PlayerManager();
	}

	@Override
	public void render() {
		update(time);
		
		batch.begin();
		draw(batch);
		batch.end();
	}
	
	private void update(GameTime gameTime) {
		players.update(gameTime);
	}
	
	private void draw(SpriteBatch spriteBatch) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		players.draw(spriteBatch);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
