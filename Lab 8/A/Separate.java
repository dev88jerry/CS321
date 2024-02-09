package lab07A;

public class Separate implements IType {
	
	public Separate(){
		System.out.println("Calling Seperate constructor.");
	}
	
	public String m1(){
		return "Seperate.m1()";
	}
	
	public String m2(String s) {
		if(s != null)
			return s + " from Seperate.m2()";
		return null;
	}

	public String m3() {
		return "Seperate.m3()";
	}
}
