package lab07B;

public class Square implements OpClass {

	public Square(){
	}
	
	public Object op(Object arg) {
		float temp = ((Number)arg).floatValue();
		return (Object)(temp*temp);
	}
	
}
