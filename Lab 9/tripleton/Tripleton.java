package tripleton;

public class Tripleton {
	private static Tripleton t1;

	private static Tripleton t2;

	private static Tripleton t3;

	private Tripleton() { }


	/**
	 * @return
	 */
	public static Tripleton getInstance(){
		if (t1 == null){
			t1 = new Tripleton();
			return t1;
		}
		else if (t2 == null){
			t2 = new Tripleton();
			return t2;
		}
		else if (t3 == null){
			t3 = new Tripleton();
			return t3;
		}
		else{
			System.out.println("Only three instances may exist.");
			return t3;
		}
	}

	/**
	 * @param n
	 * @return Instance
	 */
	public static Tripleton getInstanceN(int n){
		if(n == 1){
			return t1;
		}
		else if(n == 2){
			return t2;
		}
		else if(n == 3){
			return t3;
		}
		else{
			System.out.println("Error: Only three instances (1, 2, 3).");
			return null;
		}
	}

}
