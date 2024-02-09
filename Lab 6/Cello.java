package lab06;

public class Cello implements Instrument {
	
	private String whatToPlay = "";
	
	/**
	 * @param whatToPlay
	 */
	public Cello(String whatToPlay){
		this.whatToPlay = whatToPlay;
	}

	public void play() {
		System.out.println("CELLO playing: " + whatToPlay);
	}

	/**
	 * @param note
	 */
	public void tune(char note) {
		System.out.println("Tuning to note: " + note);
	}

}
