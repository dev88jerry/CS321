package lab5;

import java.util.Iterator;

public class Main {
	
	public static void main(String[] args){
		Team a = new Team();							
		Team b = new Team("Tigers");
		
		try{											
			a.insert(new Player());
			a.insert(new Player());
		}catch(Exception e){
				e.printStackTrace();
		}
		
		
		for(int i = 0; i < 16; i++){					
			try{
			a.insert(new Player(i, "Thing" + i));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		for(int i = 0; i < 17; i++){					
			try{
			b.insert(new Player(i, "Johnny the " + i));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println(a.toString());				
		System.out.println(b.toString());				
		
		try{									
			a.insert(new Player(99, "HasAName"));		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{									
			b.insert(new Player(99, "HasAName"));		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Contains Test: Thing1 in Team a?" + a.contains(new Player(1, "Thing1")));
		System.out.println("Contains Test: Thing1 in Team a?" + a.contains(new Player(1, "Thing1")));
		System.out.println("Contains Test: Thing1 in Team a?" + a.contains(new Player(1, "Thing1")));
		System.out.println("Contains Test: Thing1 in Team a?" + a.contains(new Player(1, "Thing1")));
		System.out.println("Contains Test: Thing1 in Team b?" + b.contains(new Player(1, "Thing1")));
		
		System.out.println("\nThe iterator test:\n");
		Iterator<Player> itA = a.iterator();
		Iterator<Player> itB = b.iterator();
		System.out.println("Test A:\n");
		while(itA.hasNext()){
			System.out.println((itA.next()).toString());
		}
		
		System.out.println("\nTest B:\n");
		while(itB.hasNext()){
			System.out.println((itB.next()).toString());
		}
		
		System.out.println("Tests complete!");
	}
	
}
