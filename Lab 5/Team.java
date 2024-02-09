package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Team {
	
	private String name;
	
	private ArrayList<Player> team;
	
	private int numPlayers;
	
	private int currentMax;
	
	
	/**
	 * @param name The name the team will have.
	 */
	public Team(String name){
		this.name = name;
		this.numPlayers = 0;
		this.currentMax = 5;
		team = new ArrayList<Player>(currentMax);
	}

	public Team(){
		this("noname");
	}
	
	
	/**
	 * @param p		
	 * @throws Exception 
	 */
	public void insert(Player p) throws Exception{
		if(numPlayers != 17){													
			if(!contains(p)){													
				if(this.numPlayers != this.currentMax){						    
						team.add(p);											
						numPlayers++;											
				}
				else{															
					currentMax = 2*currentMax; 									
					ArrayList<Player> temp = new ArrayList<Player>(currentMax);
					Iterator<Player> it = team.iterator();
					while(it.hasNext()){										
						temp.add(it.next());
					}
					team = temp;
					team.add(p);												
					numPlayers++;								
				}
			}
			else{																
				throw new Exception("Player is already contained in the team.");
			}
		}	
		else{																	
			throw new Exception("17 is the maximum number of players and it has been reached.");
		}
	}
	
	
	/**
	 * @param p 
	 * @return boolean
	 */
	public boolean contains(Player p){
		Iterator<Player> it = this.team.iterator();
		while(it.hasNext()){
			if((it.next()).equals(p)){					
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @return Iterator
	 */
	public Iterator<Player> iterator(){
		return this.team.iterator();
	}
	
	
	/**
	 * @return String 
	 */
	public String toString(){
		String toReturn = "Team: " + this.name + "\n" + "Players:\n";			
		Iterator<Player> it = iterator();
		while(it.hasNext()){
			toReturn = toReturn + "\t" + (it.next()).toString() + "\n";
		}
		return toReturn; 
	}
}
