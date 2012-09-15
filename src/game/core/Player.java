package game.core;

/**
 * 
 * @author DannyUfonek
 *
 */

public class Player {
	
	String Name;
	int number;
	int color;
	
	public void setName(String name){
		this.Name = name;
	}
	
	public void setColor(int color){
		this.color = color;
	}
	public void addKill(){
		Leaderboard.countKill(this.number, this.Name);
		//killstreak announcer moved to Leaderboard
	}
	
	public void addDeath(){
		Leaderboard.countDeath(this.number, this.Name);
		//deathstreak announcer moved to Leaderboard
	}
	
	
}
