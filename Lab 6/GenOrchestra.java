package lab06;

import java.util.Collection;
import java.util.Iterator;

public class GenOrchestra {
	
	private Collection<Instrument> OrchInstruments;

	private Iterator<Instrument> it;
	
	/**
	 * @param newType
	 */
	public GenOrchestra(Collection<Instrument> newType){
		OrchInstruments = newType;
		System.out.println("Complete!!!");
	}
	
	/**
	 * @param newType The Collection type.
	 */
	public void changeContainer(Collection<Instrument> newType){
		it = OrchInstruments.iterator();
		while(it.hasNext()){
			newType.add(it.next());
		}
		OrchInstruments =  newType;
	}
	
	
	/**
	 * @param ins
	 */
	public void add(Instrument ins){
		OrchInstruments.add(ins);
	}

	public void playAll(){
		it = OrchInstruments.iterator();
		while(it.hasNext()){
			Instrument ins = it.next();
			ins.play();
		}
	}

	
	/**
	 * @param note
	 */
	public void tuneAll(char note){
		it = OrchInstruments.iterator();
		while(it.hasNext()){
			((Instrument)(it.next())).tune(note);
		}
	}
	
	/**
	 * @return iterator
	 */
	public Iterator<Instrument> iterator(){
		return it;
	}
}
