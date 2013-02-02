/*
 * 
 * @Author DannyUfonek
 * 
 */

package game.ship;

/*
 * We need to make some decisions regarding game design before we start creating weapons, 
 * so I'm making it as changeable as possible,
 * so that we can adjust it to how the map (and ships) will work later.
 */

public class Weapon {
//	int Strength;	//or Damage, could also be a double maybe
//	int Range;		//could be double too --- all could be sorted out by an enum again
	int MaxHP;
	int CurrentHP;
	boolean attached; //when a ship blows up, weapons & upgrades could be thrown into space to be picked up by others?
	WeaponType type;
	
}
