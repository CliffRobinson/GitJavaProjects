package countdown;

public class Suzy {

	public void dent(StringBuilder input, String stringSoFar, int generation, int targetLength) {
		generation++;
		//char currentChar;


		if (stringSoFar.length() == targetLength) { //If the permutation is as long as the original string (IE, we've used all the letters), output the string.
			System.out.println("Permutation found: "+stringSoFar);
		}else {	//Otherwise, go thru each letter in the input, remove it, append to stringSoFar and recurse. 
			char currentChar;
			
			for (int i = 0; i<input.length();i++ ) { //For each letter in the string
				currentChar = input.charAt(i); //Copy a char out of the input string
				String subHistory = (stringSoFar+currentChar); //Append that character to our output string
				StringBuilder subStringBuilder = new StringBuilder(input.toString()); // Create a copy of the input string without the copied letter
				subStringBuilder.deleteCharAt(i);
				//dent(subStringBuilder, subHistory, generation, targetLength); //And recur. 
				System.out.println(i+": Current Char is: "+currentChar+", Remaining characters are: "+subStringBuilder.toString());
			}
		}

	}


}
