public class BankSim {
    private final double interarrivalTime;
    private final double avgTimePerTransaction;

    public BankSim(double interarrivalTime, double avgTime){
        this.interarrivalTime = interarrivalTime;
        this.avgTimePerTransaction = avgTime;
    }

    public void run(int simulationTime){
        int time = 0;
        while(time < simulationTime){




            time++;
        }

    }

    public double getInterarrivalTime() {
        return interarrivalTime;
    }

    public double getAvgTimePerTransaction() {
        return avgTimePerTransaction;
    }
}
