package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;
import org.newdawn.slick.Image;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Level;

public class Player extends Entity {

	private static Image image;

	private String name;
	private String nick;

	public Player(Point location, Level level, String nick, String host) {
		super(location, level);
		setImage(loadImage());
		this.nick = nick;
		this.name = host;
	}

	public String getName() {
		return name;
	}

	public String GetNick() {
		return nick;
	}

	private static Image loadImage() {
		if (image == null) {
			image = ImageUtil.getImageSafe("player.png");
		}
		return image;
	}
}