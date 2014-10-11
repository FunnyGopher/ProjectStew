package com.projectstew;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	GameTime time;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		time = new GameTime();
	}

	@Override
	public void render() {
		update(time);
		
		batch.begin();
		draw(batch);
		batch.end();
	}
	
	private void update(GameTime gameTime) {
		// Other things go here to update!
	}
	
	private void draw(SpriteBatch spriteBatch) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Other things go here to draw!
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
