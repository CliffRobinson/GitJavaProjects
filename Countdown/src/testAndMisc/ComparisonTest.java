package testAndMisc;

public class ComparisonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String perm = "eilv";
		String word = "a";
				
		System.out.println("Checking if " +perm.substring(0, word.length())+ " is the same as "+word);
		if(perm.substring(0, word.length()).equals(word)) {
			System.out.println("Answer found: "+word);
		}
		
	}

}
