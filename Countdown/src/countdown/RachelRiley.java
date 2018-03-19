package countdown;

public class RachelRiley {

	public void Riley(int target, String history, int total, int[] inputnumbers, int generation) {
		generation++;
		//System.out.printf("Generation %d Riley call initiated.\n", generation); //DIAG
		int[] numbers = inputnumbers;		// Possibly optional editable array. 

		//System.out.print("Checking if "+total+ " = "+target+", ");

		if (total == target) {				//Check if the answer has been calculated.
			System.out.println("   SOLUTION FOUND: "+target +" = "+history);	//If it has, output the working. 
			Numbers.iterateuCount();
			Numbers.iteratesCount();
		}else{
			int i = 0;
			do { 		// Needs to pick one of the numbers, then create an array of the remainder. 
				//System.out.printf("Outer loop iteration %d begun\n", i); //DIAG
				int currentnum = 0;		
				//System.out.println(numbers[i]);
				/*System.out.print("Current array: ");
				for (int j:numbers) {
					System.out.print(j+" ");
				}
				System.out.println();		//DIAG: Prints out the array it is working on. */


				if (numbers.length >0) {	// make sure there are numbers left to pick. 
					//System.out.printf("Current array has length %d, if is true, continuing. \n", numbers.length); //DIAG
					currentnum = numbers[i];
					numbers[i] = 0; // remove the number picked from the array.
					/*System.out.print("Current array: ");
					for (int j:numbers) {
						System.out.print(j+" ");
					}
					System.out.println();
					System.out.print("There should be a zero in this array, replacing: "+ currentnum+".\n"); //DIAG*/
					int[] subnumbers = new int[numbers.length-1];	//Create the subarray.
					int subcount = 0;	
					for (int number2:numbers) {
						//System.out.printf("Inner loop iteration %d begun\n",number2); //DIAG
						//System.out.print("Sub: "+ subcount+" Array index: "+subcount+"\n "); //DIAG
						if (number2 != 0) {
							//System.out.print("*** "); //DIAG
							subnumbers[subcount] = number2;
							subcount++;
						}else {
							//System.out.println("Skipping the null value"); //DIAG
						}
						//System.out.print("Array Index: "+ subcount+" Array value: "+number2+" \n");
						//System.out.printf("Inner loop iteration %d ended\n",number2); //DIAG
					}// This loop populates the subarray with the remaining numbers. 
					subcount = 0;

					/*System.out.print("Current number is: "+ currentnum+". The array numbers are: ");
					for (int j:subnumbers) {
					System.out.print(" "+j);
					}
					System.out.println("");//DIAG*/
					//System.out.println("Array length is: "+subnumbers.length+"\n"); //DIAG

					Riley(target, "("+history+" + "+currentnum+")",total + currentnum, subnumbers, generation);
					if (total == 0) {
					//Don't subtract or multiply if the current number is zero. 	
					}else {
					Riley(target, "("+history+" - "+currentnum+")",total - currentnum, subnumbers, generation);
					Riley(target, "("+history+" * "+currentnum+")",total * currentnum, subnumbers, generation);
					}
					if (total == 0 || currentnum == 0 || total%currentnum != 0 ) { // Checks if the division function will produce a meaningful integer.
						//If not, don't bother with the division.
					}else {
						Riley(target, "("+history+" / "+currentnum+")",total / currentnum, subnumbers, generation);
					}

					numbers[i] = currentnum;
				} else {
					//System.out.printf("Current array has length %d, if is false, printing. \n", numbers.length);//DIAG
					//System.out.println("NO SOLUTION FOUND: "+total+" = "+history); 
					Numbers.iterateuCount();				
				}
				//System.out.printf("Outer loop iteration %d ended\n", i); //DIAG
				i++;
			} while(i<numbers.length);
		}
		//System.out.printf("Generation %d Riley call completed.\n", generation);//DIAG
	}
}
