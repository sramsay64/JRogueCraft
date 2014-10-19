package com.openThid.ncmmh.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class SimpleGameState extends BasicGameState {

	private int id;

	public SimpleGameState(int id) {
		this.id = id;
	}

	@Override
	public abstract void init(GameContainer gc, StateBasedGame game) throws SlickException;

	@Override
	public abstract void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException;

	@Override
	public abstract void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException;

	@Override
	public int getID() {
		return id;
	}
}