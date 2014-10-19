package com.openThid.ncmmh.world;

import com.openThid.ncmmh.world.Tile.MatterType;

public class Tiles {

	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;

	public static final TileTemplate Grass = new TileTemplate(
			"tiles/crawl-tiles/dc-dngn/floor/grass/grass0.png", "Grass", MatterType.Solid);
	public static final TileTemplate Dirt = new TileTemplate(
			"tiles/crawl-tiles/dc-dngn/floor/dirt0.png", "Dirt", MatterType.Solid);

	public static final TileTemplate[] SOLID = {Grass, Dirt};
	public static final TileTemplate[] LIQUID = {Grass, Dirt};
	public static final TileTemplate[] GAS = {Grass, Dirt};

	private Tiles(){}
}