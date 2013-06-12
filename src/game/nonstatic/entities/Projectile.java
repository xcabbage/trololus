package game.nonstatic.entities;

import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import game.core.Trololus;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.entities.controllables.ShipType;

/**
 * The Projectile.java class representing an individual projectile, its
 * properties, speed, team etc.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       14.3.2013 9:23:14
 */
public class Projectile {

	private boolean debugIntersectsEnabled = false;
	private static final float MOVE_TIME = 1;

	// debug
	Shape rect;
	Vector2f angleVector;

	// Movement declarations (I think we are not working in 3D)
	int XSpeed;
	int YSpeed;
	float XPos;
	float YPos;
	int angle;
	int speed;

	// Ship Properties declarations
	int HullHP;// Percentage?
	int PlayerOwner = 5;
	int ID = 3;
	public static TrueTypeFont font;

	
	
	
	static Image debugImg;
	static int debugPointX, debugPointY;
	static Color col;
	static Point2D point;
	static Point2D pivot;
	static Point2D result;

	ShipType type; // ShipType includes number of slots, will also very probably
					// contain ship size
	private Image img;
	@SuppressWarnings("unused")
	private int movementAngle;
	private Ship ship;

	public int friendlyShip;

	// SYSTEM METHODS
	public void initClass() {
		font = new TrueTypeFont(new Font("Tahoma", 25, 25), true);
		// beware,
		// creating
		// a Font
		// object
		// lags like
		// a
		// motherfucker

	}

	// SYSTEM METHODS
	@Override
	public String toString() {
		return "Projectile [PlayerOwner=" + PlayerOwner + ", ID=" + ID
				+ ", type=" + type + "]";
	}

	// ----------------------------------ENTITY
	// METHODS----------------------------------------------

	/**
	 * @param xPos
	 * @param yPos
	 * @param angle
	 * @param speed
	 */
	public Projectile(int xPos, int yPos, int angle, int speed, int shipID) {
		super();
		XPos = xPos;
		YPos = yPos;
		this.angle = angle;
		this.speed = speed;
		friendlyShip = shipID;
		commonInit();
	}

	public Projectile(int xPos, int yPos, int angle, int speed, Ship ship,
			int shipID) {
		// super();

		XPos = xPos;
		YPos = yPos;
		this.angle = angle;
		this.speed = speed;
		this.ship = ship;

		friendlyShip = shipID;
		commonInit();

	}

	public Projectile() {
		commonInit();
	}

