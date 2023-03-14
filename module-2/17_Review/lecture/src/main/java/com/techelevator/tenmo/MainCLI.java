package com.techelevator.tenmo;

import com.techelevator.tenmo.dao.JdbcSightingDao;
import com.techelevator.tenmo.dao.SightingDao;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.model.Sighting;
import org.apache.commons.dbcp2.BasicDataSource;

public class MainCLI {

    private final Scanner userInput = new Scanner(System.in);

    //I declare a sightingDao as a private variable for this class, note that
    // I use the interface type instead of the specific implementation type
    // in case we want to change implementations later
    private final SightingDao sightingDao;

    public static void main(String[] args) {

        // Here is where we specify the details for where the database
        // can be found, and also the credentials needed for access
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Unexplained");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        MainCLI application = new MainCLI(dataSource);
        application.run();
    }

    public MainCLI(DataSource dataSource) {
        sightingDao = new JdbcSightingDao(dataSource);


    }

    private void run() {

        while(true){

            System.out.println("What would you like to do?");
            System.out.println("1) Report a sighting");
            System.out.println("2) Lookup sightings");
            System.out.println("3) Exit");

            String response = userInput.nextLine();
            if(response.equals("1")) {
                //report the sighting
                //date, city, state, description

                System.out.println("Near what city did this occur?");
                String city = userInput.nextLine();

                System.out.println("Please enter the state abbreviation where this occurred");
                String state = userInput.nextLine();

                System.out.println("Please describe what happened");
                String description = userInput.nextLine();

                //Now that I have these fields from the witness I can
                //create my sighting
                Sighting sighting = new Sighting();
                sighting.setCity(city);
                sighting.setStateAbbreviation(state);
                sighting.setDescription(description);
                sighting.setSightingDateTime(LocalDateTime.now());

                sightingDao.createSighting(sighting);

            }
            else if(response.equals("2")){
                //list all the sightings
                System.out.println("Please enter the state you want to search for sightings in:");
                String state = userInput.nextLine();

                List<Sighting> sightings = sightingDao.getSightingsByState(state);
                for(Sighting sighting : sightings) {
                    System.out.println(sighting.getCity() + ", "
                            + sighting.getStateAbbreviation() + ": " + sighting.getDescription());
                }

            }
            else if(response.equals("3")){
                break;
            }
            else {
                System.out.println("Invalid selection, try again");
            }
        }

    }

}
