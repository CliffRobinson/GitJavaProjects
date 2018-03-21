package testAndMisc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryReader {

	//This class only needs to be used once to filter your raw words file into whatever format you need. 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		try (Scanner in = new Scanner(new File(".\\bin\\testAndMisc\\original_dictionary_file.txt"));){
			int i=0;
			while (in.hasNext() & i<20) {
			String line = in.nextLine();
			if(line.length()<10) {
				System.out.println(line.length()+": "+line);	
			}
			
			i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
