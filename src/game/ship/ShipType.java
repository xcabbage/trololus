/*
 * 
 * @Author DannyUfonek
 * 
 */

package game.ship;

/*This enum takes care of the different ship types - currently it only defines how many slots each ship has, 
 * but could be used to house ship ownership and HP in the future. However, this could be sorted out better 
 * by using the Hull Slot to define the ship's HP.
*/
public enum ShipType {

//Imperial ships
Striker(4,1,4), ImperialMedium (5,1,5), Fathership(6,2,6), 

//Space Pirates' ships
SpacePiratesLight(4,1,4), SpacePiratesMedium(4,2,5), OrbitalPowerplant(4,3,7), 

//Xerox Ships
Wisp(5,1,3), XeroxMedium(6,1,4), XeroxHeavy(6,1,7);

/*TODO Add names of ship types currently unnamed &
 * Fiddle with number of slots to balance game (current balance is based on slot total -
 * - Light=9 slots, Medium=11, Heavy=14) - to sort out in future
*/

final int WeaponSlots;
final int HullSlots;
final int UpgradeSlots;
// private int XSize;
// private int YSize;
// private int MaxHP;

/*TODO sort out ship HP & Size
 * MaxHP is meant as the limit up to which you can upgrade using ability slots, but can be thrown out in the future
*/

ShipType(int WeaponSlots, int HullSlots, int UpgradeSlots/*, int XSize, int YSize */) {
this.WeaponSlots = WeaponSlots;
this.HullSlots = HullSlots;
this.UpgradeSlots = UpgradeSlots;
//this.XSize = XSize;
//this.YSize = YSize;
	}

//----------------------------------GETTERS----------------------------------------------

public int getWeaponSlots(){
	return this.WeaponSlots;
	}
public int getHullSlots(){
	return this.HullSlots;
	}
public int getAbilitySlots(){
	return this.UpgradeSlots;
	}
/*public int getXSize(){
	return this.WeaponSlots;
	}
public int getYSize(){
	return this.WeaponSlots;
	}
*/
}
