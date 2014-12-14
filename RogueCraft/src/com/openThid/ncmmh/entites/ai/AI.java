package com.openThid.ncmmh.entites.ai;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.entites.Entity;
import com.openThid.ncmmh.world.Level;

public abstract class AI extends Entity {

	public AI(Point location, Level level) {
		super(location, level);
	}
}