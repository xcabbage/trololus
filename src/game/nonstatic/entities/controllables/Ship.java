/*
 * 
 * @Author DannyUfonek
 * @Author xCabbage 
 *  Rework 19 March '13 by xCabbage - optimalizing, entity stuff
 */
package game.nonstatic.entities.controllables;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

import game.core.Trololus;
import game.nonstatic.BattleField;
import game.util.Util;

/*
 * Main class of SHIPS, will most probably include all behaviour & info related to type, (size), speed, position, HP, ownership etc.
 */

public class Ship {

	// Movement declarations (I think we are not working in 3D)
	public int xSpeed, ySpeed, xPos, yPos, rotation, rotation2;
	Ellipse cannnonEllipse;

	// Ship Properties declarations
	int HullHP;// Percentage?
	int PlayerOwner = 5;
	int ID = 3;
	public Image img;

	BattleField containingField;
	ShipType type; // ShipType includes number of slots, will also very probably
					// contain ship size
	Trololus game;
	private Shape bounds;

	@SuppressWarnings("static-access")
	public Ship(ShipType type, BattleField field) {
		this.type = type;
		containingField = field;
		game = Util.getGame();

		// load image and boundaries
		try {
			img = new Image(type.getImgPath()).getScaledCopy(game.ShipScale);
		} catch (SlickException e) {
			e.printStackTrace();
		}

		moveBounds();
	}

	// ----------------------------------GETTERS----------------------------------------------

	public int getID() {
		return ID;
	}

	public int getCannonX(int cannonID) {
		int shipX = containingField.getShipX(ID);
		int cannonX = 8;
		// float dX = (float) Math.cos(Math.toRadians(angleAux)) ;

		return shipX + cannonX;
	}

	public int getCannonY(int cannonID) {
		int shipY = containingField.getShipY(ID);
		int cannonY = 33;

		int angleAux = containingField.getRotation(ID) - 90;
		cannonY = cannonY * (int) Math.cos(Math.toRadians(angleAux));
		int canYfinal = shipY - cannonY;

		System.out.println(canYfinal + " " + cannonY);
		return canYfinal;
	}

	public int getXSpeed() {
		return xSpeed;
	}

	@SuppressWarnings("static-access")
	void initEllipse() {
		Image model = null;
		try {
			model = new Image(getType().getImgPath())
					.getScaledCopy(game.ShipScale);
		} catch (SlickException e) {
			e.printStackTrace();
		}

		cannnonEllipse = new Ellipse(model.getCenterOfRotationX(),
				model.getCenterOfRotationY(), 8, 33);
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
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

	public Shape getBounds() {
		return bounds;
	}

	// ----------------------------------SETTERS----------------------------------------------

	public void setID(int iD) {
		ID = iD;
	}

	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setXPos(int xPos) {
		this.xPos = xPos;
	}

	public void setYPos(int yPos) {
		this.yPos = yPos;
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

	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
		moveBounds();
	}

	// ----------------------------------ARRAYS-----------------------------------------------
	// This is where weapons, shields etc. are dumped
	// Weapon[] ShipWeaponsList = new Weapon[type.WeaponSlots];
	// Upgrade[] HullUpgradeList = new Upgrade[type.HullSlots];
	// Upgrade[] ShipUpgradeList = new Upgrade[type.UpgradeSlots];

	/**
 * 
 */
	private void moveBounds() {
		bounds = new Rectangle(xPos, yPos, img.getWidth(), img.getHeight())
				.transform(Transform.createRotateTransform(
						(float) Math.toRadians(rotation), xPos + img.getWidth()
								/ 2, yPos + img.getHeight() / 2));

	}

	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @return the rotation
	 */
	public int getRotation() {
		return rotation;
	}

	/**
	 * @return the rotation2
	 */
	public int getRotation2() {
		return rotation2;
	}

	/**
	 * @param xPos
	 *            the xPos to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @param yPos
	 *            the yPos to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @param rotation
	 *            the rotation to set
	 */
	public void setRotation(int rotation) {
		this.rotation = rotation;
		moveBounds();
	}

	/**
	 * @param rotation2
	 *            the rotation2 to set
	 */
	public void setRotation2(int rotation2) {
		this.rotation2 = rotation2;
	}

	// SYSTEM METHODS
	@Override
	public String toString() {
		return "Ship [PlayerOwner=" + PlayerOwner + ", ID=" + ID + ", type="
				+ type + "]";
	}

	/**
	 * @return the containingField
	 */
	public BattleField getContainingField() {
		return containingField;
	}

	/**
	 * @param containingField
	 *            the containingField to set
	 */
	public void setContainingField(BattleField containingField) {
		this.containingField = containingField;
	}

}
