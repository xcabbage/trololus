package game.nonstatic.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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

	// Movement declarations (I think we are not working in 3D)
	int XSpeed;
	int YSpeed;
	int XPos;
	int YPos;
	int angle;
	int speed;

	// Ship Properties declarations
	int HullHP;// Percentage?
	int PlayerOwner = 5;
	int ID = 3;
	ShipType type; // ShipType includes number of slots, will also very probably
					// contain ship size
	private Image img;

	public Projectile() {
		commonInit();
	}


	// ----------------------------------GETTERS----------------------------------------------

	/**
	 * @param xPos
	 * @param yPos
	 * @param angle
	 * @param speed
	 */
	public Projectile(int xPos, int yPos, int angle, int speed) {
		super();
		XPos = xPos;
		YPos = yPos;
		this.angle = angle;
		this.speed = speed;
		commonInit();
	}

	void commonInit(){
		try {
			img = new Image("resources/Splash/rocket.png").getScaledCopy(0.1f);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getID() {
		return ID;
	}

	public int getXSpeed() {
		return XSpeed;
	}

	public int getYSpeed() {
		return YSpeed;
	}

	public int getXPos() {
		return XPos;
	}

	public int getYPos() {
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

	// ----------------------------------ARRAYS-----------------------------------------------
	// This is where weapons, shields etc. are dumped
	// Weapon[] ShipWeaponsList = new Weapon[type.WeaponSlots];
	// Upgrade[] HullUpgradeList = new Upgrade[type.HullSlots];
	// Upgrade[] ShipUpgradeList = new Upgrade[type.UpgradeSlots];

	// SYSTEM METHODS
	@Override
	public String toString() {
		return "Projectile [PlayerOwner=" + PlayerOwner + ", ID=" + ID
				+ ", type=" + type + "]";
	}


	/**
	 * 
	 */
	public void draw() {
		img.draw(XPos,YPos);
		
	}

}
