package countdown;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import testAndMisc.DictionaryReader;

public class Letters {

	static int pCount; //Number of permutations
	
	public static void iteratePCount(){
		pCount++;
	}
	
	static int wCount; //Number of words found
	
	public static void iterateWCount() {
		wCount++;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String rawInput;
		StringBuilder input = new StringBuilder();

		//////////////////////////////////////////// 			Taking the User Input 				////////////////////////////////////////////
		
		System.out.println("Please type in the letters");
		
		rawInput = scn.next(); //should change this so it filter out spaces
		
		//////////////////////////////////////////// 	Alphabetically Sorting the User Input  		////////////////////////////////////////////
		
		System.out.println("The input is:"+rawInput);
		
		char[] inputArray = rawInput.toCharArray();
		
		Arrays.sort(inputArray);
		
		for(char c: inputArray) {
			input.append(c);
		}
		
		System.out.println("The sorted input is: " + input.toString());
		System.out.println();
				
		////////////////////////////////////////////	Recursively Finding Permutations			////////////////////////////////////////////
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter("PermutationList.txt"))) {
			
			Suzy suzy = new Suzy();
			suzy.dent(input, "", 0, input.length(),br);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////////////////////// 	Checking the Number of Permutations Found	////////////////////////////////////////////
		
		int arrayLength = input.length();
		int uniqueCombos = 1;
		
		for(int i = arrayLength;i>0;i--) {
			uniqueCombos = uniqueCombos*i;
		}
		
		System.out.printf("The length of the input string is %d, the number of unique combinations is %d! = %d\n", arrayLength, arrayLength, uniqueCombos);
		
		// This code calculates n!, where n is the length of the input string. There are n! unique permutations of letters, so comparing the number of permutations the code produces
		// to n! can confirm whether it is finding each unique combination. 
		
		System.out.printf("\nThe number of permutations calculated is %d\n", pCount);
		System.out.printf("The number of solutions found is %d\n", wCount);
		if (pCount == uniqueCombos) {
			System.out.println("The permutations calculated equals n! Congratulations, it works properly!");
		} else {
			System.out.println("The permutations calculated does not equal n! It doesn't work properly!");
		}
		
		////////////////////////////////////////////	Comparing Permutation File to Dictionary File	//////////////////////////////////////////// 	
		
	}

}
