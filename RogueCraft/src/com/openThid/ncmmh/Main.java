package com.openThid.ncmmh;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import com.openThid.ncmmh.states.MainGame;
import com.openThid.ncmmh.states.SplashScreen;

public class Main extends StateBasedGame {

	public static final int MAINGAME = 1;
	public static final int SPLASHSCREEN = 0;

	public static Main main;

	private Logger logger = (Logger) LoggerFactory.getLogger(Main.class);

	public Main(String name) {
		super(name);
		getLogger().info("Start");
		getLogger().setLevel(Level.ALL);
	}

	public static void main(String[] args) throws SlickException {
		main = new Main("NCMMH");
		AppGameContainer appGC = new AppGameContainer(main);
		appGC.setDisplayMode(640, 480, false);
		appGC.setShowFPS(false);
		appGC.start();
	}

	public Logger getLogger() {
		return logger;
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new SplashScreen(SPLASHSCREEN));
		addState(new MainGame(MAINGAME));
	}
}