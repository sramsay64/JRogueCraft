package com.openThid.ncmmh.world;

import org.lwjgl.util.Point;
import org.newdawn.slick.Image;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Tile.MatterType;

public class TileTemplate {

	private Image image;
	private MatterType type;
	private String name;

	public TileTemplate(String image, String name) {
		this(image, name, MatterType.Solid);
	}

	public TileTemplate(Image image, String name) {
		this(image, name, MatterType.Solid);
	}

	public TileTemplate(String image, String name, MatterType type) {
		this(ImageUtil.getImage(image), name, type);
	}

	public TileTemplate(Image image, String name, MatterType type) {
		this.image = image;
		this.name = name;
		this.type = type;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public MatterType getType() {
		return type;
	}

	public Tile make(Level level, Point position) {
		return new Tile(image, type, level, position);
	}
}