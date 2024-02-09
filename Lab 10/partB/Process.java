package Lab10B;

import java.util.concurrent.Semaphore;

public class Process implements Runnable{
	
	private int id;
	private Semaphore[][] s;
	private String startOut;
	private String endOut;

	/**
	 * Constructor
	 *
	 * @param id
	 * @param s
	 * @param startOut
	 * @param endOut
	 */
	public Process(int id, Semaphore[][] s, String startOut, String endOut){
		this.id = id;
		this.s = s;
		this.startOut = startOut;
		this.endOut = endOut;
	}

	@Override
	public void run() {
		try {
			
			for(int i = 0; i < s.length; i++){
				if(s[i][id] != null){
					(s[i][id]).acquire();
				}
			}

			
			System.out.println(startOut);
			int sec = (int)(Math.random()*9) + 2;
			Thread.sleep(sec*1000);
			System.out.println(endOut);

			
			for(int j = 0; j < s[id].length; j++){
				if(s[id][j] != null){
					(s[id][j]).release();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
