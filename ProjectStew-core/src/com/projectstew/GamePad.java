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

public class GamePad implements ControllerListener {

	private boolean hasControllers = true;
	
	private boolean buttonY;
	private boolean buttonX;
	private boolean buttonA;
	private boolean buttonB;
	private boolean buttonLB;
	private boolean buttonRB;
	
	private Axis leftAxis;
	private Axis rightAxis;
	

	public GamePad() {
		Controllers.addListener(this);
		
		if(Controllers.getControllers().size == 0){
			hasControllers = false;
		}
	}

	public void dispose() {
		
	}
	
	// This method must be implemented for a GamePad to exist
	@Override
	public void connected(Controller controller){
		hasControllers = true;
	}
	
	// This method must be implemented for a GamePad to exist
	@Override
	public void disconnected(Controller controller){
		hasControllers = false;
	}
	
	
	@Override
	public boolean buttonDown(Controller controller, int buttonCode){
		
		buttonY = (buttonCode == XBox360Pad.BUTTON_Y);
        buttonA = (buttonCode == XBox360Pad.BUTTON_A);
        buttonX = (buttonCode == XBox360Pad.BUTTON_X);
        buttonB = (buttonCode == XBox360Pad.BUTTON_B);
        buttonLB = (buttonCode == XBox360Pad.BUTTON_LB);
        buttonRB = (buttonCode == XBox360Pad.BUTTON_RB);
        
        return false;
	}
	
	@Override
    public boolean buttonUp(Controller controller, int buttonCode) {
		buttonY = !(buttonCode == XBox360Pad.BUTTON_Y);
        buttonA = !(buttonCode == XBox360Pad.BUTTON_A);
        buttonX = !(buttonCode == XBox360Pad.BUTTON_X);
        buttonB = !(buttonCode == XBox360Pad.BUTTON_B);
        buttonLB = !(buttonCode == XBox360Pad.BUTTON_LB);
        buttonRB = !(buttonCode == XBox360Pad.BUTTON_RB);
        
        return false;
    }
	
	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value){
		// Analog Stick
		/*if(axisCode == XBox360Pad.AXIS_LEFT_X)
			sprite.translateX(10f * value);
		if(axisCode == XBox360Pad.AXIS_LEFT_Y)
			sprite.translateY(-10f * value);*/
		
		 if(controller.getAxis(XBox360Pad.AXIS_LEFT_X) > 0.2f  || 
                 controller.getAxis(XBox360Pad.AXIS_LEFT_X) < -0.2f)
            leftAxis.setX(controller.getAxis(XBox360Pad.AXIS_LEFT_X) * 10f);
         if(controller.getAxis(XBox360Pad.AXIS_LEFT_Y) > 0.2f  || 
                 controller.getAxis(XBox360Pad.AXIS_LEFT_Y) < -0.2f)
             leftAxis.setY(controller.getAxis(XBox360Pad.AXIS_LEFT_Y) * -10f);
         
		 return false;
	}
	
	
	@Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        // D-Pad
        /*if(value == XBox360Pad.BUTTON_DPAD_LEFT)
            sprite.translateX(-10f);
        if(value == XBox360Pad.BUTTON_DPAD_RIGHT)
            sprite.translateX(10f);
        if(value == XBox360Pad.BUTTON_DPAD_UP)
            sprite.translateY(10f);
        if(value == XBox360Pad.BUTTON_DPAD_DOWN)
            sprite.translateY(-10f);*/
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
    

	public void setHasControllers(boolean hasControllers) {
		this.hasControllers = hasControllers;
	}

	public void setButtonY(boolean buttonY) {
		this.buttonY = buttonY;
	}

	public void setButtonX(boolean buttonX) {
		this.buttonX = buttonX;
	}

	public void setButtonA(boolean buttonA) {
		this.buttonA = buttonA;
	}

	public void setButtonB(boolean buttonB) {
		this.buttonB = buttonB;
	}

	public void setButtonLB(boolean buttonLB) {
		this.buttonLB = buttonLB;
	}

	public void setButtonRB(boolean buttonRB) {
		this.buttonRB = buttonRB;
	}

	public void setLeftAxis(Axis leftAxis) {
		this.leftAxis = leftAxis;
	}

	public void setRightAxis(Axis rightAxis) {
		this.rightAxis = rightAxis;
	}
	
    
}
