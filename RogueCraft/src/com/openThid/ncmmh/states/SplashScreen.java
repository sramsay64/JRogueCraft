package com.openThid.ncmmh.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.openThid.ncmmh.Main;

public class SplashScreen extends SimpleGameState {

	private long timeStart;
	private Image image;

	public SplashScreen(int id) {
		super(id);
		try {
			image = new Image("res/logos/Logo.png");
		} catch (SlickException e) {
			Main.main.getLogger().info("No Logo Found");
		}
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		timeStart = gc.getTime();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		if (image != null) {
			g.drawImage(image, (gc.getWidth()-image.getWidth())/2, 0);
		} else {
			g.drawString("SPLASH", 10, 100);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		if (gc.getTime() - timeStart > 1000) {
			game.enterState(Main.MAINGAME);
		}
	}
}