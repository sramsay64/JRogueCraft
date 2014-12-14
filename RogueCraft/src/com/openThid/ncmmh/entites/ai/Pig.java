package com.openThid.ncmmh.entites.ai;

import java.util.Random;

import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Level;

public class Pig extends Animal {

	private static Image image;
	private Random random;

	public Pig(Point location, Level level, Random random) {
		super(location, level);
		this.random = random;
		setImage(loadImage());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg) {
		super.update(gc, sbg);
		int[] xDirs = new int[]{0, 1,-1, 0, 0};
		int[] yDirs = new int[]{0, 0, 0, 1,-1};
		int dir = random.nextInt(xDirs.length);
		translate(xDirs[dir], yDirs[dir]);
	}

	private static Image loadImage() {
		if (image == null) {
			image = ImageUtil.getImageSafe("tiles/crawl-tiles/dc-mon/animals/hog.png");
		}
		return image;
	}
}