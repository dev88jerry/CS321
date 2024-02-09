package lab07A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Lab07A {
	/**
	 * Function that helps in testing the classes Base, Derived2, and Derived.
	 */
	public static void tryIt(){
		ArrayList<Base> tester = new ArrayList<Base>(); 
		Random rnd = new Random();
		
		System.out.println("\nCreating temporary class...");
		Derived2 tempClass = new Derived2();
		System.out.println();
		
		int temp = 0;
		for(int i = 0; i < 10; i++){
			temp = rnd.nextInt(3);
			if (temp == 0){
				tester.add(new Base());
			}
			else if (temp == 1){
				tester.add(new Derived());
			}
			else {
				tester.add(new Derived2());
			}
		}
		
		Iterator it = tester.iterator();
		while(it.hasNext()){
			if(((Base)it.next()).getClass() == tempClass.getClass()){
				System.out.println(tempClass.m4());
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("\nCalling constructor for Base:");
		Base test1 = new Base();
		System.out.println("\nCalling constructor for Derived:");
		Derived test2 = new Derived();
		System.out.println("\nCalling constructor for Separate:");
		Separate test3 =  new Separate();
		System.out.println("\nCalling constructor for Derived2:");
		Derived2 test4 = new Derived2();
		System.out.println("");
		
		//Base test
		System.out.println(test1.m1());
		System.out.println(test1.m1());
		System.out.println(test1.m2("Hello"));
		
		//Derived test
		System.out.println(test2.m1());
		System.out.println(test2.m3());
		
		//Seperate test
		System.out.println(test3.m1());
		System.out.println(test3.m2("Hello"));
		System.out.println(test3.m3());
		
		//Derived2 test
		System.out.println(test4.m2("Hello"));
		System.out.println(test4.m1());
		
		System.out.println("Testing tryIt():");
		tryIt();
	}
}
