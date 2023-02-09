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
            Collections.shuffle(racers);

            for(Racer racer : racers) {
                System.out.println(racer.toString());
            }

        }

        System.out.println();
        System.out.println(racers.get(0) + " wins!");

    }
}
