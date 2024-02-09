package lab07B;

public class SquareRoot implements OpClass {

	public SquareRoot(){
	}
	
	public Object op(Object arg) {
		float temp = ((Number)arg).floatValue();
		return (Object)Math.sqrt(temp);
	}
}
