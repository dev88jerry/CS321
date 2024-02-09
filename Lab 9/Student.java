
public class Student implements java.util.Observer {
	String name = null;
	Course course = null;
	Integer roomNumber = 0;

	public Student(String aName) {
		super();
		name = aName;
	}

	public String getName() {
		return name;
	}

	void registerCourse(Course aCourse) {
		course = aCourse;
		course.getProf().addObserver(this);
	}
	
	/**
	 * @param   o
	 * @param   arg
	 */
	@Override
	public void update(java.util.Observable o, Object arg) {
		if(arg instanceof Integer){
			roomNumber = (Integer)arg;
			System.out.println("Student " + name + " has a midterm in room number: " + roomNumber);
			return;
		}
		System.out.println("Student " + name + " says  ..Doh got it dude!");
		System.out.println( ((Prof)o).getName() + " says " + arg);
		((Prof)o).takingTheMidterm(this);
	}
}
