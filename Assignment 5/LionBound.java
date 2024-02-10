package assign5;

public class LionBound extends Car implements Runnable {

	private Bridge bridge;

	/**
	 * Constructor.
	 * @param b
	 */
	public LionBound(Bridge b){
		this.bridge= b;
	}

	@Override
	public String toString(){
		return "Lion's Bound";
	}

	@Override
	public void run() {
		while(true){
			try{
				long s = ((int)Math.random()*10)+1;
				Thread.sleep(s);

				if(bridge.getTypeOnBridge() == null){
					bridge.getlBoundOnBridge().acquire();
				}
				else if(bridge.getTypeOnBridge() instanceof BishBound){
					bridge.getlBoundOnBridge().acquire();
				}

				bridge.getOntoBridge(this);

				s = ((int)Math.random()*1)+1;
				bridge.outputBridge();
				Thread.sleep(s);

				bridge.getOffBridge(this);


				if(bridge.isEmpty()){
					bridge.getbBoundOnBridge().release();
				}
			}
			catch(InterruptedException e){

			}
		}
	}
}
