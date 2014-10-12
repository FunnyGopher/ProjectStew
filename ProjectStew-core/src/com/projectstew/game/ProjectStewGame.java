package com.projectstew.game;

import com.badlogic.gdx.Game;
import com.projectstew.screens.Splash;

public class ProjectStewGame extends Game {
	
	public static final String TITLE = "Project Stew", VERSION = "Clam Chowder";
	
	@Override
	public void create () {
		setScreen(new Splash());
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