	void commonInit() {
		try {
			img = new Image("resources/Splash/rocket.png").getScaledCopy(0.1f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		img.rotate(angle);
		initializeVector();
	}

	void initializeVector() {

		/*
		 * AffineTransform transformer = AffineTransform.getRotateInstance(
		 * Math.toRadians(angle), x,y);
		 * 
		 * Point2D before = new Point2D.Double(x, y);
		 * 
		 * Point2D after = new Point2D.Double(); after =
		 * transformer.transform(before, after); angleVector = new Vector2f();
		 * 
		 * angleVector.set((float) after.getX(), (float) after.getY());
		 */

		Point2D point = new Point2D.Double(XPos + img.getWidth() / 2, YPos);
		Point2D pivot = new Point2D.Double(XPos + img.getWidth() / 2, YPos
				+ img.getHeight() / 2);
		Point2D result = new Point2D.Double();
		AffineTransform rotation = new AffineTransform();
		double angleInRadians = (angle * Math.PI / 180);

		rotation.rotate(angleInRadians, pivot.getX(), pivot.getY());
		rotation.transform(point, result);

		angleVector = new Vector2f();

		angleVector.set((float) result.getX() - XPos, (float) result.getY()
				- YPos);

	}

	/**
	 * 
	 */
	public void draw() {
		if (debugImg != null) {
			debugImg.draw(0, 0);
			Trololus.app.getGraphics().drawRect(debugPointX - 1,
					debugPointY - 1, 2, 2);
		}

		if (col != null){
			Color placeholder = Trololus.app.getGraphics().getColor();
			Trololus.app.getGraphics().setColor(col);
			
			Trololus.app.getGraphics().fillRect(250, 250, 50, 50);
			Trololus.app.getGraphics().setColor(placeholder);
//			Trololus.app.getGraphics().fillRect(250, 250, 50, 50);
		}
		
		img.rotate(img.getRotation() - angle);
		img.draw((int) XPos, (int) YPos);
		if (debugIntersectsEnabled) {
			font.drawString(XPos + 10, YPos,
					String.valueOf(intersectsBounds(ship)));

			if (rect != null)
				Trololus.app.getGraphics().draw(rect);
		}
		Trololus.app.getGraphics().draw(
				new Rectangle(XPos + angleVector.getX(), YPos
						+ angleVector.getY(), 2, 2));
	}

	/**
	 * 
	 */
	public void update() {

		int angleAux = angle - 90;
		float dX = (float) Math.cos(Math.toRadians(angleAux)) * speed
				* MOVE_TIME;
		float dY = (float) Math.sin(Math.toRadians(angleAux)) * speed
				* MOVE_TIME;
		XPos = (XPos + dX);
		YPos = (YPos + dY);

	}

	// ------------------------------------------------------COLLISION-------------------------------------------------------------

	public boolean collidesWith(Ship ship) {
		if (intersectsBounds(ship)) {
			if (intersects(ship))
				return true;
			return false;
		}
		return false;
	}

	public boolean intersectsBounds(Ship ship) {
		try {

			if (ship.getBounds() != null) {
				if (ship.getID() != friendlyShip) {
					if (ship.getBounds().contains(XPos + angleVector.getX(),
							YPos + angleVector.getY()))
						return true;
					else
						return false;
				}

				return false;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean intersects(Ship ship) {
		int shipX = ship.getContainingField().getShipX(ship.getID());
		int shipY = ship.getContainingField().getShipY(ship.getID());

		int bulletPosX = (int) (XPos + angleVector.getX() - shipX);
		int bulletPosY = (int) (YPos + angleVector.getY() - shipY);

		Image shipImg = ship.getContainingField().instance.ship[ship.getID()];

		Point2D point = new Point2D.Double(bulletPosX, bulletPosY);
		Point2D pivot = new Point2D.Double(shipImg.getWidth() / 2,
				shipImg.getHeight() / 2);
		Point2D result = new Point2D.Double();
		AffineTransform rotation = new AffineTransform();
		double angleInRadians = (Math.toRadians(360-ship.rotation));

		rotation.rotate(angleInRadians, pivot.getX(), pivot.getY());
		rotation.transform(point, result);

		bulletPosX = (int) (result.getX());
		bulletPosY = (int) (result.getY());

		col = shipImg.getColor(bulletPosX, bulletPosY );

		System.out.println(col.getAlpha());

		
		if (col.getAlpha() > 0.99f) {
			System.out.println(col.getAlpha());
			return true;
		} else
			return false;

	}

	// --------------------------------------------------------GETTERS-------------------------------------------------------------
	public int getID() {
		return ID;
	}

	public int getXSpeed() {
		return XSpeed;
	}

	public int getYSpeed() {
		return YSpeed;
	}

	public float getXPos() {
		return XPos;
	}

	public float getYPos() {
		return YPos;
	}

	public int getHullHP() {
		return HullHP;
	}

	public int getPlayerOwner() {
		return PlayerOwner;
	}

	public ShipType getType() {
		return type;
	}

	// ----------------------------------SETTERS----------------------------------------------

	public void setID(int iD) {
		ID = iD;
	}

	public void setXSpeed(int xSpeed) {
		XSpeed = xSpeed;
	}

	public void setYSpeed(int ySpeed) {
		YSpeed = ySpeed;
	}

	public void setXPos(int xPos) {
		XPos = xPos;
	}

	public void setYPos(int yPos) {
		YPos = yPos;
	}

	public void setHullHP(int hullHP) {
		HullHP = hullHP;
	}

	public void setPlayerOwner(int playerOwner) {
		PlayerOwner = playerOwner;
	}

	public void setType(ShipType type) {
		this.type = type;
	}

	public Point getLocation() {
		return new Point(XPos, YPos);
	}

	// DEBUGGING

	void toggleDebug() {
		debugIntersectsEnabled = !debugIntersectsEnabled;
	}

}