import java.util.PriorityQueue;
import java.util.Queue;

public class Event implements Comparable{

    protected int timeNow;
    public Queue<Event> eventQueue = new PriorityQueue<>();

    public Event(int prior){

    }

    public void process(Object o) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
