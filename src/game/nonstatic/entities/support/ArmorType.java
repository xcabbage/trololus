/**
*
* @author DannyUfonek
*
*/
package game.nonstatic.entities.support;

public enum ArmorType {
Light(1), Medium(1), Heavy(1), Invincible(1), Hacked(1) ;

final int ArmorModifier; //some kind of armor modifier property, which will also work towards determining damage

ArmorType(int ArmorModifier) {
this.ArmorModifier = ArmorModifier;
	}
}
