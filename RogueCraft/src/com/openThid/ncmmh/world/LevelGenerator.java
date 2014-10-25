package com.openThid.ncmmh.world;

import java.util.Random;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.util.MathUtil;

public class LevelGenerator {

	private Tile[][] tiles;
	private Random random;
	private TileTemplate[] possibleTiles;
	private int[] tileChances;
	private int x;
	private int y;
	private Level level;

	public LevelGenerator(Random random, TileTemplate[] possibleTiles, int[] tileChances, int x, int y, Level level) {
		this.random = random;
		this.possibleTiles = possibleTiles;
		this.tileChances = tileChances;
		this.x = x;
		this.y = y;
		this.level = level;
	}

	public Tile[][] getTiles() {
		tiles = new Tile[y][x];
		for (int ix = 0; ix < tiles.length; ix++) {
			for (int iy = 0; iy < tiles[ix].length; iy++) {
				int rand = random.nextInt(MathUtil.sum(tileChances));
				int n = -1;
				int acc = 0;
				if (rand <= acc) {
					n = 0;
				}
				for (int i = 0; i < tileChances.length; i++) {
					acc += tileChances[i];
					if (n == -1 && rand <= acc) {
						n = i;
					}
				}
				tiles[ix][iy] = possibleTiles[n].make(level, new Point(ix, iy));
			}
		}
		return tiles;
	}
}