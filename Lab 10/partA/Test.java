package Lab10A;

public class Test {

	public static void main (String[] args){
		Worker w1 = new Worker("Joe");
		Worker w2 = new Worker("Blo");

		System.out.println("Functional Orientation: ");
		w1.run();
		w2.run();

		ThreadedWorker w3 = new ThreadedWorker("Jojo");
		ThreadedWorker w4 = new ThreadedWorker("Bobo");

		System.out.println("\nInterlaced Orientation: ");
		Thread t1 = new Thread(w3);
		Thread t2 = new Thread(w4);
		(t1).start();
		(t2).start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nTesting array adders...");
		int[] a = {1,2,3,4,5};
		RowAdder r1 = new RowAdder(a);
		Thread r1t = new Thread(r1);
		r1t.start();
		try {
			r1t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sum of 1D: " + r1.sum());
		System.out.println("\nTesting multi-dimensional array adders...");

		int[][] b = {
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5}
		};
		Adder a1 = new Adder(b);
		Thread a1t = new Thread(a1);

		a1t.start();
		try {
			a1t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sum of MD: " + a1.sum());

	}
}
