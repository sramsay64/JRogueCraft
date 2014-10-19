package com.openThid.ncmmh.world;

/**
 * @author Scott Ramsay
 * Mutable class that stores information about what square of tiles should be drawn
 */
public class View {

	private int x;
	private int y;
	private int xSize;
	private int ySize;

	public View(int x, int y, int xSize, int ySize) {
		this.x = x;
		this.y = y;
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public View translate(int x, int y) {
		return new View(getX()+x, getY()+y, getXSize(), getYSize());
	}
}