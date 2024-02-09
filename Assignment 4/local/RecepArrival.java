public class RecepArrival extends Event {

    public RecepArrival(int prior) {
        super(prior);
    }

    @Override
    public void process(Object o) {
        Client c = new Client(super.timeNow);
        Receptionist recep = (Receptionist) o;
        recep.processClient(c);
    }

    @Override
    public int compareTo(Object o) {
        int ret;
        RecepArrival ra = (RecepArrival) o;



        return 0;
    }
}
