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
	
	public int life = 3;
	
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
		
		// LOGICA DE MOVIMENTACAO
		y+=speed;
		
		// OTIMISACAO
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Player.lifePlayer--;
			return;
		}
		
		// SISTEMA DE DANO
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Bullet) {
				if(Entity.isColliding(this, e)) {
					life--;
					Game.entities.remove(e);
					isDamaged = true;
					if(life == 0) {
						Game.score++;
						Game.entities.remove(this);
						return;
					}
				}
			}
		}
		
	
		//LOGICA ANIMACAO
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index > maxIndex) {
				index = 0;
			}
		}
		
		//FEEDBACK DANO
		if(isDamaged) {
			this.damageCurrent++;
			if(this.damageCurrent == this.damageFrames) {
				this.damageCurrent = 0;
				this.isDamaged = false;
			}
		}
	
		
	}
	

	
	public void render(Graphics g) {
		if(!isDamaged) {
			g.drawImage(ENEMY1[index],this.getX() - Camera.x, this.getY() - Camera.y, null);
		}else{
			g.drawImage(ENEMY1_FEEDBACK[0],this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
	}
	
}
