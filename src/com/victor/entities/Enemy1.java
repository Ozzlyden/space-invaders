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
	
	

	public Enemy1(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, null);
		// TODO Auto-generated constructor stub
		
	}

	public void tick() {
		// CAMADA DE RENDER
		depth = 2;
		
			
	}
	
	public boolean test(){
		return false;
	}
	
	public void render(Graphics g) {
		
	}
}
