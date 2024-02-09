package Lab;

public class Main {
	public static void main (String[]  args){
		///Create and initialize an array of 5 points
		MyPoint[] points =  new MyPoint[5];
		for(int i = 0; i < 5; i++){
			points[i] = new MyPoint();
		}
		
		///Test the contains function
		MyPoint p = new MyPoint();
		if(MyPoint.contains(points, p)){
			System.out.println("Test successful.");
		}
		else{
			System.out.println("Test unsuccessful.");
		}
		
		p.setY(5);
		if(MyPoint.contains(points, p)){
			System.out.println("Test unsuccessful.");
		}
		else{
			System.out.println("Test successful.");
		}

		///Test the horizontal function
		if(MyPoint.horizontal(points)){
			System.out.println("Test successful.");
		}
		else{
			System.out.println("Test unsuccessful.");
		}
		
		points[0].setX(9);
		if(MyPoint.horizontal(points)){
			System.out.println("Test unsuccessful.");
		}
		else{
			System.out.println("Test successful.");
		}
		
		for(int i = 0; i < points.length; i++){
			points[i].setXY(3,4);
		}
		
		///Test the first distance function
		MyPoint p2 = new MyPoint(10,10);
		String holder = "";
		System.out.println("\nDistance test (function that uses points):");
		double[] distances = new double[5];
		for(int i = 0; i < points.length; i++){
			points[i].setXY(3,4);
			if(i+1 == points.length){
				points[i].setXY(10,10);
			}
			distances[i] = points[i].distance(p2);
			holder = points[i].toString();
			System.out.println("Array: " + holder);
			System.out.println("Distance:" + distances[i]);
		}
		
		///Test the second distance function
		System.out.println("\nDistance test 2 (function that uses variables and not a point):");
		double test = points[1].distance(0, 0);
		holder = points[1].toString();
		System.out.println("Array: " + holder);
		System.out.println("Distance:" + test);
	}
}
