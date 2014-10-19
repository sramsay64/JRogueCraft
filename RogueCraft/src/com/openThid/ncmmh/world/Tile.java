package com.openThid.ncmmh.world;

import org.lwjgl.util.Point;
import org.newdawn.slick.Image;

public class Tile {

	public enum MatterType {
		Solid,
		Liquid,
		Gas;
	}

	private Image image;
	private MatterType type;
	private Level level;
	private Point position;

	public Tile(Image image, MatterType type, Level level, Point position) {
		this.image = image;
		this.type = type;
		this.level = level;
		this.position = position;
	}

	public Image getImage() {
		return image;
	}

	public MatterType getType() {
		return type;
	}

	public Level getLevel() {
		return level;
	}

	public Point getPosition() {
		return position;
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getWidth() {
		return image.getWidth();
	}
}