package lab06;

import java.util.Iterator;

public class Orchestra {
	
	private int size = 20;
	
	private int curr = 0;
	
	private Instrument[] OrchInstruments = new Instrument[size];
	
	/**
	 * @param ins The instrument to insert.
	 */
	public void add(Instrument ins){
		if(curr < size){					
			OrchInstruments[curr++] = ins;
		}
		else{											
			size += (size*1.5);
			Instrument[] tmp = new Instrument[size];	
			for(int i = 0; i < curr; i++){
				tmp[i] = OrchInstruments[i]; 
			}
			OrchInstruments = tmp;
			OrchInstruments[curr++] = ins;				
		}
	}

	public void playAll(){
		for(int i = 0; i < curr; i++){
			OrchInstruments[i].play();
		}
	}

	
	/**
	 * @param note
	 */
	public void tuneAll(char note){
		for(int i = 0; i < curr; i++){
			OrchInstruments[i].tune(note);
		}
	}
	
	
	/**
	 * @return OrchestraIterator<Instrument>
	 */
	public OrchestraIterator iterator(){
		OrchestraIterator it = new OrchestraIterator();
		return it;
	}
	
	class OrchestraIterator implements Iterator<Instrument>{
		
		int currh = 0;
		
		int sizeh = curr;
		
		
		/**
		 * @return boolean
		 */
		public boolean hasNext() {
			return (currh < curr);
		}

		
		/**
		 * @return Instrument
		 */
		public Instrument next() {
			Instrument p;
			if(curr > 0){
				p = OrchInstruments[currh];
			}
			else{
				return new Tuba("Error: There are no instruments in the array.", 0);
			}
			if(currh < curr){		
				currh++;			
			}
			return p;
		}

		public void remove() {
			Instrument[] temp = new Instrument[sizeh];	
			
			if(curr > 0){
				curr--;										
				int i, k;									
				for(i = 0; i < currh; i++){					 
					temp[i] = OrchInstruments[i];			
				}
			
				i++;										
				k = i;										
				while(i < curr){							
					temp[k] = OrchInstruments[i+1];			
					k++;
					i++;
				}
			}
			OrchInstruments = temp;							
		}
	}
}
