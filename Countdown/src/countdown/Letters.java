package countdown;

import java.util.Arrays;
import java.util.Scanner;

public class Letters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String rawInput;
		StringBuilder input = new StringBuilder();

		System.out.println("Please type in the letters");
		
		rawInput = scn.next();
		
		System.out.println("The input is:"+rawInput);
		
		char[] inputArray = rawInput.toCharArray();
		
		Arrays.sort(inputArray);
		
		for(char c: inputArray) {
			input.append(c);
		}
		
		System.out.println("The sorted input is: " + input.toString());
		
		Suzy suzy = new Suzy();
		
		suzy.dent(input, "", 0, input.length());
		
	}

}
