package assign5;

public class Simulation {
	
	public static void main(String[] args){

		Bridge b = new Bridge(10);

		BishBound bB = new BishBound(b);
		BishBound bB2 = new BishBound(b);
		BishBound bB3 = new BishBound(b);
		LionBound lB = new LionBound(b);
		LionBound lB2 = new LionBound(b);

		Thread tb = new Thread(bB);
		Thread tl = new Thread(lB);
		Thread tl2 = new Thread(lB2);
		Thread tb2 = new Thread(bB2);
		Thread tb3 = new Thread(bB3);

		tb.start();
		tl.start();
		tl2.start();
		tb2.start();
		tb3.start();

	}
}
