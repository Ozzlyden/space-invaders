package com.victor.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.victor.main.Game;
import com.victor.world.Camera;

public class Player extends Entity {
	
	public static boolean right, left, shoot, moved, isPressed, power;
	
	public int dir = 1;
	
	private int framesAnimation = 0;
	private int maxFrames = 15;
	private int maxSprite = 2;
	private int curSprite = 0;
	
	public BufferedImage[] PLAYER;
	public BufferedImage[] ATTACK_FEEDBACK;
	
	public Player(int x, int y, int width, int height,double speed, BufferedImage sprite) {
		super(x, y, width, height,speed, sprite);
		
		PLAYER = new BufferedImage[2];
		ATTACK_FEEDBACK = new BufferedImage[2];
			
		PLAYER[0] = Game.spritesheet.getSprite(0, 32, 16, 16);
		PLAYER[1] = Game.spritesheet.getSprite(16, 32, 16, 16);
		ATTACK_FEEDBACK[0] = Game.spritesheet.getSprite(0, 48, 16, 16);
	}
	
	public void tick() {
		// CAMADA DE RENDER
		depth = 2;
		moved = false;
		
		// MOVIMENTACAO
		if(right) {
			x+=speed;
			dir = 1;
			moved = true;
		}else if(left) {
			x-=speed;
			dir = -1;
			moved = true;
		}
		
		// MUDAR PLAYER PARA O OUTRO LADO DA TELA
		if(x >= Game.WIDTH) {
			x = -16;
		}else if(x + 16 < 0) {
			x = Game.WIDTH;
		}
		
		// LOGICA ANIMACAO
		if(moved == true) {
			framesAnimation++;
			if(framesAnimation == maxFrames) {
				curSprite++;
				framesAnimation = 0;
				if(curSprite == maxSprite) {
					curSprite = 0;
				}
			}	
		}
	}
	
	
		

	
	public void render(Graphics g) { 
			
		// MOVIMENTACAO
		if(moved == true) {
			sprite = PLAYER[0];
			sprite = PLAYER[curSprite];
		}

		super.render(g);
	}
}
