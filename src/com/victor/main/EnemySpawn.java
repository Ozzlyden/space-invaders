package com.victor.main;

import com.victor.entities.Enemy1;
import com.victor.entities.Entity;
import com.victor.world.World;

public class EnemySpawn {
	
	public int interval = 60 * 1;
	public int curTime = 0;
	
	public void tick() {
		curTime++;
		if(curTime == interval) {
			curTime = 0;
			int xinicial = Entity.rand.nextInt(World.WIDTH * 16 - 32) + 16;
			Enemy1 enemy1 = new Enemy1(xinicial, 16, 16, 16, 0.5, Entity.ENEMY1);
			Game.entities.add(enemy1);
		}
	}

}
