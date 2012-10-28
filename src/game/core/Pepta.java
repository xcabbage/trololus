<<<<<<< HEAD
/*
 * PlayerList is the soon-to-be class responsible for creating players!!!
 * Pepta could be the program for sending the info to PlayerList
 * PEPTA = Player Existence Preparation Transcription Apparatus
 */

package game.core;

import java.util.Scanner;

public class Pepta {
	static int players = 6;
	
	public void createPlayers(){
		
		Scanner wantedPlayers = new Scanner(System.in);
		
		System.out.println("Enter number of players");
		players = (wantedPlayers.nextInt());
		wantedPlayers.close();
		
		PlayerList playerlist = new PlayerList();
		Player p = new Player();
		for (int createdPlayers = 0; createdPlayers <= players ; createdPlayers++){
			playerlist.createPlayer(p);
		}
		
		System.out.println("Now you will be asked to enter players' names");
		
		Scanner nameScanner = new Scanner(System.in);
		
		
		for (int namedPlayers = 1; namedPlayers < players; namedPlayers++){
			System.out.println("Enter next player's name:");
			playerlist.namePlayer(namedPlayers, nameScanner.nextLine());
		}
	}
}
=======
/*
 * PlayerList is the soon-to-be class responsible for creating players!!!
 * Pepta could be the program for sending the info to PlayerList
 * PEPTA = Player Existence Preparation Transcription Apparatus
 */

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
>>>>>>> f4ed35bb1d3626a3c7bed78d09dc30d0bfbf3c3b
