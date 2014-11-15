package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;

import com.openThid.ncmmh.util.ImageUtil;
import com.openThid.ncmmh.world.Level;

public class Player extends Entity {

	private String name;
	private String nick;

	public Player(Point location, Level level, String nick, String host) {
		super(location, level);
		setImage(ImageUtil.getImageSafe("player.png"));
		this.nick = nick;
		this.name = host;
	}

	public String getName() {
		return name;
	}

	public String GetNick() {
		return nick;
	}
}