package com.victor.main;

import com.victor.entities.Enemy1;
import com.victor.entities.Enemy2;
import com.victor.entities.Entity;
import com.victor.world.World;

public class EnemySpawn {
	
	public int targetTimeEnemy1 = 60 * 2;
	public int targetTimeEnemy2 = 60 * 4;
	public int curTimeEn1 = 0;
	public int curTimeEn2 = 0;

	
	public void tick() {
		curTimeEn1++;
		curTimeEn2++;
		
		// SPAWN ENEMY1
		if(curTimeEn1 == targetTimeEnemy1) {
			curTimeEn1 = 0;

			int xx = Entity.rand.nextInt(Game.WIDTH - 16);	// -16 para nao sair da tela
			int yy = 0;
	
			Enemy1 enemy1 = new Enemy1(xx, yy, 16, 16, 0.5, Entity.ENEMY1);
			Game.entities.add(enemy1);
		}
		
		// SPAWN ENEMY2
		else if(curTimeEn2 == targetTimeEnemy2) {
			curTimeEn2 = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);	// -16 para nao sair da tela
			int yy = 0;
		
			Enemy2 enemy2 = new Enemy2(xx, yy, 16, 16, 0.2, Entity.ENEMY2);
			Game.entities.add(enemy2);
		}
	}

}
