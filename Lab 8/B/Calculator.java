package lab07B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Calculator {
	
	/**
	 * @param numbers
	 * @param operation
	 * @return
	 */
	public static ArrayList apply(ArrayList<Number> numbers, OpClass operation){
		Iterator it = numbers.iterator();
		ArrayList<Object> temp = new ArrayList<Object>();
		while(it.hasNext()){
			temp.add(operation.op(it.next()));
		}
		return temp;
	}
	
	
	public static void main (String[] args){
		ArrayList<Number> test = new ArrayList<Number>();
		ArrayList<Number> result = new ArrayList<Number>();
		Random rnd = new Random();
		
		for(int i = 0; i < 10; i++){
			test.add(rnd.nextInt(10));			
		}
		

		test.add(10);
		SquareRoot sqRoot = new SquareRoot();
		Cube cube = new Cube();
		Square sq = new Square();
		result = apply(test, sq);
		System.out.println(result.toString());
		
		result = apply(test, sqRoot);
		System.out.println(result.toString());
		
		result = apply(test, cube);
		System.out.println(result.toString());
	}
}
