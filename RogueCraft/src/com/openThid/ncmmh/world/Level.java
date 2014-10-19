package com.openThid.ncmmh.world;

import java.util.Random;

import org.newdawn.slick.Graphics;

public class Level {

	public static final int OVERWORLD = 0;
	public static final int NETHER = -1;

	private int type;
	private Tile[][] tiles;

	public Level(int type) {
		this(type, 100, 100);
	}

	public Level(int type, int x, int y) {
		this(type, null);
		tiles = new LevelGenerator(new Random(), new TileTemplate[]{Tiles.Dirt, Tiles.Grass}, x, y, this).getTiles();
	}

	public Level(int type, Tile[][] tiles) {
		this.type = type;
		this.tiles = tiles;
	}

	public int getType() {
		return type;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public Tile getTile(int x, int y) {
		return tiles[y][x];
	}

	public void setTile(Tile tile, int x, int y) {
		tiles[y][x] = tile;
	}

	public void render(Graphics g, int x, int y, int xSize, int ySize, float xPos, float yPos) {
		for (int yi = x; yi < ySize; yi++) {
			for (int xi = y; xi < xSize; xi++) {
//				System.out.println(tiles[yi][xi] + " @ " + tiles[yi][xi].getPosition());
				g.drawImage(tiles[yi][xi].getImage(), xPos+(xi*Tiles.TILE_WIDTH), yPos+(yi*Tiles.TILE_HEIGHT));
			}
		}
	}

	public void render(Graphics g, View view, float xPos, float yPos) {
		render(g, view.getX(), view.getY(), view.getXSize(), view.getYSize(), xPos, yPos);
	}
}