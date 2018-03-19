package noughtsandcrosses;

import java.util.Scanner;

import boardgames.Player;
import boardgames.SequentialGame;

public class NoughtsAndCrossesGame extends SequentialGame {
	Square[][] board = new Square[3][3];

	boolean isDrawn = false;
	
	@Override
	public void setUpGame(int howMany) {
		// TODO Auto-generated method stub
		super.setUpGame(2);

		//board[0][0] = Square.blank;

		/*for(Square[] row:board) {
			for(Square position:row) {
				position = Square.blank;
			}
		}*/

		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = Square.blank;
			}
		}

	}

	public void showBoard() {
		System.out.println("\n : A B C");
		for (int i=0;i<3;i++) {
			System.out.print((i+1)+": ");
			for(Square position:board[i]) {
				System.out.print(position.toString()+",");
			}

			/*for(int j=0;j<3;j++) {
				System.out.print(board[i][j].toString()+",");
			}
			 */
			System.out.println();

		}
		System.out.println();
	}

	public void makeMove(int row, int column, Square command) {
		//System.out.println("Putting a "+command.toString()+" at row " +row+"and column"+column);
		board[row][column] = command; 
	}

	@Override
	public boolean isWon() {
		/*if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) { //Initial code, only checks the top line. 
			setWon(true);
			return true;
		}else {
			setWon(false);
			return false;
		}*/

		for (int i = 0; i<3; i++) { //This checks whether any row matches. 
			/*System.out.println("Checking weather " +board[i][0]+" isn't blank: "+(board[i][0].equals(Square.blank)==false));
			System.out.println("Checking weather " +board[i][0]+" is the same as "+board[i][1]+": "+board[i][0].equals(board[i][1]));
			System.out.println("Checking weather " +board[i][0]+" is the same as "+board[i][2]+": "+board[i][0].equals(board[i][2]));*/
			//System.out.println();
			if((board[i][0].equals(Square.blank)==false) && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) { //Checks each row, if all are the same (and not blank) returns a winner.
				setWon(true);
				return true;
			}
		}

		for (int i = 0; i<3; i++) { //This checks whether any column matches. 
			if((board[0][i].equals(Square.blank)==false) && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
				setWon(true);
				return true;
			}
		}

		if ((board[1][1].equals(Square.blank)==false) && board[1][1].equals(board[0][0]) && board[1][1].equals(board[2][2])){ //Checks if the southeast diagonal matches.
			setWon(true);
			return true;
		}

		if ((board[1][1].equals(Square.blank)==false) && board[1][1].equals(board[0][2]) && board[1][1].equals(board[2][0])){ //Checks if the southwest diagonal matches.
			setWon(true);
			return true;
		}
		
		if (isDrawn == false) {
			isDrawn = true;
			for (Square[] line: board) {
				for (Square square:line) {
					if (square.equals(Square.blank)) {
						isDrawn = false;
					}
				}
			}
		} 
		
		if (isDrawn == true){
			System.out.println("The game is a draw!");
			setWon(true);
			return true;
		}

		return false;


	}

	public void takeTurn(Player player) {
		// TODO Auto-generated method stub
		super.takeTurn(player);

		System.out.println("Please enter a command:");
		Scanner scn = new Scanner(System.in);

		String input;
		int row=4;
		int column=4;

		while (row == 4 || column == 4) {
			input = scn.nextLine();

			switch(input.charAt(0)) {
			case 'a':
				column = 0;
				break;
			case 'b':
				column = 1;
				break;
			case 'c':
				column = 2;
				break;
			case '1':
				row = 0;
				break;
			case '2':
				row = 1;
				break;
			case '3':
				row = 2;
				break;
			default:
				//System.out.println("Please enter a row (1-3), a letter (A-C) with no spaces. ");
				break;
			}

			switch(input.charAt(1)) {
			case 'a':
				column = 0;
				break;
			case 'b':
				column = 1;
				break;
			case 'c':
				column = 2;
				break;
			case '1':
				row = 0;
				break;
			case '2':
				row = 1;
				break;
			case '3':
				row = 2;
				break;
			default:
				//System.out.println("Please enter a row (1-3), a letter (A-C), with no spaces. ");
				break;
			}

			if(row == 4 || column ==4) {
				System.out.println("Please enter a row (1-3), and a letter (A-C), with no spaces. ");
			}
			
			if (row != 4 && column != 4 &&(board[row][column].equals(Square.blank)==false)) {
				System.out.println("Please choose a blank square.");
				row = 4;
				column = 4;
			}

			if (row != 4 && column != 4) {

				if (player.getId()== 1) {
					makeMove(row, column, Square.X);
				}else {
					makeMove(row, column, Square.O);
				}
			}
			showBoard();
			
			if (isWon()) { 
				//System.out.println("The game is over!");
				if (isDrawn == false) {
					System.out.println("Player "+(player.getId()+1)+", "+player.getName()+", you have won!");
				}
			}

		}

		//scn.close();
	}

}
