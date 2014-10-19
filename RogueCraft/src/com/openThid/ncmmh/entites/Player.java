package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.util.ImageUtil;

public class Player extends Entity {

	private String name;

	public Player(Point location) {
		super(location);
		setImage(ImageUtil.getImage("player.png"));
	}

	public String getName() {
		return name;
	}
}