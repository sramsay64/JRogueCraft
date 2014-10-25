package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Level;

public class Player extends Entity {

	private String name;

	public Player(Point location, Level level) {
		super(location, level);
		setImage(ImageUtil.getImageSafe("player.png"));
	}

	public String getName() {
		return name;
	}
}