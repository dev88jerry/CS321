package tripleton;

public class Test {

	public static void main(String[] args){

		System.out.println("Testing Tripleton...");
		Tripleton t1 = Tripleton.getInstance();
		Tripleton t2 = Tripleton.getInstance();
		Tripleton t3 = Tripleton.getInstance();

		System.out.println("Creating a fourth instance...should be an error...");
		Tripleton t4 = Tripleton.getInstance();
		if(t4 == t3){
			System.out.println("Test passed.");
		}
	}
}
