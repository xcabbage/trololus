package game.core;

/**
 * 
 * @author DannyUfonek
 *
 */

//DATA CLASS FOR KEEPING TRACK OF PLAYERS' SCORE------------------------------------------------------------------------
//Cookies offered to anyone who can make it graphic*

public class Leaderboard {
	static int players = Pepta.players;
	static int kills[]=new int[players];
	static int killstreak[]=new int[players];
	static int deaths[]=new int[players];
	static int deathstreak[]=new int[players];
	static String playersNames[]=new String[players];
	
	//METHODS FOR GRAPHIC LEADERBOARD-----------------------------------------------------------------------------------
	
	public static int getKills(int playerNumber){
		return kills[playerNumber];
	}
	public static int getDeaths(int playerNumber){
		return deaths[playerNumber];
	}
	public static int getKillstreak(int playerNumber){
		return killstreak[playerNumber];
	}
	public static int getDeathstreak(int playerNumber){
		return deathstreak[playerNumber];
	}
	
	
	//METHODS TO COUNT SCORE--------------------------------------------------------------------------------------------
	
	public static void countKill(int playerNumber, String playerName){
		kills[playerNumber]++;
		killstreak[playerNumber]++;
		deathstreak[playerNumber] = 0;
		switch (killstreak[playerNumber]){
		case 1:
			break;
		case 2:
			break;
		case 3: System.out.println(playerName + " is on a killing spree!");
			break;
		case 4: System.out.println(playerName + " is dominating!");
			break;
		case 5: System.out.println(playerName + " has a mega kill!");
			break;
		case 6: System.out.println(playerName + " is unstoppable!");
			break;
		case 7: System.out.println(playerName + " is just a bit too lucky!");
			break;
		case 8: System.out.println(playerName + " is unstoppable!");
			break;
		case 9: System.out.println(playerName + " is GODLIKE!");
			break;
		case 20: System.out.println(playerName + " IS A CHEATER");
			break;
		default: System.out.println(playerName + " is BEYOND GODLIKE! Somebody kill him/her!!!");
			break;
		}
	
	}
	
	public static void countDeath(int playerNumber, String playerName){
		deaths[playerNumber]++;
		killstreak[playerNumber] = 0;
		deathstreak[playerNumber]++;
		switch (deathstreak[playerNumber]){
		case 1:
			break;
		case 2:
			break;
		case 3: System.out.println(playerName + " is on a dying spree!");
			break;
		case 4: System.out.println(playerName + " is a target!");
			break;
		case 5: System.out.println(playerName + " isn't alive!");
			break;
		case 6: System.out.println(playerName + " is dead a bit too often!");
			break;
		case 7: System.out.println(playerName + " is constantly being abused by others!");
			break;
		case 8: System.out.println(playerName + " is having a really bad day!");
			break;
		case 9: System.out.println(playerName + " is full of shit!");
			break;
		case 20: System.out.println(playerName + " just destroyed the keyboard and burnt the house down");
			break;
		default: System.out.println(playerName + " is FREE EXP!");
			break;
		}
	}
	
	
	
	
	/*
	 * This creates the Leaderboard as a singleton, however, this might be unsuitable for playing multiple games,
	 *  as the Leaderboard has to be cleared before playing another game.
	 */
	private static final Leaderboard singleton = new Leaderboard();
	
	public Leaderboard geLeaderboard(){
		return singleton;
	}
	
	
}
//*Disclaimer: conditions regarding cookie delivery may change without notice.