package com.techelevator;

import com.techelevator.dao.JdbcSightingDao;
import com.techelevator.dao.SightingDao;
import com.techelevator.models.Sighting;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainCLI {

    private final Scanner userInput = new Scanner(System.in);
    private SightingDao sightingDao;


    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        MainCLI application = new MainCLI(dataSource);
        application.run();
    }

    public MainCLI(DataSource dataSource) {
        sightingDao = new JdbcSightingDao(dataSource);
    }

    private void run() {

        while (true) {

            System.out.println("What would you like to do?");
            System.out.println("1) Report a sighting");
            System.out.println("2) Lookup sightings");
            System.out.println("3) Exit");

            String response = userInput.nextLine();
            if (response.equals("1")) {
                //report the sighting

                System.out.println("Near what city did this occur?");
                String city = userInput.nextLine();

                System.out.println("Please enter the state abbreviation where this occurred:");
                String state = userInput.nextLine();

                System.out.println("Please describe what happened:");
                String description = userInput.nextLine();

                Sighting sighting = new Sighting();
                sighting.setCity(city);
                sighting.setStateAbbreviation(state);
                sighting.setSightingDateTime(LocalDateTime.now());
                sighting.setDescription(description);


            } else if (response.equals("2")) {
                //list all the sightings



            } else if (response.equals("3")) {
                break;
            } else {
                System.out.println("Invalid selection, try again");
            }
        }


    }


}
