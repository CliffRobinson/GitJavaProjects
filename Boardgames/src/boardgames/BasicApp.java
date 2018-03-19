package boardgames;

public class BasicApp {

	public static void main(String[] args) {
		SequentialGame game = new SequentialGame();
		
		game.setUpGame(2);
		
		game.runGame();

	}

}
