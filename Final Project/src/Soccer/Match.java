/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Match class that starts the chain of responsibility and multithreading handling
 */

package Soccer;

import java.util.concurrent.Semaphore;

/**
 * Gets teams to play each other and handles the multithreading
 */
public class Match implements Runnable{

    private Team t1;
    private Team t2;
    private Semaphore team1sem;
    private Semaphore team2sem;

    public Match(){
        this.team1sem = new Semaphore(1);
        this.team2sem = new Semaphore(1);
    }


    /**
     * Method to start the chain of responsibility
     * Checks to ensure that the 2 teams that are requesting to play a match are not the same team
     */
    public void completeMatch(){
        if(this.t1 == this.t2){
            System.out.println("The same team can't play itself");
        }
        else if(this.t1 == null || this.t2 == null){
            System.out.println("Teams musts be initialized");
        }
        else{
            StartingXI start = new StartingXI();
            start.startingXI(t1);
            start.startingXI(t2);
            GameFlowLogic gfl = new GameFlowLogic();
            GameFlowWinner gfw = new GameFlowWinner();
            gfl.setNextStep(gfw);
            gfl.completeTask(new Game(t1, t2));
        }
    }

    public Team getTeam1() {
        return t1;
    }

    public void setTeam1(Team t1) {
        this.t1 = t1;
    }

    public Team getTeam2() {
        return t2;
    }

    public void setTeam2(Team t2) {
        this.t2 = t2;
    }

    public synchronized void setTeam1sem(Semaphore sem){
        this.team1sem = sem;
    }

    public Semaphore getTeam1sem() {
        return team1sem;
    }

    public synchronized void setTeam2sem(Semaphore sem){
        this.team2sem = sem;
    }

    public Semaphore getTeam2sem(){
        return team2sem;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            this.team1sem.acquire();
            this.team2sem.acquire();
            this.completeMatch();
            this.team2sem.release();
            this.team1sem.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
