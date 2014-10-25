package com.openThid.ncmmh.world;

import java.util.ArrayList;
import java.util.Collection;

import org.newdawn.slick.Graphics;

import com.openThid.ncmmh.entites.Entity;
import com.openThid.ncmmh.entites.LocalPlayer;
import com.openThid.ncmmh.entites.Player;

public class World {

	private View view;

	private int currentLevel;
	private Level overworld;
	private Level nether;
	private Level[] underground;

	private ArrayList<Entity> entities;
	private ArrayList<Player> players;
	private ArrayList<LocalPlayer> localPlayers;

	public World(int x, int y) {
		this(Level.OVERWORLD, new Level(Level.OVERWORLD, x, y), null, null, new ArrayList<Entity>(), new ArrayList<Player>(), new ArrayList<LocalPlayer>());
		getOverworld().setWorld(this);
	}

	public World(int currentLevel, Level overworld, Level nether, Level[] underground, ArrayList<Entity> entities, ArrayList<Player> players, ArrayList<LocalPlayer> localPlayers) {
		this.currentLevel = currentLevel;
		this.overworld = overworld;
		this.nether = nether;
		this.underground = underground;
		this.entities = entities;
		this.players = players;
		this.localPlayers = localPlayers;
	}

	public View getView() {
		return view;
	}

	public int getCurrentLevelCode() {
		return currentLevel;
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

	public Level getOverworld() {
		return overworld;
	}

	public Level getNether() {
		return nether;
	}

	public Level[] getUnderground() {
		return underground;
	}

	public Player getPlayer(int id) {
		return players.get(id);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<LocalPlayer> getLocalPlayers() {
		return localPlayers;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public boolean addEntity(Entity e) {
		return entities.add(e);
	}

	public boolean addAllEntities(Collection<? extends Entity> entities) {
		return this.entities.addAll(entities);
	}

	public boolean addPlayer(Player player) {
		return players.add(player);
	}

	public boolean addAllPlayers(Collection<? extends Player> players) {
		return this.players.addAll(players);
	}
	public boolean addLocalPlayer(LocalPlayer player) {
		return localPlayers.add(player);
	}

	public boolean addAllLocalPlayers(Collection<? extends LocalPlayer> localPlayers) {
		return this.localPlayers.addAll(localPlayers);
	}

	public void render(Graphics g, float xPos, float yPos) {
		render(g, view, xPos, yPos);
	}

	public void render(Graphics g, int x, int y, int xSize, int ySize, float xPos, float yPos) {
		render(g, new View(x, y, xSize, ySize), xPos, yPos);
	}

	public void render(Graphics g, View view, float xPos, float yPos) {
		getCurrentLevel().render(g, view, xPos, yPos);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g, view, xPos, yPos);
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(g, view, xPos, yPos);
		}
		for (int i = 0; i < localPlayers.size(); i++) {
			localPlayers.get(i).render(g, view, xPos, yPos);
		}
	}
}