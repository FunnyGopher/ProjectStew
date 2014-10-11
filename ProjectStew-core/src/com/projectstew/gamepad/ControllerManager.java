package com.projectstew.gamepad;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

public class ControllerManager {
	
	List<Controller> controllers = new ArrayList<Controller>();
	
	public Controller getNextController() {
		Controller controller = null;
		
		for(int index = 0; index < Controllers.getControllers().size; index++) {
			Controller tempController = Controllers.getControllers().get(index);
			
			if(!controllers.contains(tempController)) {
				controllers.add(tempController);
				return tempController;
			}
		}
		
		return controller;
	}
	
	public boolean hasUnusedControllers() {
		return controllers.size() < Controllers.getControllers().size;
	}
}
