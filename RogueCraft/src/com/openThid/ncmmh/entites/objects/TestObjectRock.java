package com.openThid.ncmmh.entites.objects;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Level;

public class TestObjectRock extends InanimateObject {

	public TestObjectRock(Point location, Level level) {
		super(location, level);
		setImage(ImageUtil.getImageSafe("tiles/crawl-tiles/UNUSED/other/boulder.png"));
	}
}