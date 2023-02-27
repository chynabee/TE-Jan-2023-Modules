package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Tutorial {
	
    public static void main(String[] args) {

        // Step One: Declare a List

        List<String> groceries = new ArrayList<>();


        // Step Two: Add values to a List
        groceries.add("milk");
        groceries.add("cheese");
        groceries.add("meat");
        groceries.add("juice");
        groceries.add("water");


        // Step Three: Looping through a List in a for loop

        for (int i = 0; i < groceries.size(); i++) {
            System.out.println(groceries.get(i));
        }
    }

    	
    	// Step Four: Remove an item

        groceries




    	
    	// Step Five: Looping through List in a for-each loop

        for(String groceries : groceries) {
            System.out.println(groceries);
        }

    }


