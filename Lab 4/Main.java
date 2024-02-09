package Lab04B;

public class Main {
	public static void main (String[] args){
		//Run a quick test
		Instructor[] instructors = {new Faculty(34,10),
								    new Lecturer(27,4),
								    new Grad(23, 2)};
		int days = 1;
		int mail = 0;
		//For 10 days, get mail...
		while (days <= 10){
			mail = (days * 10) + 50;
			for(int i = 0; i < instructors.length; i++){
				instructors[i].getMail(mail);
			}
			days++;
		}
	}
}
