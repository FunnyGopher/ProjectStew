package com.projectstew.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.gamepad.GamePad;
import com.projectstew.player.Player;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	GameTime time;
	GamePad gamePad;
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		time = new GameTime();
		gamePad = new GamePad();
		player = new Player(200, 200, new Texture(Gdx.files.internal("Gengar.png")), gamePad);
	}

	@Override
	public void render() {
		update(time);
		
		batch.begin();
		draw(batch);
		batch.end();
	}
	
	private void update(GameTime gameTime) {
		player.update(gameTime);
	}
	
	private void draw(SpriteBatch spriteBatch) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.draw(spriteBatch);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
