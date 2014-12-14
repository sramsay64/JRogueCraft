package com.openThid.ncmmh.entites;

import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import com.openThid.ncmmh.world.Level;
import com.openThid.ncmmh.world.Tiles;
import com.openThid.ncmmh.world.View;

public abstract class Entity {

	private Point location;
	private Level level;
	private Image image;

	public Entity(Point location, Level level) {
		setLocation(location);
		setLevel(level);
	}

	public Point getLocation() {
		return location;
	}

	public int getX() {
		return location.getX();
	}

	public int getY() {
		return location.getY();
	}

	public Level getLevel() {
		return level;
	}

	private boolean canMoveTo(Point p) {
		return level.isEmpty(p);
	}

	private boolean canMoveTo(int x, int y) {
		return level.isEmpty(x, y);
	}

	public Image getImage() {
		return image;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public boolean safeTranslate(Point p) {
		p.translate(getLocation());
		if (canMoveTo(p)) {
			translate(p);
			return true;
		}
		return false;
	}

	public boolean safeTranslate(int x, int y) {
		if (canMoveTo(x+getX(), y+getY())) {
			translate(x, y);
			return true;
		}
		return false;
	}

	public void translate(Point p) {
		location.translate(p);
	}

	public void translate(int x, int y) {
		location.translate(x, y);
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void render(Graphics g, View view, float xPos, float yPos) {
		g.drawImage(getImage(), xPos+(getX()*Tiles.TILE_WIDTH), yPos+(getY()*Tiles.TILE_HEIGHT));
	}

	public void update(GameContainer gc, StateBasedGame sbg) {
	}
}