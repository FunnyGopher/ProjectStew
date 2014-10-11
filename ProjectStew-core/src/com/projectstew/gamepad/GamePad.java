package com.projectstew.gamepad;

import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

public class GamePad implements ControllerListener {
	private static ControllerManager controllerManager = new ControllerManager();
	
	private final float DEAD_ZONE = 0.6f;
	
	private Controller controller;
	private boolean buttonY;
	private boolean buttonX;
	private boolean buttonA;
	private boolean buttonB;
	private boolean buttonLB;
	private boolean buttonRB;
	
	private Axis leftAxis = new Axis();
	private Axis rightAxis = new Axis();
	

	public GamePad() {
		Controllers.addListener(this);
		controller = controllerManager.getNextController();
	}
	
	// This method must be implemented for a GamePad to exist
	@Override
	public void connected(Controller controller){
	}
	
	// This method must be implemented for a GamePad to exist
	@Override
	public void disconnected(Controller controller) {
	}
	
	
	@Override
	public boolean buttonDown(Controller controller, int buttonCode){
		if(controller == this.controller) {
			buttonY = (buttonCode == XBox360Pad.BUTTON_Y);
	        buttonA = (buttonCode == XBox360Pad.BUTTON_A);
	        buttonX = (buttonCode == XBox360Pad.BUTTON_X);
	        buttonB = (buttonCode == XBox360Pad.BUTTON_B);
	        buttonLB = (buttonCode == XBox360Pad.BUTTON_LB);
	        buttonRB = (buttonCode == XBox360Pad.BUTTON_RB);
		}
        return false;
	}
	
	@Override
    public boolean buttonUp(Controller controller, int buttonCode) {
		if(controller == this.controller) {
			buttonY = !(buttonCode == XBox360Pad.BUTTON_Y);
	        buttonA = !(buttonCode == XBox360Pad.BUTTON_A);
	        buttonX = !(buttonCode == XBox360Pad.BUTTON_X);
	        buttonB = !(buttonCode == XBox360Pad.BUTTON_B);
	        buttonLB = !(buttonCode == XBox360Pad.BUTTON_LB);
	        buttonRB = !(buttonCode == XBox360Pad.BUTTON_RB);
		}
        return false;
    }
	
	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value){		
		if(controller == this.controller) {
			if(controller.getAxis(XBox360Pad.AXIS_LEFT_X) > DEAD_ZONE  || controller.getAxis(XBox360Pad.AXIS_LEFT_X) < -DEAD_ZONE)
				leftAxis.setX(controller.getAxis(XBox360Pad.AXIS_LEFT_X) * 1f);
			else
				leftAxis.setX(0);
			
			if(controller.getAxis(XBox360Pad.AXIS_LEFT_Y) > DEAD_ZONE  || controller.getAxis(XBox360Pad.AXIS_LEFT_Y) < -DEAD_ZONE)
				leftAxis.setY(controller.getAxis(XBox360Pad.AXIS_LEFT_Y) * -1f);
			else
				leftAxis.setY(0);
		}
		
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

	public boolean isButtonY() {
		return buttonY;
	}

	public boolean isButtonX() {
		return buttonX;
	}

	public boolean isButtonA() {
		return buttonA;
	}

	public boolean isButtonB() {
		return buttonB;
	}

	public boolean isButtonLB() {
		return buttonLB;
	}

	public boolean isButtonRB() {
		return buttonRB;
	}

	public Axis getLeftAxis() {
		return leftAxis;
	}

	public Axis getRightAxis() {
		return rightAxis;
	}
	
    
}
