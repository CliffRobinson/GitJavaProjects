package noughtsandcrosses;

public enum Square {
	X,O, blank;
	
	public String toString() {
		switch(this) {
		case O:
			return "O";
		case X:
			return "X";
		case blank:
			return "_";
		default:
			break;
		}
		return null;
	}
	
	
	
}
