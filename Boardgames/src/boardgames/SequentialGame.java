package boardgames;

import java.util.Scanner;

public class SequentialGame {

	int numberOfPlayers;
	private boolean isWon = false;


	public boolean isWon() {
		return isWon;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

	Player[] players;

	public void setUpGame(int howMany){
		numberOfPlayers = howMany;
		players = new Player[howMany];

		Scanner scn = new Scanner(System.in);

		for(int i = 0;i<howMany;i++) {
			System.out.println("Player "+(i+1)+", please enter your name.");
			players[i] = new Player(i,scn.nextLine());

		}
		//scn.close();			
	}

	public void runGame() {
		while (isWon == false) {

			for (Player player:players) {
				if(isWon == false) {
					takeTurn(player);
				}
			}

		}
	}
	public void takeTurn(Player player){
		System.out.println("Player "+(player.getId()+1)+", "+player.getName()+", it's your turn.");
	}
}
