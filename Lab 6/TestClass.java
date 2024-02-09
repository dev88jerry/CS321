package lab06;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        final int NO_INSTRUMENTS = 5;
        final int STRESS_ADD_INSTRUMENTS = 4;

        System.out.println("Testing parts 1 and 2 with a simple array of Instrument\n");

        Instrument[] orchestralArray = new Instrument[NO_INSTRUMENTS];

        for (int k = 0; k < orchestralArray.length; k++)
            if ((k % 2) == 0)
                orchestralArray[k] = new Cello("Bach: suites for solo Violoncello");
            else
                orchestralArray[k] = new Viola("Andrew Macdonald: The Great Square of Pegasus:");

        for (Instrument x : orchestralArray)
            x.tune('C');

        for (Instrument x : orchestralArray)
            x.play();
		
		/*Check if output is the following: 
			
		Cello: tuning to:C
		VIOLA: tuning to C
		Cello: tuning to:C
		VIOLA: tuning to C
		Cello: tuning to:C
		Cello: playing : Bach: suites for solo Violoncello
		VIOLA: playing : Andrew Macdonald: The Great Square of Pegasus:
		Cello: playing : Bach: suites for solo Violoncello
		VIOLA: playing : Andrew Macdonald: The Great Square of Pegasus:
		Cello: playing : Bach: suites for solo Violoncello
		
		*/

        System.out.println("\nTesting part 3: class Orchestra\n");

        Orchestra OSS = new Orchestra();

        for (int k = 0; k < NO_INSTRUMENTS; k++)
            OSS.add(new Cello("Bach: Symphony no " + k));


        System.out.println("\n      A.   Testing the Orchestra Iterator \n");

        Iterator<Instrument> it = OSS.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\n      B.   Testing the class Orchestra Iterator with array expansion \n");
        System.out.println("             Adding new instruments ");

        for (int k = 0; k < NO_INSTRUMENTS; k++)
            OSS.add(((k % 2) == 0) ? new Cello("Bach: Suite no" + k) : new Viola("sonata no " + k));

        try {
            it = OSS.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception ex) {
            System.out.println("\n            ACCESS through Iterator failed");
        }


        System.out.println("\n      B.   STRESS-TESTING the class Orchestra with array expansion \n");
        System.out.println("             Adding STRESS_ADD_INSTRUMENTS new instruments ");

        try {

            for (int k = 0; k < STRESS_ADD_INSTRUMENTS; k++)
                OSS.add(((k % 2) == 0) ? new Cello("Bach: Suite no" + k) : new Viola("sonata no " + k));

        } catch (Exception ex) {
            System.out.println("\n Stress testing adding new Instruments failed " + ex);
        }


        System.out.println("\n      C.   Testing the tune() method of Orchestra \n");

        try {

            OSS.tuneAll('D');

        } catch (Exception ex) {
            System.out.println("\n       ******** TuneAll() test failed\n" + ex);
        }


        System.out.println("\n      D.   Testing the playAll() method of Orchestra \n");

        try {

            OSS.playAll();

        } catch (Exception ex) {
            System.out.println("\n    ****** playAll() test failed\n" + ex);
        }


        System.out.println("\n      E.   Testing: add() with new ANONYMOUS TYPE of instrument ");
        System.out.println("\n           adding Trumpets as anonymous classes \n");

        for (int i = 0; i < 2; i++) {

            OSS.add(new Instrument() {
                String s = " LIGETI: concert no 4";

                public void play() {

                    System.out.println("Trumpet playing: " + s);
                }

                public void tune(char note) {

                    System.out.println("      *** TRUMPET is tuning in " + note);
                }
            });

        }

        OSS.playAll();

        System.out.println("\nTesting part 4: **************class GenOrchestra");

        GenOrchestra genOSS = new GenOrchestra(new ArrayList<Instrument>());

        Iterator<Instrument> instIt = OSS.iterator();

        while (instIt.hasNext())
            genOSS.add(instIt.next());

        genOSS.playAll();

        System.out.println("\n Test: changing container object ");

        try {

            genOSS.changeContainer(new java.util.LinkedList<Instrument>());
            genOSS.playAll();

        } catch (Exception ex) {
            System.out.println(" Test: changing container object failed with: " + ex);
        }


        System.out.println("\n Test: adding a Tuba to genOSS and re-calling playAll()");

        try {

            genOSS.add(new Tuba("Strauss: fanfare ", 3));

            genOSS.playAll();
        } catch (Exception ex) {
            System.out.println(" Test of adding Tuba failed with: " + ex);
        }

    }
}
