package com.victor.main;

import com.victor.entities.Enemy1;
import com.victor.entities.Entity;
import com.victor.world.World;

public class EnemySpawn {
	
	public int targetTime = 60 * 2;
	public int curTime = 0;
	
	public void tick() {
		curTime++;
		
		// SPAWN ENEMY1
		if(curTime == targetTime) {
			curTime = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);	// -16 para nao sair da tela
			int yy = 0;
	
			Enemy1 enemy1 = new Enemy1(xx, yy, 16, 16, 0.5, Entity.ENEMY1);
			Game.entities.add(enemy1);
		}
	}

}
