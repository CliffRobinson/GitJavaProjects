package boardgames;

public class Player {
	private int id;
	private String name;
	
	public Player() {
		this(0,"Default");
	}
	
	public Player(int id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
