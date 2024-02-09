package Lab04B;

import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Faculty f = new Faculty(45, 15);
        Grad g = new Grad(24, 5);
        Lecturer l = new Lecturer(31, 10);

        Instructor[] ins = new Instructor[3];
        ins[0] = f;
        ins[1] = g;
        ins[2] = l;

        for (int i = 0; i < 20; i++) {
            int mail = (i * 10 + 50);

            for (Instructor it : ins) {

                it.getMail(mail);

                if ((i | 1) > i) {
                    double random = Math.random();
                    int number = (int) (random * 10);
                    it.reduceMail(number);
                }

            }
        }

        System.out.println("After 20 days here are the results:");
        for (Instructor it : ins) {
            System.out.println(it.toString());

        }
        
    }
}


/*
New Class
*/

package Lab04B;

public abstract class Instructor {

    private int age;
    private int unreadMail;
    private int eccentricities;

    public Instructor(int age, int mail) {
        this.age = age;
        this.unreadMail = mail;
        this.eccentricities = 0;
    }

    public int getAge() {
        return this.age;
    }

    public int getUnreadMail() {
        return this.unreadMail;
    }

    public int getEccentricities() {
        return this.eccentricities;
    }

    public abstract void cope();

    public int stress() {
        if (this.unreadMail < 1000)
            return this.unreadMail;
        else
            return 1000;
    }

    public int respect() {
        int ret = this.age - this.eccentricities;

        if (ret >= 0)
            return ret;
        else
            return 0;
    }

    public void reduceMail(int readMail) {
        int val = this.unreadMail - readMail;

        if (val < 0)
            this.unreadMail = 0;
        else
            this.unreadMail = val;

    }

    public void addToEccentricities(int newEccentricities) {
        int val = this.eccentricities + newEccentricities;

        if (val < 0)
            this.eccentricities = 0;
        else
            this.eccentricities = val;

    }

    public void getMail(int newMail) {

        this.unreadMail += newMail;


        double random = Math.random();

        if (random < 0.2) {
            int number = (int) (random * 1000);
            if ((number | 1) > number) {
                //even
                this.addToEccentricities(-2);
            } else {
                this.addToEccentricities(2);
            }

        }
    }

    public String toString() {
        return "My age " + this.age + " has respect " + this.respect() + " and " + this.eccentricities + " number of eccentricities and " + this.unreadMail + " number of unread messages.";
    }

}


/*
New Class
*/

package Lab04B;

public class Grad extends Instructor {

    public Grad(int age, int unreadMail) {
        super(age, unreadMail);
    }

    @Override
    public void cope() {
        super.reduceMail(super.getUnreadMail());


        double random = Math.random();
        int number = (int) (random * 1000);
        if (!((number | 1) > number)) {
            //odd
            super.addToEccentricities(3);
        }
    }

    public int stress() {
        if (super.getUnreadMail() < 1500)
            return super.getUnreadMail();
        else
            return 1500;
    }

}


/*
New Class
*/

package Lab04B;

public class Lecturer extends Instructor {

    public Lecturer(int age, int unreadMail) {
        super(age, unreadMail);
    }

    @Override
    public void cope() {
        double tmp = super.getUnreadMail();
        double val = tmp * 0.6;
        int ret = (int) val;

        super.reduceMail(ret);
    }
}


/*
New Class
*/

package Lab04B;

public class Faculty extends Lecturer {

    public Faculty(int age, int unreadMail) {
        super(age, unreadMail);
    }

    @Override
    public void cope() {
        super.addToEccentricities(30);
    }

    public int respect() {
        int ret = super.getAge() + super.getEccentricities();

        if (ret >= 0)
            return ret;
        else
            return 0;
    }

}

