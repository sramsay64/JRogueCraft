package com.openThid.ncmmh.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.Transition;

import com.openThid.ncmmh.util.ImageUtil;

public class SplashScreen extends SimpleGameState {

	private long timeStart;
	private Image image;

	private int time;
	private Transition transition;
	private int nextStateID;

	public SplashScreen(int id, int nextStateID, String image, int time) {
		this(id, nextStateID, image, new BlobbyTransition(), time);
	}

	public SplashScreen(int id, int nextStateID, String image, Transition transition, int time) {
		super(id);
		this.time = time;
		this.transition = transition;
		this.nextStateID = nextStateID;
		this.image = ImageUtil.getImageSafe(image);
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
		if (gc.getTime() - timeStart > time) {
			game.enterState(nextStateID, new EmptyTransition(), transition);
		}
	}
}