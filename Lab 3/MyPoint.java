package Lab;

public class MyPoint {
	private int x;
	private int y;

	public MyPoint(){
		this(0, 0);
	}
	
	public MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return "[" + x + " :" + y + " ]";
	}

	public double distance(int x, int y){
		double interm = this.x - x;
		double interm2 = this.y - y;
		return Math.sqrt(Math.pow(interm, 2) + Math.pow(interm2, 2));
	}
	
	public double distance(MyPoint another){
		double interm = this.x - another.x;
		double interm2 = this.y - another.y;
		return Math.sqrt(Math.pow(interm, 2) + Math.pow(interm2, 2));
	}
	
	public static boolean contains(MyPoint[] arr, MyPoint p){
		for(int i = 0; i < arr.length; i++){
			if(arr[i].x == p.x && arr[i].y == p.y){
				return true;
			}
		}
		return false;
	}
	
	public static boolean horizontal(MyPoint[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[0].x != arr[i].x){
				return false;
			}
		}
		return true;
	}
}
