package com.projectstew;

import com.badlogic.gdx.utils.TimeUtils;

public class GameTime {
	
	private TimeUtils time;
	private long startTime;
	private long elapsedTime;
	
	public GameTime() {
		time = new TimeUtils();
		startTime = time.millis();
	}
	
	public long getElapsedTime() {
		return time.millis() - elapsedTime;
	}
	
	public long getTotalGameTime() {
		return time.millis() - startTime;
	}
	
	public void updateElapsedTime() {
		elapsedTime = time.millis();
	}
}
