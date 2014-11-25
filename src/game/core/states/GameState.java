package game.core.states;

import game.core.parts.ContentPosition;
import game.nonstatic.BattleField;
import game.nonstatic.GameInstance;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.entities.controllables.ShipType;
import game.nonstatic.system.Player;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The GameState.java class responsible for
 *
 * @author xCabbage [github.com/xcabbage]
 *
 * @info for the Trololus project [github.com/xcabbage/trololus] created 25. 11.
 *       2014 20:26:51
 *
 */
public class GameState extends BasicState {
	private static final int PROJECTILE_SPEED = 8;
	public static final int ID = 6;
	BattleField field;
	int SPEED = 5;
	Ship controlledShip;
	Ship secondShip;
	GameInstance instance;
	Player player = new Player("Davefinek", Color.white);
	boolean gameRunning = false;
	
	GameState state = this;

	@Override
	public void createContent() throws SlickException {
		initTestingShip();
		sb.addLabel(1, 0.5f, 0.5f, "PLAY");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		// ship movement

		if (gameRunning) {
			field.updateProjectiles();
			// rotation
			if (input.isKeyDown(Input.KEY_A)) {
				int reqRot = 0;
				if (field.getRotation(controlledShip.getID()) - SPEED < 0) {
					reqRot = field.getRotation(controlledShip.getID()) - SPEED
							+ 360;

				} else {
					reqRot = field.getRotation(controlledShip.getID()) - SPEED;
				}

				field.setRotation(reqRot, controlledShip.getID());

			}

			if (input.isKeyDown(Input.KEY_D)) {
				int reqRot = 0;
				if (field.getRotation(controlledShip.getID()) + SPEED > 360) {
					reqRot = field.getRotation(controlledShip.getID()) + SPEED
							- 360;

				} else {
					reqRot = field.getRotation(controlledShip.getID()) + SPEED;
				}
				field.setRotation(reqRot, controlledShip.getID());
			}

			// movement
			if (input.isKeyDown(Input.KEY_W)) {
				field.moveShipForwards(controlledShip.getID());
			}
			if (input.isKeyDown(Input.KEY_S)) {
				field.moveShipBackwards(controlledShip.getID());
			}

			// reset ship coords
			if (input.isKeyPressed(Input.KEY_LCONTROL)) {
				field.setShipX(500, controlledShip.getID());
				field.setShipY(300, controlledShip.getID());
				field.setRotation(0, controlledShip.getID());
			}
			if (input.isKeyPressed(Input.KEY_SPACE)) {
				field.placeProjectile(field.getShipX(controlledShip.getID()),
						field.getShipY(controlledShip.getID()) - 5,
						field.getRotation(controlledShip.getID()),
						PROJECTILE_SPEED, controlledShip.getID());

				// field.placeProjectile(controlledShip.getCannonX(0),
				// controlledShip.getCannonY(0),
				// field.getRotation(controlledShip.getID()),
				// PROJECTILE_SPEED, secondShip);
			}
			if (input.isKeyDown(Input.KEY_G)) {
				field.placeProjectile(field.getShipX(controlledShip.getID()),
						field.getShipY(controlledShip.getID()) + 5,
						field.getRotation(controlledShip.getID()),
						PROJECTILE_SPEED, controlledShip.getID());
			}

			if (input.isKeyPressed(Input.KEY_RCONTROL)) {

				field.placeProjectile(field.getShipX(secondShip.getID()),
						field.getShipY(secondShip.getID()) - 5,
						field.getRotation(secondShip.getID()),
						PROJECTILE_SPEED, secondShip.getID());

				// field.placeProjectile(secondShip.getCannonX(0),
				// secondShip.getCannonY(0),
				// field.getRotation(secondShip.getID()),
				// PROJECTILE_SPEED);
			}

			if (input.isKeyDown(Input.KEY_LEFT)) {
				int reqRot = 0;
				if (field.getRotation(secondShip.getID()) - SPEED < 0) {
					reqRot = field.getRotation(secondShip.getID()) - SPEED
							+ 360;

				} else {
					reqRot = field.getRotation(secondShip.getID()) - SPEED;
				}

				field.setRotation(reqRot, secondShip.getID());

			}

			if (input.isKeyDown(Input.KEY_RIGHT)) {
				int reqRot = 0;
				if (field.getRotation(secondShip.getID()) + SPEED > 360) {
					reqRot = field.getRotation(secondShip.getID()) + SPEED
							- 360;

				} else {
					reqRot = field.getRotation(secondShip.getID()) + SPEED;
				}
				field.setRotation(reqRot, secondShip.getID());
			}

			// movement
			if (input.isKeyDown(Input.KEY_UP)) {
				field.moveShipForwards(secondShip.getID());
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
				field.moveShipBackwards(secondShip.getID());
			}

			if (input.isKeyPressed(Input.KEY_P)) {
				field.mapBoundsCheckStop();
			}
			if (input.isKeyPressed(Input.KEY_T)) {
				field.mapBoundsCheckStart(2500);
			}

		}
	}

	void initTestingShip() throws SlickException {
		instance = new GameInstance((BasicState) state, game, player);
		field = instance.getField();
		controlledShip = new Ship(ShipType.Striker, field);
		secondShip = new Ship(ShipType.Striker, field);
		field.placeEntity(controlledShip);
		field.placeEntity(secondShip);
		instance.centerShip(secondShip.getID());
		instance.centerShip(controlledShip.getID());
		gameRunning = true;
	}

	@Override
	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) {
		try {
			super.renderDiffGfx(gc, mainGame, g, state);
		} catch (SlickException e) {

			e.printStackTrace();
		}
		instance.draw(g);
	}
}