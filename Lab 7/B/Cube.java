package lab07B;

public class Cube implements OpClass {

	public Cube(){
	}

	public Object op(Object arg) {
		float temp = ((Number)arg).floatValue();
		return (Object)Math.pow(temp, 3);
	}
}
