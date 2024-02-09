package lab07A;

public class Base {
	private static int numTimes = 0;
	
	public Base(){
		System.out.println("Calling Base constructor.");
	}
	
	public String m1(){
		numTimes++;
		return String.valueOf(numTimes);
	}

	public String m2(String s){
		if(s != null)
			return s + " from Base.m2()";
		return "Argument is null";
	}
}
