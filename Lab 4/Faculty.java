package Lab04B;

public class Faculty extends Instructor {
	
	/**
	 * @param age		 
	 * @param unreadMail
	 */
	public Faculty(int age, int unreadMail){
		super(age, unreadMail);
	}
	
	public void cope(){
		System.out.println("Faculty is coping...\n");
		addToEccentric(30);
	}
	
	public int respect(){
		return (getAge() + getEccentric());
	}
}
