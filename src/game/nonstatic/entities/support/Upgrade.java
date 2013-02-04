/*
*
* @Author DannyUfonek
*
*/
package game.nonstatic.entities.support;
/*
 * This class serves as the place to define any upgrades that are not weapons and those 
 * that are placed on hull slots or the upgrade slots
 * IS EXTENDED BY Armor, Shield, Booster etc.
 */
public class Upgrade {

	int UpgradeCurrentHP;
	int UpgradeMaxHP;
	boolean attached;	//when a ship blows up, weapons & upgrades could be thrown into space to be picked up by others?
	
}
