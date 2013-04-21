package game.nonstatic.entities;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

import game.nonstatic.entities.controllables.Ship;

public class Projectile2 {
	int x, y, angle;
static TrueTypeFont font = new TrueTypeFont(new Font("Tahoma", 25, 25), true);
	public Projectile2(int xPos, int yPos, int angle2, int speed,
			int friendlyShipID) {
		x = xPos;
		y = xPos;
		angle = angle2;
	}

	public Projectile2(int xPos, int yPos, int angle2, int speed, Ship ship,
			int friendlyShipID) {
		// TODO Auto-generated constructor stub
	}

	
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
	font.drawString(x, y,
			"bullet");
}
public float getYPos() {
	// TODO Auto-generated method stub
	return 0;
}
}
