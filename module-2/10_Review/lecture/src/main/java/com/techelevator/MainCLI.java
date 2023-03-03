package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

public class MainCLI {

    private final Scanner userInput = new Scanner(System.in);


    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        MainCLI application = new MainCLI(dataSource);
        application.run();
    }

    public MainCLI(DataSource dataSource) {

    }

    private void run() {
    }

}
