/*
 * almost finished class responsible for storing players' data (along with leaderboard)!!!
 * 
 */

package game.nonstatic.system;

import org.newdawn.slick.Color;


public class PlayerList {
	
	int players = Pepta.players;
	
	private Player[] playerlist = new Player[players];
	private int playerCount = 0;
	
	public void createPlayer(Player p){
		if(playerCount<playerlist.length){
			playerlist[playerCount] = p;
			//adds one to the player's number, so that we don't get player 0.
			//However, player 0 is saved in the array
			int playerCountReal = playerCount+1;
			System.out.println("Player " + playerCountReal + " successfully created!");
			playerCount++;
			}
	}
	public void namePlayer(int playerNumber, String playerName){
		playerlist[playerNumber].setName(playerName);
		System.out.println("Player " + playerNumber + "'s name changed to " + playerName);
	}
	public void colorPlayer(int playerNumber, Color color){
		playerlist[playerNumber].setColor(color);
		System.out.println("Player " + playerNumber + "'s color changed to " + color);
	}
}
