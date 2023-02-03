package com.techelevator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        // Create a new class, initializing the first name
        // and last name through the constructor
        Person christopher = new Person("Christopher", "Guarnera");
        //christopher.introduceSelf();

        BankAccount savings = new BankAccount();
       BankAccount account = new BankAccount("12355890",
                                "0000234", BankAccount.CHECKING);

       account.setBalance(1000);
       account.deposit(500);
       account.deposit(20);

       System.out.println("Our balance is " + account.getBalance());


       String company = "KeyBank";

       //Overloaded: same name, different parameters:
       //in this case, I pass two parameters to substring, a start and end
       String firstThree = company.substring(0, 3);

       //in this case, I pass one parameter to substring, s start
       String lastFour = company.substring(3);


       Deposit deposit = new Deposit(100, LocalDateTime.now(), true);


       int[] checks = {10, 20, 30, 40, 50};
       for(int i = 0; i < checks.length; i++) {
           int currentValue = checks[i];
           System.out.println(currentValue);
       }

       //The foreach loop is doing the same as above:
        // 1. Starting at the beginning of the array
        //2. Iterating one by one through all the contents of the array
        //3. Declaring the local variables indicating what element we
        //   are looking at
       for(int currentValue : checks){
           System.out.println(currentValue);
       }

        Map<String, Integer> pokemonMap = new LinkedHashMap<>();
       pokemonMap.put("christopher",5);
       pokemonMap.put("craig",10);
       pokemonMap.put("zachary", 15);
       pokemonMap.put("ikia", 20);

       //ikia feels bad christopher has so few pokemon so she gives him 2
        int ikiaPokemonAmount = pokemonMap.get("ikia");
        ikiaPokemonAmount -= 2;

        int christopherPokemonAmount = pokemonMap.get("christopher");
        christopherPokemonAmount += 2;

        pokemonMap.put("ikia", ikiaPokemonAmount);
        pokemonMap.put("christopher", christopherPokemonAmount);

       for(Map.Entry<String, Integer> entry : pokemonMap.entrySet()){

           System.out.println("Congrats " + entry.getKey() + "!");
           System.out.println("You collected " + entry.getValue() + " pokemon.");

       }

    }

}
