package noughtsandcrosses;

public class NoughtsAndCrossesApp {
	public static void main(String[] args) {
	NoughtsAndCrossesGame game = new NoughtsAndCrossesGame();
	
	game.setUpGame(2);
	game.showBoard();
	game.runGame();
	
	
	}
}
