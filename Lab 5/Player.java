package lab5;

public class Player {
	
	private String name;
	
	private int pos;

	public Player(){
		this(0, "noname");
	}
	
	/**
	 * @param pos Position of the player.
	 * @param name Name of the player.
	 */
	public Player(int pos, String name) {
		this.name = name;
		this.pos = pos;
	}

	/**
	 * @return String The string representation of the player.
	 */
	public String toString(){
		return "Player no " + this.pos + " name: " + this.name;
	}
	
	/**
	 * @param p The player to check against this player.
	 * @return true/false Equal/Not equal
	 */
	public boolean equals(Player p){
		return this.name.equals(p.name) && p.pos == this.pos;
	}
}
