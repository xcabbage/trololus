package game.nonstatic;

/** The battlefield class storing the map, map type, entities in and their locations. 
 * @author xCabbage [github.com/xcabbage]
 *
 * for the Trololus project [github.com/xcabbage/trololus]
 *      created 5.2.2013 8:05:31
 */
public class BattleField {
int[] shipX,shipY,rotation; 
int movementRotation;
int SHIP_SPEED=4,MOVE_TIME=1;


public void moveShipForwards(int shipNum){
	
	movementRotation = rotation[shipNum]-90;
	System.out.println(movementRotation);
	
	float dX = (float) Math.cos(Math.toRadians(movementRotation)) * SHIP_SPEED * MOVE_TIME;
	float dY = (float) Math.sin(Math.toRadians(movementRotation)) * SHIP_SPEED * MOVE_TIME;
	shipX[shipNum] =(int) (shipX[shipNum]+dX);
	shipY[shipNum] = (int) (shipY[shipNum]+dY);
}

public void moveShipBackwards(int shipNum){
	movementRotation = rotation[shipNum]-90;
	System.out.println(movementRotation);
	
	float dX = (float) Math.cos(Math.toRadians(movementRotation)) * SHIP_SPEED * MOVE_TIME;
	float dY = (float) Math.sin(Math.toRadians(movementRotation)) * SHIP_SPEED * MOVE_TIME;
	shipX[shipNum] =(int) (shipX[shipNum]-dX);
	shipY[shipNum] = (int) (shipY[shipNum]-dY);	
}

/**
 * @return the shipX
 */
public int getShipX(int ship) {
	return shipX[ship];
}

/**
 * @param shipY the ship's X to set
 */
public void setShipX(int shipX, int ship) {
	this.shipX[ship] = shipX;
}

/**
 * @return the shipY
 */
public int getShipY(int ship) {
	return shipY[ship];
}

/**
 * @param shipY the shipY to set
 * @param ship number of the ship to be modified
 */
public void setShipY(int shipY, int ship) {
	this.shipY[ship] = shipY;
}

/**
 * @return the rotation
 */
public int getRotation(int ship) {
	return rotation[ship];
}

/**
 * @param rotation the rotation to set
 */
public void setRotation(int rotation,int ship) {
	this.rotation[ship] = rotation;
}








//----------------------------------------------------------GETTERS and SETTERS----------------------------------------------------------

}