import java.util.PriorityQueue;
import java.util.Queue;

public class Teller {

    private boolean stallOpen;
    public Queue<Client> tellerQueue = new PriorityQueue<>();

    public Teller(){
        this.stallOpen = true;
    }

    public boolean isStallOpen() {
        return stallOpen;
    }

    public void processClient(Client c){
        if(!isStallOpen())
            tellerQueue.add(c);
    }

}
