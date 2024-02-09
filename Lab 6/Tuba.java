package lab06;

/**
 * The class Tuba which is an instrument.
 */

public class Tuba implements Instrument {
	
	private String whatToPlay = "";
	
	private int measures = 0;

	/**
	 * @param whatToPlay 
	 * @param measures 
	 */
	public Tuba(String whatToPlay, int measures){
		this.whatToPlay = whatToPlay;
		this.measures = measures;
	}

	public void oompapa(){
		for(int i = 0; i <  measures; i++){
			System.out.println("Oom Pa Pa \n");
		}
	}

	public void play() {
		System.out.println("TUBA playing: " + whatToPlay);
		oompapa();
	}

	/**
	 * @param note
	 */
	public void tune(char note) {
		System.out.println("Tuning to note: " + note);
	}
}
