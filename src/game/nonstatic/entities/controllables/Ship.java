/*
 * 
 * @Author DannyUfonek
 * 
 */
package game.nonstatic.entities.controllables;

import game.nonstatic.entities.support.Upgrade;
import game.nonstatic.entities.support.Weapon;

/*
 * Main class of SHIPS, will most probably include all behaviour & info related to type, (size), speed, position, HP, ownership etc.
 */

public class Ship {

//Movement declarations (I think we are not working in 3D)
	int XSpeed;
	int YSpeed;
	int XPos;
	int YPos;
	
//Ship Properties declarations
	int HullHP;//Percentage?
	int PlayerOwner;
	ShipType type; // ShipType includes number of slots, will also very probably contain ship size
	
//----------------------------------GETTERS----------------------------------------------
	
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
	
//----------------------------------SETTERS----------------------------------------------
	
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

//----------------------------------ARRAYS-----------------------------------------------
	//This is where weapons, shields etc. are dumped
	Weapon[] ShipWeaponsList = new Weapon [type.WeaponSlots];
	Upgrade[] HullUpgradeList = new Upgrade [type.HullSlots];
	Upgrade[] ShipUpgradeList = new Upgrade [type.UpgradeSlots];
	
}
