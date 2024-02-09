import java.util.Date;

public class University{

	public static void main(String[] args) throws Exception {
		
		Prof p = new Prof("Mierzwinski");

		Course c = new Course("CS321", p);

		Student s1 = new Student("Kramer");
		Student s2 = new Student("Elaine");
		Student s3 = new Student("Jerry");
		Student s4 = new Student("George");

		Secretary s5 = new Secretary();
		s5.registerToProf(p);

		s1.registerCourse(c);
		s2.registerCourse(c);
		s3.registerCourse(c);
		s4.registerCourse(c);

		p.setMidterm(new Date());
		p.whoTakesTheMidterm();
	}
}
