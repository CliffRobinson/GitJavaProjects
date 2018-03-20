package testAndMisc;
class Loop {
	public int counter;
	
	public Loop(int i) {
		//System.out.println("constructor running");
		counter = i;
	}
	
	public void incDown(int counter) {
		System.out.print(counter+"\n");
		if (counter != 0) {
			incDown(counter-1);
		}
	}
	
	public void incDown() {
		incDown(counter);
	}
	
}


public class RecursionTester {
	public static void main(String[] args){
		//System.out.println("Running...");
		Loop Loop1 = new Loop(5);	
		//System.out.println(Loop1.counter);
		Loop1.incDown();
	}
	
}
