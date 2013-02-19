package game.nonstatic;

import java.util.Arrays;

import game.nonstatic.entities.controllables.Ship;

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
	Ship[] entities = new Ship[0];
	int[] shipX = new int[0], shipY = new int[0], rotation = new int[0];
	int movementRotation;
	// constants
	int SHIP_SPEED = 4, MOVE_TIME = 1;

	public void placeEntity(Ship entity) {
//	Util.prolongArray(1, shipX,shipY,rotation);
//	Util.prolongArray(1, entities); <-- this one is bugged
		
		entities = Arrays.copyOf(entities, entities.length + 1);
		shipX = Arrays.copyOf(shipX, shipX.length + 1);
		shipY = Arrays.copyOf(shipY, shipY.length + 1);
		rotation = Arrays.copyOf(rotation, rotation.length + 1);
		entities[entities.length - 1] = entity;
		System.out.println("Placed a new ship on the battlefield..: "
				+ entities[entities.length - 1]);
		entity.setID(entities.length - 1);
	}

	// ENTITY MOVEMENT
	public void moveShipForwards(int shipNum) {

		movementRotation = rotation[shipNum] - 90;

		float dX = (float) Math.cos(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		float dY = (float) Math.sin(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		shipX[shipNum] = (int) (shipX[shipNum] + dX);
		shipY[shipNum] = (int) (shipY[shipNum] + dY);
	}

	public void moveShipBackwards(int shipNum) {
		movementRotation = rotation[shipNum] - 90;

		float dX = (float) Math.cos(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		float dY = (float) Math.sin(Math.toRadians(movementRotation))
				* SHIP_SPEED * MOVE_TIME;
		shipX[shipNum] = (int) (shipX[shipNum] - dX);
		shipY[shipNum] = (int) (shipY[shipNum] - dY);
	}

	// ----------------------------------------------------------GETTERS and
	// SETTERS----------------------------------------------------------

	/**
	 * @return the shipX
	 */
	public int getShipX(int ship) {
		return shipX[ship];
	}

	/**
	 * @param shipX
	 *            the ship's X to set
	 */
	public void setShipX(int shipX, int ship) {
		// for (int a = 0; a<)
//		System.out.println("starting. " + shipX + " " + ship);
		this.shipX[ship] = shipX;
	}

	/**
	 * @return the shipY
	 */
	public int getShipY(int ship) {
		return shipY[ship];
	}

	/**
	 * @param shipY
	 *            the shipY to set
	 * @param ship
	 *            number of the ship to be modified
	 */
	public void setShipY(int shipY, int ship) {
		this.shipY[ship] = shipY;
	}

	/**
	 * @return the rotation,
	 */
	public int getRotation(int ship) {
		return rotation[ship];
	}

	/**
	 * @param rotation
	 *            the rotation to set
	 */
	public void setRotation(int rotation, int ship) {
		this.rotation[ship] = rotation;
	}

	public int getEntitiesCount() {
		return entities.length;
	}

}