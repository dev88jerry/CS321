import java.util.Random;

public class Statistics {

    private double avgWaitTime;
    private double avgTransactions;



    static class RandBox extends Random {

        private final double interarrivalTime = 120.0;
        private final double avgTransactionTime = 60.0;

        static double expo(double mean)
        {
            double x = Math.random();
            x = -mean * Math.log(x);
            return x;
        }
    }
}


