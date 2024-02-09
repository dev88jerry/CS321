import java.util.Random;

public class Client {

    private int time;
    private int transactions;

    public Client(int time){
        this.time = time;
        Random rn = new Random();
        this.transactions = rn.nextInt(100)+1;
    }

    public int getTime() {
        return time;
    }

    public int getTransactions() {
        return transactions;
    }

    public void setTransactions(int transactions) {
        this.transactions = transactions;
    }
}
