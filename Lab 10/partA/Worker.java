package Lab10A;

public class Worker {
	private String name;

	public Worker(){
		name = "";
	}

	public Worker(String name){
		this.name = name;
	}

	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println(name + " " + (i+1));
			int s = (int)(Math.random() * 1000) + 1;
            try {
				Thread.sleep(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
