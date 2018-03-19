package countdown;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Numbers {
	
	static int uCount;
	
	public static void iterateuCount(){
		uCount++;
	}
	
	static int sCount;
	
	public static void iteratesCount() {
		sCount++;
	}
	
	/*public static void diag(boolean diag, int generation, String output) {
		if (diag) {
			for (int i = 0;i<generation;i++) {
				System.out.print("\t");
			}
			System.out.println(output);
		}
	}*/
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int[] numbers = new int[6];
		//System.out.println("Please enter the first number.");

		
		for (int i=0;i<numbers.length;i++) {
			while(numbers[i]==0) {
				try {
					System.out.println("Please enter the number "+(i+1));
					numbers[i] = scn.nextInt();
					if (numbers[i] == 0) {
						System.out.println("Please enter a whole nonzero number.\n");
					}
				} catch (InputMismatchException e)  {
					System.out.println(scn.next()+" is not a whole nonzero number.\nPlease enter a whole nonzero number.\n");

				}
			}
		}
		/*System.out.println("Please enter the second number.");
		numbers[1] = scn.nextInt();
		System.out.println("Please enter the third number.");
		numbers[2] = scn.nextInt();
		System.out.println("Please enter the forth number.");
		numbers[3] = scn.nextInt();
		System.out.println("Please enter the fifth number.");
		numbers[4] = scn.nextInt();
		System.out.println("Please enter the sixth number.");
		numbers[5] = scn.nextInt();
		*/
		// Loop outputs the contents of the array.
		//int[] numbers = {25,50,75,7,10,9};
		for (int number: numbers) {
			System.out.print(number+" ");
		}
		System.out.println("\nDone outputting the intial array.");
		
		
		/*int arrayLength = numbers.length;
		int uniqueCombos = 1;
		
		for(int i = arrayLength;i>0;i--) {
			uniqueCombos = uniqueCombos*i;
		}*/ 
		
		//System.out.printf("The length of the array is %d, the number of unique combinations is %d! = %d\n", arrayLength, arrayLength, uniqueCombos);
		
		// This code calculates n!, where n is the length of the array. There are n! unique permutations of numbers, so comparing the number of permutations the code produces
		// to n! can confirm whether it is finding each unique combination. 

		System.out.println("Please enter the target number.");
		int target = scn.nextInt();
		//System.out.println(numbers[0]);

		System.out.println("");
		
		RachelRiley rachel = new RachelRiley();
		
		rachel.Riley(target, "0",0,numbers, 0);
		
		System.out.printf("The number of permutations calculated is %d\n", uCount);
		System.out.printf("The number of solutions found is %d\n", sCount);
		/*if (uCount == uniqueCombos) {
			System.out.println("The permutations calculated equals n! Congratulations, it works properly!");
		} else {
			System.out.println("The permutations calculated does not equal n! It doesn't work properly!");
		}*/
		
		scn.close();
	}
	
}




