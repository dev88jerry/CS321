package assign5;

public class BishBound extends Car implements Runnable{

	private Bridge bridge;

	/**
	 * Constructor.
	 * @param b
	 */
	public BishBound(Bridge b){
		this.bridge = b;
	}

	@Override
	public String toString(){
		return "Bishop's Bound";
	}

	@Override
	public void run() {
		while(true){
			try{

				long s = ((int)Math.random()*1000)+1;
				Thread.sleep(s);

				if(bridge.getTypeOnBridge() == null){
					bridge.getbBoundOnBridge().acquire();
				}
				else if(bridge.getTypeOnBridge() instanceof LionBound){
					bridge.getbBoundOnBridge().acquire();
				}

				bridge.getOntoBridge(this);

				s = ((int)Math.random()*40)+1;
				bridge.outputBridge();
				Thread.sleep(s);

				bridge.getOffBridge(this);

				if(bridge.isEmpty()){
					bridge.getlBoundOnBridge().release();
				}
			}
			catch(InterruptedException e){

			}
		}
	}
}
