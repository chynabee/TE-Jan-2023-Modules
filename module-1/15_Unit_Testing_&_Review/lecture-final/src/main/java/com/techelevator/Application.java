package com.techelevator;

import com.techelevator.loans.Loan;
import com.techelevator.loans.PersonalLoan;
import com.techelevator.loans.SubLoan;
import com.techelevator.mariokart.LargeCart;
import com.techelevator.mariokart.MediumCart;
import com.techelevator.mariokart.Racer;
import com.techelevator.mariokart.SmallCart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application  {

    public static void main(String[] args) {

        //PersonalLoan personal = new PersonalLoan();

        List<Racer> racers = new ArrayList<>();

        MediumCart mario = new MediumCart("Mario");

        if(mario.getName().equals("Mario")) {
            System.out.println("Our code is working as expected!");
        }



        MediumCart luigi = new MediumCart("Luigi");

        SmallCart toad = new SmallCart("Toad");
        MediumCart princessPeach = new MediumCart("Princess Peach");

        LargeCart bowser = new LargeCart("Bowser");
        LargeCart wario = new LargeCart("Wario");


        racers.add(mario);
        racers.add(luigi);
        racers.add(princessPeach);
        racers.add(toad);
        racers.add(bowser);
        racers.add(wario);

        System.out.println(mario.toString());


        for(int i=0; i < 3; i++) {

            System.out.println();
            System.out.println("Lap " + (i+1) + ":");
            Collections.sort(racers);

            for(int j=0; j < racers.size(); j++) {
                Racer currentRacer = racers.get(j);

                if(currentRacer instanceof LargeCart) {

                    LargeCart largeCart = (LargeCart) currentRacer;
                    if (j > 0) { //make sure we're not at the very beginning
                        largeCart.bump(racers.get(j-1)); // bump the person behind us

                        // shortcut for System.out.println is to type sout and hit enter
                        System.out.println(largeCart.getName() + " bumped " + racers.get(j-1).getName());

                    }
                    if(j < racers.size()-2) {
                        largeCart.bump(racers.get(j+1)); // bump the person in front of us
                        System.out.println(largeCart.getName() + " bumped " + racers.get(j+1).getName());
                    }
                }

                System.out.println(currentRacer.toString());
            }

        }

        System.out.println();
        System.out.println(racers.get(0) + " wins!");

    }
}
