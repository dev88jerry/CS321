package Lab04B;

public class Lecturer extends Instructor {
	
	/**
	 * @param age		 The age
	 * @param unreadMail The amount of mail
	 */
	public Lecturer(int age, int unreadMail) {
		super(age, unreadMail);
	}
	
	/**
	 * The lecturer cope's by "accidently" deleting 60% of their mail.
	 */
	void cope() {
		System.out.println("Lecturer is coping...\n");
		int totalMailToDelete = (int)((0.6) * getUnreadMail());
		reduceMail(totalMailToDelete);
	}
}
