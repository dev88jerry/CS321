package Lab10A;

public class RowAdder implements Runnable{

	private int[] a;
	private int sum;

	public RowAdder(int[] a){
		this.a = a;
	}

	public int sum(){
		return this.sum;
	}

	@Override
	public void run() {
		for(int i = 0; i < a.length; i++){
			sum += a[i];
		}
	}
}
