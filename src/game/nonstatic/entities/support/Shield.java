/**
*
* @author DannyUfonek
*
*/
package game.nonstatic.entities.support;

public class Shield extends Upgrade {
	int radius;
	int ShieldCurrentHP;
	int ShieldMaxHP;
	int ReviveTime; //=time to revive after ShieldHP drops to 0
	
//------------------------------------GETTERS------------------------------------------------------
	public int getRadius() {
		return radius;
	}
	public int getShieldCurrentHP() {
		return ShieldCurrentHP;
	}
	public int getShieldMaxHP() {
		return ShieldMaxHP;
	}
	public int getReviveTime() {
		return ReviveTime;
	}
//------------------------------------SETTERS------------------------------------------------------
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setShieldCurrentHP(int shieldCurrentHP) {
		ShieldCurrentHP = shieldCurrentHP;
	}
	public void setShieldMaxHP(int shieldMaxHP) {
		ShieldMaxHP = shieldMaxHP;
	}
	public void setReviveTime(int reviveTime) {
		ReviveTime = reviveTime;
	}

	
}
