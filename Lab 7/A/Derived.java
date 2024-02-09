package lab07A;

public class Derived extends Base implements IType {

	public Derived(){
		System.out.println("Calling Derived constructor.");
	}

	public String m1() {
		return "Derived.m1()";
	}

	public String m3() {
		return "Derived.m3()";
	}
}
