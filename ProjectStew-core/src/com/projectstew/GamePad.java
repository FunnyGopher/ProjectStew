package com.projectstew;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GamePad extends ApplicationAdapter implements ControllerListener{

	private SpriteBatch batch;
	private Texture img;
	private BitmapFont font;
	private boolean hasControllers = true;
	private String message = "Please install a controller.";
	private Sprite sprite;
	private Texture spriteTexture;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		spriteTexture = new Texture(Gdx.files.internal("PStew_Carrot.png"));
		sprite = new Sprite(spriteTexture);
		
		Controllers.addListener(this);
		
		if(Controllers.getControllers().size == 0){
			hasControllers = false;
		}
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		spriteTexture.dispose();
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/*if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(-1f);
			else
				sprite.translateX(-10.0f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				sprite.translateX(1f);
			else
				sprite.translateX(10.0f);
		}*/
		
		batch.begin();
		if(!hasControllers)
			font.draw(batch, message,
					Gdx.graphics.getWidth()/2 - font.getBounds(message).width/2,
					Gdx.graphics.getHeight()/2 - font.getBounds(message).height/2);
		else
			batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getOriginX(), sprite.getOriginY(),
					sprite.getWidth(), sprite.getHeight(),
					sprite.getScaleX(),sprite.getScaleY(), sprite.getRotation());
		//sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//batch.draw(img, 0, 0);
		//font.draw(batch, "Hello World", 300, 250);
		batch.end();
	}
	
	@Override
	public void connected(Controller controller){
		hasControllers = true;
	}
	
	@Override
	public void disconnected(Controller controller){
		hasControllers = false;
	}
	
	@Override
	public boolean buttonDown(Controller controller, int buttonCode){
		if(buttonCode == XBox360Pad.BUTTON_Y)
            sprite.setY(sprite.getY() + 1);
        if(buttonCode == XBox360Pad.BUTTON_A)
            sprite.setY(sprite.getY()-1);
        if(buttonCode == XBox360Pad.BUTTON_X)
            sprite.setX(sprite.getX() - 1);
        if(buttonCode == XBox360Pad.BUTTON_B)
            sprite.setX(sprite.getX() + 1);

        if(buttonCode == XBox360Pad.BUTTON_LB)
            sprite.scale(-0.1f);
        if(buttonCode == XBox360Pad.BUTTON_RB)
            sprite.scale(0.1f);
        return false;
	}
	
	@Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }
	
	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value){
		// Analog Stick
		if(axisCode == XBox360Pad.AXIS_LEFT_X)
			sprite.translateX(10f * value);
		if(axisCode == XBox360Pad.AXIS_LEFT_Y)
			sprite.translateY(-10f * value);
		 if(axisCode == XBox360Pad.AXIS_RIGHT_X)
	            sprite.rotate(10f * value);
		 if(axisCode == XBox360Pad.AXIS_RIGHT_Y)
	            sprite.rotate(-10f * value);
		 return false;
	}
	
	@Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        // D-Pad
        if(value == XBox360Pad.BUTTON_DPAD_LEFT)
            sprite.translateX(-10f);
        if(value == XBox360Pad.BUTTON_DPAD_RIGHT)
            sprite.translateX(10f);
        if(value == XBox360Pad.BUTTON_DPAD_UP)
            sprite.translateY(10f);
        if(value == XBox360Pad.BUTTON_DPAD_DOWN)
            sprite.translateY(-10f);
        return false;
    }
	
	@Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }
	
}
