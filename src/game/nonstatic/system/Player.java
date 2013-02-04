package game.nonstatic.system;

import org.newdawn.slick.Color;

/**
 * 
 * @author DannyUfonek
 * 
 */

public class Player {

	String Name;
	int number;
	Color color;



	// if no arguments are supplied, set default color and name
	public Player() {
		Name = "Defaultee";
		color = Color.cyan;
	}

	// properly supplied constructor
	public Player(String playerName, Color col) {
		Name = playerName;
		color = col;
	}
	
	
	

	//kill management
	public void addKill() {
		Leaderboard.countKill(this.number, this.Name);
		// killstreak announcer moved to Leaderboard
	}

	public void addDeath() {
		Leaderboard.countDeath(this.number, this.Name);
		// deathstreak announcer moved to Leaderboard
	}

	//getters
	public String getName(){
		return Name;
	}
	
	public Color getColor(){
		return color;
	}
	
	// setters
	public void setName(String name) {
		this.Name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
