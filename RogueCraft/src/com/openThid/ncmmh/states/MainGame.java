package com.openThid.ncmmh.states;

import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.state.StateBasedGame;

import com.openThid.ncmmh.Main;
import com.openThid.ncmmh.entites.LocalPlayer;
import com.openThid.ncmmh.entites.objects.TestObjectRock;
import com.openThid.ncmmh.world.Tiles;
import com.openThid.ncmmh.world.View;
import com.openThid.ncmmh.world.World;

public class MainGame extends SimpleGameState implements InputProviderListener {

	private World world;
	private LocalPlayer[] localPlayers;

	private InputProvider provider;

	public MainGame(int id) {
		this(id, new World(400, 400), 1);
	}

	public MainGame(int id, World world, int players) {
		super(id);
		this.world = world;
		this.localPlayers = new LocalPlayer[players];
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		world.setView(new View(0, 0, gc.getWidth()/Tiles.TILE_WIDTH, gc.getHeight()/Tiles.TILE_HEIGHT));
		world.addEntity(new TestObjectRock(new Point(4, 5), world.getCurrentLevel()));
		world.addEntity(new TestObjectRock(new Point(1, 2), world.getCurrentLevel()));
		
		Command playerLeft = new BasicCommand("Player Left");
		Command playerRight = new BasicCommand("Player Right");
		Command playerUp = new BasicCommand("Player Up");
		Command playerDown = new BasicCommand("Player Down");
		provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		provider.bindCommand(new KeyControl(Input.KEY_LEFT), playerLeft);
		provider.bindCommand(new KeyControl(Input.KEY_RIGHT), playerRight);
		provider.bindCommand(new KeyControl(Input.KEY_UP), playerUp);
		provider.bindCommand(new KeyControl(Input.KEY_DOWN), playerDown);

		for (int i = 0; i < localPlayers.length; i++) {
			localPlayers[i] = new LocalPlayer(new Point(1+i, 1), world.getCurrentLevel(), "", playerLeft, playerRight, playerUp, playerDown);
			world.addLocalPlayer(localPlayers[i]);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		world.render(g, 0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int deltaTime) throws SlickException {
	}

	public World getWorld() {
		return world;
	}

	@Override
	public void controlPressed(Command command) {
		for (int i = 0; i < localPlayers.length; i++) {
			localPlayers[i].controlPressed(command);
		}
	}

	@Override
	public void controlReleased(Command command) {
		for (int i = 0; i < localPlayers.length; i++) {
			localPlayers[i].controlReleased(command);
		}
	}
}	