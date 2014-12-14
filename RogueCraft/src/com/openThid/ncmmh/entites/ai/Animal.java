package com.openThid.ncmmh.entites.ai;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.world.Level;

public abstract class Animal extends AI {

	public Animal(Point location, Level level) {
		super(location, level);
	}
}