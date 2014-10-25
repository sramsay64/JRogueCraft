package com.openThid.ncmmh.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.openThid.ncmmh.Main;

public class ImageUtil {

	public static Image getImageSafe(String name) {
		try {
			return new Image("res/" + name);
		} catch (SlickException e) {
			Error error = new Error(e);
			Main.main.getLogger().error("Image not Found: {}", error);
			throw error;
		}
	}
}