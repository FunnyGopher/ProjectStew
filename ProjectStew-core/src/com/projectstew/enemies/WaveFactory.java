package com.projectstew.enemies;

import java.util.Random;

public class WaveFactory {
	
	public WaveFactory() {
		
	}
	
	private static int waveSizeGenerator(int waveNumber) {
		Random generator = new Random();
		int waveSize = generator.nextInt(waveNumber) + waveNumber + 4;
		
		return waveSize;
	}
	
	public static EnemyWave createWave(int waveNumber) {
		return new EnemyWave(waveSizeGenerator(waveNumber));	
	}
	
}
