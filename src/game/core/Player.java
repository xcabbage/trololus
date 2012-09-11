package game.core;

/**
 * 
 * @author DannyUfonek
 *
 */

public class Player {
	
	//boolean alive;
	String Name;
	int color;
	int kills, deaths, killstreak, deathstreak;
	
	public void setName(String name){
		this.Name = name;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public void addKill(){
		kills+=1;
		killstreak+=1;
		deathstreak=0;
		//killstreak announcer
		switch (killstreak){
		case 1:
			break;
		case 2:
			break;
		case 3: System.out.println(this.Name + " is on a killing spree!");
			break;
		case 4: System.out.println(this.Name + " is dominating!");
			break;
		case 5: System.out.println(this.Name + " has a mega kill!");
			break;
		case 6: System.out.println(this.Name + " is unstoppable!");
			break;
		case 7: System.out.println(this.Name + " is just a bit too lucky!");
			break;
		case 8: System.out.println(this.Name + " is unstoppable!");
			break;
		case 9: System.out.println(this.Name + " is GODLIKE!");
			break;
		case 20: System.out.println(this.Name + " IS A CHEATER");
			//alive = false; //XD
			break;
		default: System.out.println(this.Name + " is BEYOND GODLIKE! Somebody kill him/her!!!");
			break;
		}
	}
	
	public void addDeath(){
		//alive = false;
		deaths+=1;
		killstreak=0;
		deathstreak+=1;
		//deathstreak announcer
				switch (deathstreak){
				case 1:
					break;
				case 2:
					break;
				case 3: System.out.println(this.Name + " is on a dying spree!");
					break;
				case 4: System.out.println(this.Name + " is a target!");
					break;
				case 5: System.out.println(this.Name + " isn't alive!");
					break;
				case 6: System.out.println(this.Name + " is dead a bit too often!");
					break;
				case 7: System.out.println(this.Name + " is constantly being abused by others!");
					break;
				case 8: System.out.println(this.Name + " is having a really bad day!");
					break;
				case 9: System.out.println(this.Name + " is full of shit!");
					break;
				case 20: System.out.println(this.Name + " just destroyed the keyboard and burnt the house down");
					break;
				default: System.out.println(this.Name + " is FREE EXP!");
					break;
				}
	}
	
	public int getKills(){
		return kills;
	}
	
	public int getDeaths(){
		return deaths;
	}
	
	public int getKillstreak(){
		return killstreak;
	}
	
	public int getDeathstreak(){
		return deathstreak;
	}
}
