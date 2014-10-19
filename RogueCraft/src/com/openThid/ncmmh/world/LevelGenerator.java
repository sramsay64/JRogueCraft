package com.openThid.ncmmh.world;

import java.util.Random;

import org.lwjgl.util.Point;

public class LevelGenerator {

	private Tile[][] tiles;
	@SuppressWarnings("unused")
	private Random random;

	public LevelGenerator(Random random, TileTemplate[] possibleTiles, int x, int y, Level level) {
		tiles = new Tile[y][x];
		for (int ix = 0; ix < tiles.length; ix++) {
			for (int iy = 0; iy < tiles[ix].length; iy++) {
				tiles[ix][iy] = possibleTiles[random.nextInt(possibleTiles.length)].make(level, new Point(ix, iy));
			}
		}
	}

	public Tile[][] getTiles() {
		return tiles;
	}
}