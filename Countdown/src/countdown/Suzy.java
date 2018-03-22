package countdown;

import java.io.BufferedWriter;
import java.io.IOException;

public class Suzy {

	public void dent(StringBuilder input, String stringSoFar, int generation, int targetLength, BufferedWriter br) throws IOException{
		generation++;
		


		if (stringSoFar.length() == targetLength) { //If the output string is as long as the original string (IE, we've used all the letters), write to file.
			System.out.println("Permutation found: "+stringSoFar);
			br.write(stringSoFar);
			br.newLine();
			Letters.iteratePCount();
		}else {	//Otherwise, go thru each letter in the input, remove it, append to stringSoFar and recurse. 
			char currentChar;
			
			for (int i = 0; i<input.length();i++ ) { 												// For each letter in the string
				currentChar = input.charAt(i); 														// Copy a char out of the input string
				String subHistory = (stringSoFar+currentChar); 										// Append that character to our output string
				StringBuilder subStringBuilder = new StringBuilder(input.toString()); 				// Create a copy of the input string without the copied letter
				subStringBuilder.deleteCharAt(i);													// This needs to be done in two steps to avoid removing characters from Input
				dent(subStringBuilder, subHistory, generation, targetLength, br); 					// And recur. 
				//System.out.println(i+": Current Char is: "+currentChar+", Remaining characters are: "+subStringBuilder.toString());
			}
		}

	}


}
