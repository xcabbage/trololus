/*
 * 
 * @Author DannyUfonek
 * 
 */

package game.nonstatic.entities.controllables;

/*This enum takes care of the different ship types - currently it only defines how many slots each ship has, 
 * but could be used to house ship ownership and HP in the future. However, this could be sorted out better 
 * by using the Hull Slot to define the ship's HP.
*/
public enum ShipType {

	
//Imperial ships
Striker(4,1,4,300, StrikerPath), ImperialMedium (5,1,5,600, ), Fathership(6,2,6,1500), 

//Space Pirates' ships
SpacePiratesLight(4,1,4,200), SpacePiratesMedium(4,2,5,500), OrbitalPowerplant(4,3,7,1200), 

//Xerox Ships
Wisp(5,1,3,250), XeroxMedium(6,1,4,500), XeroxHeavy(6,1,7,1400);

/*TODO HP | Add names of ship types currently unnamed &
 * Fiddle with number of slots to balance game (current balance is based on slot total -
 * - Light=9 slots, Medium=11, Heavy=14) - to sort out in future
*/

final int WeaponSlots;
final int HullSlots;		//I guess you can't put stuff onto already full ships, therefore final
final int UpgradeSlots;		//but with space pirates it might be possible.
static String RelPath = "resources/Splash/Imperial/Striker/";


final int Cost;				//When you're buyin' yo' ship, this is what you're payin'
final String image;			//Path to the ship's model to be used for rendering

// private int XSize;
// private int YSize;
// private int MaxHP;

/*TODO HP | sort out ship HP, Size & Cost
 * MaxHP is meant as the limit up to which you can upgrade using ability slots, but can be thrown out in the future
*/

ShipType(int WeaponSlots, int HullSlots, int UpgradeSlots, int Cost, String image /*, int XSize, int YSize */) {
this.WeaponSlots = WeaponSlots;
this.HullSlots = HullSlots;
this.UpgradeSlots = UpgradeSlots;
this.Cost = Cost;
this.image = RelPath.concat(image).concat(".png");
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
