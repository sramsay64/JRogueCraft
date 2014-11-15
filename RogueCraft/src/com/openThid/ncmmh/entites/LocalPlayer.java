package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;

import com.openThid.ncmmh.Main;
import com.openThid.ncmmh.world.Level;

public class LocalPlayer extends Player implements InputProviderListener {

	private Command left;
	private Command right;
	private Command up;
	private Command down;

	/**
	 * P1, P2, etc.
	 */
	private int number;

	public LocalPlayer(Point location, Level level, String nick, Command left, Command right, Command up, Command down) {
		super(location, level, nick, "localhost");
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		Main.main.getLogger().info("new local player: P{}", number);
	}

	public void controlPressed(Command command) {
		if (command == left) {
			safeTranslate(-1, 0);
		} else if (command == right) {
			safeTranslate(1, 0);
		} else if (command == up) {
			safeTranslate(0, -1);
		} else if (command == down) {
			safeTranslate(0, 1);
		}
	}

	@Override
	public void controlReleased(Command command) {
	}

	public Command getLeft() {
		return left;
	}

	public Command getRight() {
		return right;
	}

	public Command getUp() {
		return up;
	}

	public Command getDown() {
		return down;
	}

	public int getNumber() {
		return number;
	}
}