package Lab10A;

import java.util.LinkedList;

public class Adder implements Runnable{

	private int sum;
	private int[][] a;

	/**
	 * @param a
	 */
	public Adder(int[][] a){
		this.a = a;
	}

	/**
	 * @return
	 */
	public int sum(){
		return this.sum;
	}

	@Override
	public void run() {
		
		LinkedList<Thread> tl = new LinkedList<Thread>();
		LinkedList<RowAdder> ra = new LinkedList<RowAdder>();

		for(int i = 0; i < a.length; i++){
			RowAdder r = new RowAdder(a[i]);
			ra.add(r);
		}

		for(int i = 0; i < ra.size(); i++){
			Thread t = new Thread(ra.get(i));
			tl.add(t);
		}

		for(int i = 0; i < tl.size(); i++){
			tl.get(i).start();
		}

		for(int i = 0; i < tl.size(); i++){
			try {
				tl.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(int i = 0; i < ra.size(); i++){
			this.sum += ra.get(i).sum();
		}
	}
}
