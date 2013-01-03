
/*
 * PlayerList is the soon-to-be class responsible for creating players!!!
 * Pepta could be the program for sending the info to PlayerList
 * PEPTA = Player Existence Preparation Transcription Apparatus
 * xC: trochu jsem to prekopal hazelo to errory koukni se jestli to funguje hynku
 */
// 

package game.core;

import java.util.Scanner;

public class Pepta {
	static int players = 0;
	
	public void createPlayers(){
		/*
		Scanner wantedPlayers = new Scanner(System.in);
		
		System.out.println("enter number of players");
		players = (wantedPlayers.nextInt());
		wantedPlayers.close();
		*/
		PlayerList playerlist = new PlayerList();
		Player p = new Player();
		for (int x = 0; x <= players ; x++){
			playerlist.createPlayer(p);
		}
		
		Scanner nameScanner = new Scanner(System.in);
		
		for (int createdPlayers = 1; createdPlayers < players; createdPlayers++){
			System.out.println("Enter next player's name:");
			playerlist.namePlayer(createdPlayers, nameScanner.nextLine());
		}
	}
}
