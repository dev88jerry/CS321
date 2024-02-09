package Lab04B;

public class Grad extends Instructor {
	
	/**
	 * @param age			
	 * @param unreadMail	
	 */
	public Grad(int age, int unreadMail) {
		super(age, unreadMail);
	}
	
	public int stress(){
		double temp = getUnreadMail() * (1.5);
		if (temp < 1500){
			return (int)(temp);
		}
		else{
			return 1500;
		}
	}

	void cope() {
		System.out.println("Grad is coping...\n");
		reduceMail(getUnreadMail());				
		if(Math.random() < 0.5){					
			addToEccentric(3);
		}
		else{
			addToEccentric(-3);
		}
	}
}
