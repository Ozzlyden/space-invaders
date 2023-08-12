package com.victor.entities;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.victor.main.Game;
import com.victor.world.Camera;
import com.victor.world.FloorTile;
import com.victor.world.Tile;
import com.victor.world.WallTile;
import com.victor.world.World;

public class Enemy1 extends Entity{
	
	public boolean isDamaged = false;
	public int damageFrames = 8, damageCurrent = 0;
	private int frames = 0, maxFrames = 15, index = 0, maxIndex = 1;
	
	public BufferedImage[] ENEMY1;
	public BufferedImage[] ENEMY1_FEEDBACK;

	public Enemy1(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, null);
		// TODO Auto-generated constructor stub
		
		ENEMY1 = new BufferedImage[2];
		ENEMY1_FEEDBACK = new BufferedImage[2];
			
		ENEMY1[0] = Game.spritesheet.getSprite(0, 80, 16, 16);
		ENEMY1[1] = Game.spritesheet.getSprite(16, 80, 16, 16);
		ENEMY1_FEEDBACK[0] = Game.spritesheet.getSprite(0, 96, 16, 16);
		
	}

	public void tick() {
		// CAMADA DE RENDER
		depth = 2;
		
		y+=speed;
	
		//LOGICA ANIMACAO
		frames++;
		if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex)
					index = 0;
			}
	}
	
	public boolean test(){
		return false;
	}
	
	public void render(Graphics g) {
		if(!isDamaged)
			g.drawImage(ENEMY1[index],this.getX() - Camera.x, this.getY() - Camera.y, null);
			//g.drawImage(spriteEnemy2[index],this.getX() - Camera.x, this.getY() - Camera.y, null);
		else 
			g.drawImage(ENEMY1_FEEDBACK[0],this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}
