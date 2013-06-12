package game.nonstatic;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import game.core.Trololus;
import game.nonstatic.entities.Projectile;
import game.nonstatic.entities.controllables.Ship;
import game.util.Util;

/**
 * The battlefield class storing the map, map type, entities on the battlefield\
 * and their locations.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       5.2.2013 8:05:31
 */
public class BattleField {

	// CONSTANTS
	int SHIP_SPEED = 4, MOVE_TIME = 1;

	Ship[] entities = new Ship[0];
	Projectile[] projectiles = new Projectile[0];

	int movementRotation;
	public GameInstance instance;
	Timer timer = new Timer();
	Rectangle fieldRect;

	// CONSTRUCTORS
	public BattleField(GameInstance gameInstance) {
		instance = gameInstance;
		Util.getGame();
		Util.getGame();
		fieldRect = new Rectangle(0, 0, Trololus.app.getWidth(),
				Trololus.app.getHeight());
	}

	// ENTITY PLACEMENT
	public void placeEntity(Ship entity) throws SlickException {
		entities = Arrays.copyOf(entities, entities.length + 1);
		// shipX = Arrays.copyOf(shipX, shipX.length + 1);
		// shipY = Arrays.copyOf(shipY, shipY.length + 1);
		// rotation = Arrays.copyOf(rotation, rotation.length + 1);
		// rotation2 = Arrays.copyOf(rotation2, rotation2.length + 1);
		entities[entities.length - 1] = entity;
		System.out.println("Placed a new ship on the battlefield..: "
				+ entities[entities.length - 1]);
		entity.setID(entities.length - 1);
		instance.addShip(entity);
	}

	public void placeProjectile(int xPos, int yPos, int angle, int speed,
			int friendlyShipID) throws SlickException {
		projectiles = Arrays.copyOf(projectiles, projectiles.length + 1);

		projectiles[projectiles.length - 1] = new Projectile(xPos, yPos, angle,
				speed, friendlyShipID);
		System.out.println("Fired a projectile..: "
				+ projectiles[projectiles.length - 1]);
		projectiles[projectiles.length - 1].setID(projectiles.length - 1);

	}

	/**
	 * @param cannonX
	 * @param cannonY
	 * @param rotation3
	 * @param projectileSpeed
	 * @param secondShip
	 */
	public void placeProjectile(int xPos, int yPos, int angle, int speed,
			Ship ship, int friendlyShipID) {
		projectiles = Arrays.copyOf(projectiles, projectiles.length + 1);

		projectiles[projectiles.length - 1] = new Projectile(xPos, yPos, angle,
				speed, ship, friendlyShipID);
		projectiles[projectiles.length - 1].setID(projectiles.length - 1);

	}

	// ENTITY MOVEMENT
	public void moveShipForwards(int shipNum) {

		movementRotation = entities[shipNum].rotation - 90;

		float dX = (float) Math.cos(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		float dY = (float) Math.sin(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		int reqX = (int) (entities[shipNum].xPos + dX);
		int reqY = (int) (entities[shipNum].yPos + dY);
		entities[shipNum].setPosition(reqX, reqY);
	}

	public void moveShipBackwards(int shipNum) {
		movementRotation = entities[shipNum].rotation - 90;

		float dX = (float) Math.cos(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		float dY = (float) Math.sin(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		int reqX = (int) (entities[shipNum].xPos - dX);
		int reqY = (int) (entities[shipNum].yPos - dY);
		entities[shipNum].setPosition(reqX, reqY);
	}

	// RENDER AND UPDATE

	public void updateProjectiles() {

		for (int a = 0; a < projectiles.length; a++) {
			if (projectiles[a] != null) {

				// movement
				projectiles[a].update();

				// collision
				for (int b = 0; b < entities.length; b++) {
					if (entities[b] != null && entities[b].getBounds() != null
							&& projectiles[a] != null) {
						if (projectiles[a].collidesWith(entities[b])) {

							// care, this one lags it a bit
							// Util.notify("Ship ID [" + entities[b].getID()
							// + "] has been hit!");

							projectiles[a] = null;
						}
					}
				}
			}
		}

	}

	public void drawProjectiles() {
		for (int a = 0; a < projectiles.length; a++) {
			if (projectiles[a] != null) {
				projectiles[a].draw();
			}

		}
	}

	public void drawShips() {
		for (int a = 0; a < getEntitiesCount(); a++) {

			entities[a].img.rotate(getRotation(a) - getRotation2(a));
			setRotation2(getRotation(a), a);
			entities[a].img.draw(getShipX(a), getShipY(a));
			Trololus.app.getGraphics().draw(entities[a].getBounds());
		}
	}

	// delete out of bounds projectiles
	public void mapBoundsCheckStart(int period) {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				mapBoundsCheck();

			}
		}, 0, period);
	}

	public void mapBoundsCheck() {
		for (int a = 0; a < projectiles.length; a++) {

			if (projectiles[a] != null) {
				if (!fieldRect.contains(projectiles[a].getYPos(),
						projectiles[a].getYPos())) {
					projectiles[a] = null;

					System.out.println("anulling a projectile");

				}
			}

		}
	}

	public void mapBoundsCheckStop() {
		System.out.println("CANCELLING TIMER");
		timer.cancel();
	}

	// ----------------------------------------------------------GETTERS and
	// SETTERS----------------------------------------------------------

	/**
	 * @return the shipX
	 */
	public int getShipX(int ship) {
		return entities[ship].xPos;
	}

	/**
	 * @param shipX
	 *            the ship's X to set
	 */
	public void setShipX(int shipX, int ship) {
		// for (int a = 0; a<)
		// System.out.println("starting. " + shipX + " " + ship);
		entities[ship].xPos = shipX;
	}

	/**
	 * @return the shipY
	 */
	public int getShipY(int ship) {
		return entities[ship].yPos;
	}

	/**
	 * @param shipY
	 *            the shipY to set
	 * @param ship
	 *            number of the ship to be modified
	 */
	public void setShipY(int shipY, int ship) {
		entities[ship].yPos = shipY;
	}

	/**
	 * @return the rotation,
	 */
	public int getRotation(int ship) {
		return entities[ship].rotation;
	}

	/**
	 * @param rotation
	 *            the rotation to set
	 */

	public void setRotation(int rotation, int ship) {

		entities[ship].setRotation(rotation);

	}

	public void setRotation2(int rotation, int ship) {
		entities[ship].rotation2 = rotation;
	}

	public int getEntitiesCount() {
		return entities.length;
	}

	public int getRotation2(int ship) {
		return entities[ship].rotation2;
	}

}