/**
*
* @author DannyUfonek
*
*/
package game.nonstatic.entities.support;

public class Armor extends Upgrade {

	int ArmorValue; //will be crucial for determining damage done to ship
	ArmorType ArmorType;
	public int getArmorValue() {
		return ArmorValue;
	}
	public ArmorType getArmorType() {
		return ArmorType;
	}
	public void setArmorValue(int armorValue) {
		ArmorValue = armorValue;
	}
	public void setArmorType(ArmorType armorType) {
		ArmorType = armorType;
	}
	
}
