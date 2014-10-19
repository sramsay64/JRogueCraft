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
import com.openThid.ncmmh.entites.Player;
import com.openThid.ncmmh.world.Tiles;
import com.openThid.ncmmh.world.View;
import com.openThid.ncmmh.world.World;

public class MainGame extends SimpleGameState implements InputProviderListener {

	private World world;
	private LocalPlayer player;

	public MainGame(int id) {
		this(id, new World());
	}

	public MainGame(int id, World world) {
		super(id);
		this.world = world;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		world.setView(new View(0, 0, gc.getWidth()/Tiles.TILE_WIDTH, gc.getHeight()/Tiles.TILE_HEIGHT));
		
		Command playerLeft = new BasicCommand("Player Left");
		Command playerRight = new BasicCommand("Player Right");
		Command playerUp = new BasicCommand("Player Up");
		Command playerDown = new BasicCommand("Player Down");
		InputProvider provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		provider.bindCommand(new KeyControl(Input.KEY_LEFT), playerLeft);
		provider.bindCommand(new KeyControl(Input.KEY_RIGHT), playerRight);
		provider.bindCommand(new KeyControl(Input.KEY_UP), playerUp);
		provider.bindCommand(new KeyControl(Input.KEY_DOWN), playerDown);

		player = new LocalPlayer(new Point(1, 1), playerLeft, playerRight, playerUp, playerDown);
		world.addPlayer(player);
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

	public class LocalPlayer extends Player {
		private Command left;
		private Command right;
		private Command up;
		private Command down;
	
		public LocalPlayer(Point location, Command left, Command right, Command up, Command down) {
			super(location);
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
		}
	}

	@Override
	public void controlPressed(Command command) {
		Main.main.getLogger().info("Player Command: {}", command);
		if (command == player.left) {
			player.getLocation().translate(-1, 0);
		} else if (command == player.right) {
			player.getLocation().translate(1, 0);
		} else if (command == player.up) {
			player.getLocation().translate(0, -1);
		} else if (command == player.down) {
			player.getLocation().translate(0, 1);
		}
	}

	@Override
	public void controlReleased(Command command) {
	}
}