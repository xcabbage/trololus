/*
 * PlayerList is the soon-to-be class responsible for creating players!!!
 * Pepta could be the program for sending the info to PlayerList
 * PEPTA = Player Existence Preparation Transcription Apparatus
 */

package game.core;

public class Pepta {
	static int players = 5;
	public void createPlayers(){
		PlayerList playerlist = new PlayerList();
		Player p = new Player();
		for (int x = 1; x < players ; x++){
			playerlist.createPlayer(p);
		}
		playerlist.namePlayer(1,"XCABBAGE");
		playerlist.namePlayer(2,"DannyUfonek");
	}
}
