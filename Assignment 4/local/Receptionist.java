import java.util.PriorityQueue;
import java.util.Queue;

public class Receptionist {

    private boolean deskOpen;

    public Queue<Client> receptionQueue = new PriorityQueue<>();

    public Receptionist(){
        this.deskOpen = true;
    }

    public boolean isDeskOpen() {
        return deskOpen;
    }

    public void processClient(Client c){

        if(!isDeskOpen())
            receptionQueue.add(c);

        if(receptionQueue.isEmpty())
            c.getTime();
        else
            receptionQueue.poll();
    }
}
