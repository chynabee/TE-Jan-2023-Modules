package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Replacer {

    public static void main(String[] args) {

        //Given a file with a new number on each line
        //I dont like the number 1
        //so I want to replace the number 1 with 8

        System.out.println("Please enter the file with numbers:");

        //Create Input to get numbers
        Scanner consoleInput = new Scanner(System.in);
        String originalFileName = consoleInput.nextLine();

        System.out.println("Please enter the file where you want to save results:");
        String resultsFileName = consoleInput.nextLine();

        //Lets convert our user input into actual files
        File originFile = new File(originalFileName);
        File outputFile = new File(resultsFileName);

        //We can put the scanner and the printWriter in the same try with resources
        //Put a semicolon in between them to differentiate
        //NEVER read and write from the same file at the same time!!!!
        try (Scanner fileScanner = new Scanner(originFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            //as long as there is a new line to read from the file
            //go ahead and read it
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                (line.contains("2")) {
                    line = line.replaceAll("2", "8");
                }

                writer.println(line);

            }


        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }


    }
}

