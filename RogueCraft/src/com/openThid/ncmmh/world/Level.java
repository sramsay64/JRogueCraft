package com.openThid.ncmmh.world;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.util.Point;
import org.newdawn.slick.Graphics;

import com.openThid.ncmmh.entites.Entity;

public class Level {

	public static final int OVERWORLD = 0;
	public static final int NETHER = -1;

	private int type;
	private Tile[][] tiles;
	private World world;
	private ArrayList<Entity> entities;

	public Level(int type) {
		this(type, 100, 100);
	}

	public Level(int type, int x, int y) {
		this.type = type;
		LevelGenerator generator = new LevelGenerator(new Random(),
				new TileTemplate[]{Tiles.Dirt, Tiles.Grass},
				new int[]{1, 9}, x, y, this);
		this.tiles = generator.getTiles();
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

	public Tile getTile(Point p) {
		return getTile(p.getX(), p.getY());
	}

	public World getWorld() {
		return world;
	}

	public ArrayList<Entity> getEntities() {
		if (entities == null) {
			entities = getWorld().getEntities();
		}
		return entities;
	}

	public boolean isEmpty(Point p) {
		for (int i = 0; i < getEntities().size(); i++) {
			if (getEntities().get(i).getLocation().equals(p)) {
				return false;
			}
		}
		return true;
	}

	public void setTile(Tile tile, int x, int y) {
		tiles[y][x] = tile;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public boolean addEntity(Entity e) {
		return entities.add(e);
	}

	public void render(Graphics g, int x, int y, int xSize, int ySize, float xPos, float yPos) {
		for (int yi = x; yi < ySize; yi++) {
			for (int xi = y; xi < xSize; xi++) {
				g.drawImage(tiles[yi][xi].getImage(), xPos+(xi*Tiles.TILE_WIDTH), yPos+(yi*Tiles.TILE_HEIGHT));
			}
		}
	}

	public void render(Graphics g, View view, float xPos, float yPos) {
		render(g, view.getX(), view.getY(), view.getXSize(), view.getYSize(), xPos, yPos);
	}

	public boolean isEmpty(int x, int y) {
		return isEmpty(new Point(x, y));
	}
}