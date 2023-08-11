package com.victor.main;

import java.awt.Color;
import java.awt.Graphics;

import com.victor.world.Camera;
import com.victor.world.FloorTile;
import com.victor.world.Tile;
import com.victor.world.WallTile;
import com.victor.world.World;

public class Inventory {
	
	public int selected = 0; 
	public boolean isPressed = false;
	public boolean isPlaceItem = false;
	public int mx, my;
	
	public String[] itens = {"grama", "terra", "neve", "areia", "ar", ""};	// Itens do inventario
	public int inventoryBoxSize = 45;
	public int inicialPosition = ((Game.WIDTH * Game.SCALE ) / 2) - ((itens.length * inventoryBoxSize) / 2); 

		
	public void tick() {
		
		// LOGICA DE SELECAO DE ITENS
		if(isPressed) {
			isPressed = false;
			
			// Demarcando area de selecao
			if(mx >= inicialPosition && mx < inicialPosition + (inventoryBoxSize * itens.length)) {
				if(my >= Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1 && my <  Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1 + inventoryBoxSize ) {
					selected = (int)(mx - inicialPosition) /inventoryBoxSize;
				}
			}
		}	
		
		// LOGICA PARA COLOCAR ITEM
		if(isPlaceItem) {
			isPlaceItem = false;
			mx = (int)mx / Game.SCALE + Camera.x;
			my = (int)my / Game.SCALE + Camera.y;
			
			int tilex = mx/World.TILE_SIZE;
			int tiley = my/World.TILE_SIZE;
			
			if(World.tiles[tilex + tiley * World.WIDTH].solid == false) {
				
				if(itens[selected] == "grama") {
					World.tiles[tilex + tiley * World.WIDTH] = new WallTile(tilex*16, tiley*16, Tile.TILE_GRAMA);
				}else if(itens[selected] == "terra") {
					World.tiles[tilex + tiley * World.WIDTH] = new WallTile(tilex*16, tiley*16, Tile.TILE_TERRA);
				}else if(itens[selected] == "ar") {
					World.tiles[tilex + tiley * World.WIDTH] = new FloorTile(tilex*16, tiley*16, Tile.TILE_DIA);
				}else if(itens[selected] == "neve") {
					World.tiles[tilex + tiley * World.WIDTH] = new WallTile(tilex*16, tiley*16, Tile.TILE_NEVE);
				}else if(itens[selected] == "areia") {
					World.tiles[tilex + tiley * World.WIDTH] = new WallTile(tilex*16, tiley*16, Tile.TILE_AREIA);
				}
				
				// Verficacao para nao colocar em cima do player
				if(World.isFree(Game.player.getX(), Game.player.getY()) ==  false) {
					World.tiles[tilex + tiley * World.WIDTH] = new FloorTile(tilex*16, tiley*16, Tile.TILE_DIA);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		// SELECIONAR ITENS RENDER
		for(int i = 0; i < itens.length; i++) {
			g.setColor(Color.gray);
			g.fillRect(inicialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1, inventoryBoxSize, inventoryBoxSize);
			g.setColor(Color.black);
			g.drawRect(inicialPosition + (i * inventoryBoxSize) + 1, Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1, inventoryBoxSize, inventoryBoxSize);
			
			if(itens[i] == "grama") {
				g.drawImage(Tile.TILE_GRAMA,inicialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}else if (itens[i] == "terra"){
				g.drawImage(Tile.TILE_TERRA,inicialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}else if (itens[i] == "ar"){
				g.drawImage(Tile.TILE_DIA,inicialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}else if (itens[i] == "neve"){
				g.drawImage(Tile.TILE_NEVE,inicialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}else if (itens[i] == "areia"){
				g.drawImage(Tile.TILE_AREIA,inicialPosition + (i * inventoryBoxSize) + 7, Game.HEIGHT * Game.SCALE - inventoryBoxSize + 7, 32, 32, null);
			}
			
			
			// SELECIONAR ITENS RENDER
			if(selected == i) {
				g.setColor(Color.red);
				g.drawRect(inicialPosition + (i * inventoryBoxSize), Game.HEIGHT * Game.SCALE - inventoryBoxSize - 1, inventoryBoxSize, inventoryBoxSize);
			}
		}
	}

}
