package com.openThid.ncmmh.world;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import com.openThid.ncmmh.entites.Player;

public class World {

	private ArrayList<Player> players;
	private View view;

	private int currentLevel;
	private Level overworld;
	private Level nether;
	private Level[] underground;

	public World() {
		players = new ArrayList<>();
		overworld = new Level(0);
	}

	public Level getOverworld() {
		return overworld;
	}

	public Level getNether() {
		return nether;
	}

	public Level[] getUnderground() {
		return underground;
	}

	public Level getCurrentLevel() {
		switch (currentLevel) {
		case Level.OVERWORLD:
			return overworld;
		
		case Level.NETHER:
			return nether;
		
		default:
			return underground[currentLevel];
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Player getPlayer(int id) {
		return players.get(id);
	}

	public View getView() {
		return view;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void setView(View view) {
		this.view = view;
	}

	public void render(Graphics g, float xPos, float yPos) {
		render(g, view, xPos, yPos);
	}

	public void render(Graphics g, int x, int y, int xSize, int ySize, float xPos, float yPos) {
		render(g, new View(x, y, xSize, ySize), xPos, yPos);
	}

	public void render(Graphics g, View view, float xPos, float yPos) {
		getCurrentLevel().render(g, view, xPos, yPos);
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(g, view, xPos, yPos);
		}
	}
}