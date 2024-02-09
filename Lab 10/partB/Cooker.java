package Lab10B;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Cooker {
	
	public static void main(String[] args){
		//2d array to initialize the semaphores
		int[][] a = {
				{0,0,0,1,0,0,0,0,0}, // p 1 signals p 4
				{0,0,0,1,0,0,0,0,0}, // p 2 signals p 4
				{0,0,0,0,0,1,0,0,0}, // p 3 signals p 6
				{0,0,0,0,0,1,0,0,0}, // p 4 waits for p 1,2 and signals 6
				{0,0,0,0,0,0,1,0,0}, // p 5 signals p 7
				{0,0,0,0,0,0,1,0,0}, // p 6 waits for p 3,4 and signals 7
				{0,0,0,0,0,0,0,0,1}, // p 7 signals p 9
				{0,0,0,0,0,0,0,0,1}, // p 8 signals p 9
				{0,0,0,0,0,0,0,0,0}, // p 9 waits for p 8,9 and signals none
		};

		//Semaphore
		Semaphore[][] s = new Semaphore[a.length][];

		//Initialize semaphores
		for(int i = 0; i < a.length; i++){
			s[i] = new Semaphore[a[i].length];
			for(int j = 0; j < a[i].length; j++){
				if(a[i][j] != 0){
					s[i][j] = new Semaphore(0);
				}
			}
		}

		LinkedList<Process> pl = new LinkedList<Process>();
		LinkedList<Thread> tl = new LinkedList<Thread>();

		Process p1 = new Process(0, s, "Task 1: Cut Onions." , "Task 1: Finished cutting onions.");
		pl.add(p1);
		Process p2 = new Process(1, s, "Task 2: Mince meat." , "Task 2: Finished mincing meat.");
		pl.add(p2);
		Process p3 = new Process(2, s, "Task 3: Slice aubergines." , "Task 3: Finished slicing aubergines.");
		pl.add(p3);
		Process p4 = new Process(3, s, "Task 4: Make sauce." , "Task 4: Finished making sauce.");
		pl.add(p4);
		Process p5 = new Process(4, s, "Task 5: Make Bechamel." , "Task 5: Finished Bechamel.");
		pl.add(p5);
		Process p6 = new Process(5, s, "Task 6: Layout the layers." , "Task 6: Finished laying out layers.");
		pl.add(p6);
		Process p7 = new Process(6, s, "Task 7: Put Bechamel and cheese." , "Task 7: Finished putting on Bechamel and cheese.");
		pl.add(p7);
		Process p8 = new Process(7, s, "Task 8: Turn on oven." , "Task 8: Finished turning on oven.");
		pl.add(p8);
		Process p9 = new Process(8, s, "Task 9: Cook." , "Task 9: Finished cooking.");
		pl.add(p9);

		for(int i = 0; i < pl.size(); i++){
			tl.add(new Thread(pl.get(i)));
		}

		//Start the simulation
		for(int i = 0; i < tl.size(); i++){
			tl.get(i).start();
		}
	}
}
