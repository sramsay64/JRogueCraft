package com.openThid.ncmmh.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageUtil {

	public static Image getImage(String name) {
		try {
			return new Image("res/" + name);
		} catch (SlickException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}
}