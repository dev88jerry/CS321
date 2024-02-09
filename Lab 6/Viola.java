package lab06;

/**
 * The class Viola which is an instrument.
 */
	
public class Viola implements Instrument {

	private String whatToPlay = "";
	
	/**
	 * @param whatToPlay
	 */
	public Viola(String whatToPlay){
		this.whatToPlay = whatToPlay;
	}

	public void play() {
		System.out.println("VIOLA playing: " + whatToPlay);
	}
	
	/**
	 * @param note 
	 */
	public void tune(char note) {
		System.out.println("Tuning to note: " + note);
	}

}
