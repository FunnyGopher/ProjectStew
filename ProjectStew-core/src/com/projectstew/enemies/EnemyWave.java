package com.projectstew.enemies;

import java.util.ArrayList;
import java.util.List;

public class EnemyWave {
	
	private int numberOfEnemies;
	private List<Enemy> enemyList;
	
	public EnemyWave(int numberOfEnemies) {
		enemyList = new ArrayList<Enemy>();
		this.numberOfEnemies = numberOfEnemies;
	}
	
	public int getNumEnemies() {
		return this.numberOfEnemies;
	}
	
	public void setNumEnemies(int numberOfEnemies) {
		this.numberOfEnemies = numberOfEnemies;
	}
}
