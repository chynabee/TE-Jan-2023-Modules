package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {

        //Remember lists, like arrays, can only hold
        //a single data type that we specify. In this
        // case we specify our new data type: Avenger
        List<Avenger> avengers = new ArrayList<>();

        //BlackWidow IS A Avenger, so we can add her to the list
        avengers.add(new BlackWidow());

        //Thor IS A Avenger, so we can add him to the list too
        Thor thor = new Thor();
        avengers.add(thor);

        //Let's show off how Thor reacts differently when we call getPower
        System.out.println("***** BEGINNING OF THOR EXAMPLE *****");
        System.out.println();

        //thor is worthy by default
        String thorPower = thor.getPower();
        System.out.println("Thor's power is: " + thorPower);

        //but now let's say that Thor throws away his plastic cup in a paper recycling bin
        thor.setWorthy(false);

        //now Thor's power is different
        thorPower = thor.getPower();
        System.out.println("Thor's power is now: " + thorPower);

        System.out.println();
        System.out.println("***** END OF THOR EXAMPLE *****");


        //Adding Incredible Hulk and SheHulk
        avengers.add(new IncredibleHulk());
        avengers.add(new SheHulk());

        //Adding IronMan
        avengers.add(new IronMan());

        System.out.println();
        System.out.println("***** BEGINNING OF AVENGERS EXAMPLE *****");
        System.out.println();


        //Avengers, Assemble!

        //we will do a foreach loop to iterate through
        //every Avenger
        for(Avenger avenger : avengers) {

            //Declare the name and power of each avenger
            System.out.println(); //just adding a line in the console to separate each output
            System.out.println("I am " + avenger.getName());
            System.out.println("And my power is " + avenger.getPower());

            //check if we are looking at Thor specifically
            if(avenger instanceof Thor) {
                //if we confirm that this avenger is also
                //data type Thor, then we can cast our
                //avenger variable to a Thor specific variable
                //and call setWorthy()
                Thor worthyThor = (Thor) avenger;
                worthyThor.setWorthy(true);
                System.out.println("Wait, now I'm worthy!");
            }

            //let's check if we are looking at a Hulk, if so, smash()
            //Note: this will be true for both IncredibleHulk and SheHulk
            if(avenger instanceof Hulk) {
                Hulk hulk = (Hulk) avenger;
                hulk.smash();
            }

            //Finally let's check for our interface type - Flyable. If they are Flyable,
            // then we know they can fly()
            if(avenger instanceof Flyable) {
                Flyable flyer = (Flyable) avenger;
                flyer.fly();
            }

        }

        System.out.println();
        System.out.println("***** END OF AVENGERS EXAMPLE *****");

    }


}
