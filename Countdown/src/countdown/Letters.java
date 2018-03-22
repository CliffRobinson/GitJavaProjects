package countdown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Letters {

	static int pCount; //Number of permutations

	public static void iteratePCount(){
		pCount++;
	}

	static int wCount; //Number of words found

	public static void iterateWCount() {
		wCount++;
	}
	
	static int cCount; //Number of comparisons made
	
	public static void iterateCCount() {
		cCount++;
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

		if (pCount == uniqueCombos) {
			System.out.println("The permutations calculated equals n! Congratulations, it works properly!\n");
		} else {
			System.out.println("The permutations calculated does not equal n! It doesn't work properly!");
		}
		
		// Creating a structure to hold the answers. 
		
		ArrayList<String> answerList = new ArrayList<String>();
		

		////////////////////////////////////////////	Comparing Permutation File to Dictionary File	//////////////////////////////////////////// 	

		try (BufferedReader permReader = new BufferedReader(new FileReader("PermutationList.txt"))){
			String perm;
			//System.out.println("\nPrinting Permutations\n");
			while ((perm = permReader.readLine()) != null) {
				//System.out.println("Outer loop iterating.");
				try(BufferedReader dictReader = new BufferedReader(new FileReader(/*"./bin/testAndMisc/original_dictionary_file.txt"*/"OutputDictionary.txt" ))) {
					
					String word;
					while ((word = dictReader.readLine()) != null) {
						//System.out.println("Inner loop iterating.");
						
						
						// Code to sort out discrepancies in word length - is not needed if length of permutation is always as long or longer than every word in the dictionary.
						int upperbound;			
						if (word.length() > perm.length()) {
							upperbound = perm.length();
						}else {
							upperbound = word.length();
						}
						// if removing this code, replace upperbound in the lines below with word.length()
						
						//System.out.println("Permutation is: "+ perm+". Checking if " +perm.substring(0, upperbound)+ " is the same as "+word);
						iterateCCount();
						if(perm.substring(0, upperbound).equals(word)) {
							answerList.add(word);
						}
					}
				}
			}




		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		////////////////////////////////////////////			Outputting Our Answers					////////////////////////////////////////////
		
		Collections.sort(answerList, new Comparator<String>() { //Sorts the array of answers, using a custom comparator and code snippet stolen off the interwebs. 
			@Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if (o1.length()<o2.length()){
                	return -1;
                }else {
                    return o1.compareTo(o2);
                }
            }
			
		});
		
		for (String answer: answerList) {
			System.out.println(answer.length()+" letter answer: " + answer);
		}
		
		System.out.println("\nThis programme made "+cCount+" comparisons.");
	}

}
