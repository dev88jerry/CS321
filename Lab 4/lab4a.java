package Lab04A;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person p = new Person("abc", 1);
        Person p1 = new Person("abcd", 102);
        Person p2 = new Person("xyz", 128);
        Person p3 = new Person("wxyz", 20);
        Person p4 = new Person("qwerty", 88);

        List<Person> people = Arrays.asList(p, p1, p2, p3, p4);

        System.out.println("Initial list of people");
        for (Person myP : people) {
            System.out.println(myP.toString());
        }
        System.out.println("");

        Collections.sort(people, new LexicographicComparator());

        System.out.println("After sorting by name");
        System.out.println("");
        for (Person myP : people) {
            System.out.println(myP.toString());
        }
        System.out.println("");

        Collections.sort(people, new AgeComparator());

        System.out.println("After sorting by age");
        System.out.println("");
        for (Person myP : people) {
            System.out.println(myP.toString());
        }
    }
}


/*
New class
*/

package Lab04A;

public class Person {

    private String name;
    private int age;


    public Person() {
        this.name = "";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.name + " is age " + this.age;
    }

}


/*
New class
*/

package Lab04A;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}


/*
New class
*/

package Lab04A;

import java.util.Comparator;

public class LexicographicComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
