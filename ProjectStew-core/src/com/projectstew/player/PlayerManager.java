package com.projectstew.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectstew.GameObject;
import com.projectstew.game.GameTime;
import com.projectstew.gamepad.GamePad;

public class PlayerManager implements GameObject {
	
	Player player1, player2, player3, player4;
	GamePad gamePad1, gamePad2, gamePad3, gamePad4;
	
	public PlayerManager() {
		gamePad1 = new GamePad();
		gamePad2 = new GamePad();
		gamePad3 = new GamePad();
		gamePad4 = new GamePad();
		
		player1 = new Player(100, 100, new Texture(Gdx.files.internal("Gengar.png")), gamePad1);
		player2 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Carrot.png")), gamePad2);
		player3 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Stick.png")), gamePad3);
		player4 = new Player(200, 200, new Texture(Gdx.files.internal("PStew_Potato.png")), gamePad4);
	}

	@Override
	public void update(GameTime gameTime) {
		player1.update(gameTime);
		player2.update(gameTime);
		player3.update(gameTime);
		player4.update(gameTime);
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		player1.draw(spriteBatch);
		player2.draw(spriteBatch);
		player3.draw(spriteBatch);
		player4.draw(spriteBatch);
	}
}
