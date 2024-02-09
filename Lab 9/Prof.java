import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observer;

public class Prof extends java.util.Observable {
	private String name = null;
	private Integer roomNumber = 0;
	private Date midterm= null;
	private LinkedList<Observer> midtermStudents;

	public Prof(String aName) {
		super();
		String a;
		name = aName;
		midtermStudents = new LinkedList<Observer>();
	}

	public Date getMidterm() {
		return midterm;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param r The room number.
	 */
	public void setRoomNumber(int r) {
		roomNumber = r;
		setChanged();
		notifyObservers(roomNumber);
	}

	public void setMidterm(Date date) {
		midterm = date;
		setChanged();
		notifyObservers( date );
	}

	/**
	 * @param o
	 */
	public void takingTheMidterm(Observer o){
		midtermStudents.add(o);
	}

	public void whoTakesTheMidterm(){
		System.out.println();
		Iterator it = midtermStudents.iterator();
		System.out.println("Students taking the midterm:\n");
		while(it.hasNext()){
			System.out.println("Student: " + ((Student)it.next()).getName());
		}
	}
}
