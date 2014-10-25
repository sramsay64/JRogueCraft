package com.openThid.ncmmh.entites.objects;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.entites.Entity;
import com.openThid.ncmmh.world.Level;

public abstract class InanimateObject extends Entity {

	public InanimateObject(Point location, Level level) {
		super(location, level);
	}
}