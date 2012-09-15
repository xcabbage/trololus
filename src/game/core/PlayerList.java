/*
 * almost finished class responsible for storing players' data (along with leaderboard)!!!
 * 
 */

package game.core;

public class PlayerList {
	
	int players = Pepta.players;
	
	private Player[] playerlist = new Player[players];
	private int playerCount = 0;
	
	public void createPlayer(Player p){
		if(playerCount<playerlist.length){
			playerlist[playerCount] = p;
			System.out.println("Player " + playerCount + " successfully created!");
			playerCount++;
			}
	}
	public void namePlayer(int playerNumber, String playerName){
		playerlist[playerNumber].setName(playerName);
		System.out.println("Player " + playerNumber + "'s name changed to " + playerName);
	}
	public void colorPlayer(int playerNumber, int color){
		playerlist[playerNumber].setColor(color);
		System.out.println("Player " + playerNumber + "'s color changed to " + color);
	}
}
