import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Secretary implements Observer{
	private Date tempDate;

	public Secretary(){

	}

	public void registerToProf(Prof p){
		p.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if(arg instanceof Integer){
			return;
		}

		System.out.println("Have been notified of a midterm by professor " + ((Prof)o).getName() + " and the date of the midterm.");
		tempDate = (Date)arg;
		int r = (int)(Math.random()*10)+1;
		((Prof)o).setRoomNumber(r);
	}
}
