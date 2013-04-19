package game.nonstatic.entities;

import game.nonstatic.entities.controllables.Ship;

public class Projectile2 {
	public Projectile2(int xPos, int yPos, int angle2, int speed,
			int friendlyShipID) {
		x = xPos;
		y = xPos;
	}

	public Projectile2(int xPos, int yPos, int angle2, int speed, Ship ship,
			int friendlyShipID) {
		// TODO Auto-generated constructor stub
	}

	int x, y, angle;
public void setID(int id){
	
}
public void update() {
	// TODO Auto-generated method stub
	
}
public boolean intersectsBounds(Ship ship) {
	// TODO Auto-generated method stub
	return false;
}
public void draw() {
	// TODO Auto-generated method stub
	
}
public float getYPos() {
	// TODO Auto-generated method stub
	return 0;
}
}
