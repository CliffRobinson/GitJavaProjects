/*package noughtsandcrosses;

import java.util.Scanner;

import boardgames.Player;

public class NoughtsandCrossesPlayer extends Player{

	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub
		super.takeTurn();
		
		System.out.println("Please enter a command:");
		Scanner scn = new Scanner(System.in);
		
		String input;
		int row=4;
		int column=4;
		Square command = Square.blank;
		
		//while (row == 4 && column == 4 && command.equals(Square.blank)) {
		input = scn.nextLine();
		
		switch(input.charAt(0)) {
		case 'a':
			column = 0;
		case 'b':
			column = 1;
		case 'c':
			column = 2;
		case '1':
			row = 0;
		case '2':
			row = 1;
		case '3':
			row = 2;
		default:
			System.out.println("Please enter a row (1-3), a letter (A-C) and a character (X or O), with no spaces. ");
		}

		switch(input.charAt(1)) {
		case 'a':
			column = 0;
		case 'b':
			column = 1;
		case 'c':
			column = 2;
		case '1':
			row = 0;
		case '2':
			row = 1;
		case '3':
			row = 2;
		default:
			System.out.println("Please enter a row (1-3), a letter (A-C) and a character (X or O), with no spaces. ");
		}
		
		switch(input.charAt(2)) {
		case 'x':
			command = Square.X;
		case 'o':
			command = Square.O;
		default:
			System.out.println("Please enter a row (1-3), a letter (A-C) and a character (X or O), with no spaces. ");
		}
		
		
		
	//}
		
		scn.close();
	}

	
	
}
*/