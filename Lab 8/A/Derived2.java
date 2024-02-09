package lab07A;

public class Derived2 extends Derived {

	public Derived2(){
		System.out.println("Calling Derived2 constructor.");
	}

	public String m2(String s){
		if(s != null)
			return s + " from Derived2.m2()";
		return "Argument is null.";
	}

	public String m4(){
		return "Derived2.m4()";
	}
}
