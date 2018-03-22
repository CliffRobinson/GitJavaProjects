package testAndMisc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryReader {

	//This class only needs to be used once to filter your raw words file into whatever format you need. 

	public static void main(String[] args) {
		
		String[] printArray = produceArray();
		System.out.println("Total words: " +printArray.length+"\n");
		for(String s: printArray) {
			System.out.println(s);
		}

		writeArrayToFile(printArray);		
	}

	public static String[] produceArray() {
		try (Scanner in = new Scanner(new File(/*"./bin/testAndMisc/original_dictionary_file.txt"*/".\\bin\\testAndMisc\\truncated_dictionary_file.txt"))){
			int i=0;
			String[] stringArray = new String[36]; 
			while (in.hasNext() /*& i<20*/) {
				String line = in.nextLine();
				if(/*line.length()<10*/true) {
					//System.out.println(line.length()+": "+line);
					stringArray[i] = /*line.length()+": "+*/line.toString();
				}

				i++;
			}
			
			
			//Arrays.sort(stringArray);
						
			return stringArray;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return new String[0];
		
	}
	
	public static void writeArrayToFile(String[] inputDictionary){
		try (BufferedWriter br = new BufferedWriter(new FileWriter("OutputDictionary.txt"))) {
			for (String word:inputDictionary) {
				br.write(word);
				br.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}



