package com.projectstew.player;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.projectstew.gamepad.GamePad;
import com.projectstew.graphic.Direction;

public class Player extends Sprite {

	private GamePad gamepad;
	private Role role;
	private Map<Direction, String> imgMap;

	private Vector2 velocity = new Vector2();
	private float speed = 32 * 2;

	public Player(float x, float y, Texture texture, GamePad gamePad) {
		super(new Sprite(texture));
		setPosition(x, y);
		this.gamepad = gamePad;
	}

	public Player(float x, float y, Role role, GamePad gamePad) {
		super(new Sprite(new Texture(
				Gdx.files.internal("characters/Unknown.png"))));
		setPosition(x, y);
		this.gamepad = gamePad;
	}

	public Player(Sprite sprite, GamePad gamepad) {
		super(sprite);
		this.gamepad = gamepad;
	}

	public void update(float delta, TiledMapTileLayer collisionLayer) {
		if (gamepad.getLeftAxis().getX() < 0
				& gamepad.getLeftAxis().getY() == 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.WEST))));

		if (gamepad.getLeftAxis().getX() < 0 & gamepad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.NORTH_WEST))));

		if (gamepad.getLeftAxis().getX() == 0
				& gamepad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.NORTH))));

		if (gamepad.getLeftAxis().getX() > 0 & gamepad.getLeftAxis().getY() > 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.NORTH_EAST))));

		if (gamepad.getLeftAxis().getX() > 0
				& gamepad.getLeftAxis().getY() == 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.EAST))));

		if (gamepad.getLeftAxis().getX() > 0 & gamepad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.SOUTH_EAST))));

		if (gamepad.getLeftAxis().getX() == 0
				& gamepad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.SOUTH))));

		if (gamepad.getLeftAxis().getX() < 0 & gamepad.getLeftAxis().getY() < 0)
			setTexture(new Texture(Gdx.files.internal(imgMap
					.get(Direction.SOUTH_WEST))));

		velocity.x = gamepad.getLeftAxis().getX() * 5;
		if (gamepad.getLeftAxis().getX() == 0)
			velocity.x = 0;

		velocity.y = gamepad.getLeftAxis().getY() * 5;
		if (gamepad.getLeftAxis().getY() == 0)
			velocity.y = 0;

		float oldX = getX(), oldY = getY();
		boolean collideX = false, collideY = false;
		float tileWidth = collisionLayer.getWidth();
		float tileHeight = collisionLayer.getTileHeight();

		// Set player's new x position
		setX(getX() + velocity.x * delta * speed);

		// Check for collisions in the x axis
		if (velocity.x < 0) {

			collideX = isCellBlocked(collisionLayer.getCell(
					(int) (getX() / tileWidth), (int) (getY() + getHeight()
							/ tileHeight)));

			if (!collideX) {
				collideX = isCellBlocked(collisionLayer.getCell(
						(int) (getX() / tileWidth),
						(int) ((getY() + getHeight() / 2) / tileHeight)));
			}

			if (!collideX) {
				collideX = isCellBlocked(collisionLayer
						.getCell((int) (getX() / tileWidth),
								(int) (getY() / tileHeight)));
			}
		} else if (velocity.x > 0) {
			collideX = isCellBlocked(collisionLayer.getCell(
					(int) ((getX() + getWidth()) / tileWidth),
					(int) ((getY() + getHeight()) / tileHeight)));

			if (!collideX) {
				collideX = isCellBlocked(collisionLayer.getCell(
						(int) ((getX() + getWidth()) / tileWidth),
						(int) ((getY() + getHeight() / 2) / tileHeight)));
			}

			if (!collideX) {
				collideX = isCellBlocked(collisionLayer.getCell(
						(int) ((getX() + getWidth()) / tileWidth),
						(int) (getY() / tileHeight)));
			}
		}

		if (collideX) {
			setX(oldX); // Set back to oldX
			velocity.x = 0;
			collideX = false;
		}

		// Set player's new y position
		setY(getY() + velocity.y * delta * speed);

		// Check for collisions in the y axis
		if (velocity.y < 0) {
			collideY = isCellBlocked(collisionLayer.getCell(
					(int) (getX() / tileWidth), (int) (getY() / tileHeight)));

			if (!collideY) {
				collideY = isCellBlocked(collisionLayer.getCell(
						(int) (((getX() + getWidth()) / 2) / tileWidth),
						(int) (getY() / tileHeight)));
			}

			if (!collideY) {
				collideY = isCellBlocked(collisionLayer.getCell(
						(int) ((getX() + getWidth()) / tileWidth),
						(int) (getY() / tileHeight)));
			}

		} else if (velocity.y > 0) {
			collideY = isCellBlocked(collisionLayer.getCell(
					(int) (getX() / tileWidth),
					(int) ((getY() + getHeight()) / tileHeight)));

			if (!collideY) {
				collideY = isCellBlocked(collisionLayer.getCell(
						(int) (((getX() + getWidth()) / 2) / tileWidth),
						(int) ((getY() + getHeight()) / tileHeight)));
			}

			if (!collideY) {
				collideY = isCellBlocked(collisionLayer.getCell(
						(int) ((getX() + getWidth()) / tileWidth),
						(int) ((getY() + getHeight()) / tileHeight)));
			}

			if (collideY) {
				setY(oldY); // Set back to oldX
				velocity.y = 0;
				collideY = false;
			}
		}
	}

	public void draw(Batch batch, TiledMapTileLayer collisionLayer) {
		update(Gdx.graphics.getDeltaTime(), collisionLayer);
		super.draw(batch);
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public boolean isCellBlocked(Cell cell) {
		return cell != null && cell.getTile() != null
				&& cell.getTile().getProperties().containsKey("Blocked");
	}

	public void setImgMap(Map<Direction, String> imgMap) {
		this.imgMap = imgMap;
		setTexture(new Texture(Gdx.files.internal(imgMap.get(Direction.SOUTH))));
	}
}
