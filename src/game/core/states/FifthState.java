package game.core.states;

import org.newdawn.slick.Color;

import game.nonstatic.BattleField;
import game.nonstatic.GameInstance;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.entities.controllables.ShipType;
import game.nonstatic.system.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FifthState extends BasicState {

	public static int ID = 4;

	GameInstance instance;
	Player player = new Player("Davefinek", Color.white);
	boolean gameRunning = false;
	FifthState state = this;
	BattleField field;
	int SPEED = 5;
	Ship controlledShip;

	public void createContent() throws SlickException {
		initTestingShip();
	}

	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "State 5 - Game - GfX test! (once to be Player Profile)";

	}

	public int getID() {
		return ID;
	}


	 
	void initTestingShip() throws SlickException {
		instance = new GameInstance((BasicState) state,game, player);
		field = instance.getField();
		controlledShip = new Ship(ShipType.Striker);
		field.placeEntity(controlledShip);
		instance.centerShip(controlledShip.getID());
		gameRunning = true;
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
		// ship movement
		if (gameRunning) {

			// rotation
			if (input.isKeyDown(30)) {
				field.setRotation(field.getRotation(controlledShip.getID())
						- SPEED, controlledShip.getID());
			}

			if (input.isKeyDown(32)) {
				field.setRotation(field.getRotation(controlledShip.getID())
						+ SPEED, controlledShip.getID());
			}

			// movement
			if (input.isKeyDown(17)) {
				field.moveShipForwards(controlledShip.getID());
			}
			if (input.isKeyDown(31)) {
				field.moveShipBackwards(controlledShip.getID());
			}

			// reset ship coords
			if (input.isKeyPressed(29)) {
				field.setShipX(500, controlledShip.getID());
				field.setShipY(300, controlledShip.getID());
				field.setRotation(0, controlledShip.getID());
			}
		}
	}

	@Override
	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) {

		instance.draw(g);
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {

		super.render(gc, mainGame, g, stateRes);
		renderDiffGfx(gc, mainGame, g, stateRes);
	}

}