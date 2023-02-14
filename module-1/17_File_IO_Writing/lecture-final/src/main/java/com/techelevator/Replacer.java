package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Replacer {

    public static void main(String[] args) {

        //Given a file with a new number on each line
        //I don't like the number 1
        //so I want to replace the number 1 with 8
        //and skip any lines that have a 6

        System.out.println("Please enter the file with numbers:");

        Scanner consoleInput = new Scanner(System.in);
        String originalFileName = consoleInput.nextLine();

        System.out.println("Please enter the file where you want to save the results:");

        String resultsFileName = consoleInput.nextLine();

        //Let's convert our user input to actual files
        File originFile = new File(originalFileName);
        File outputFile = new File(resultsFileName);

        //We can put the scanner and the printwriter in the same try with resources
        //Put a semicolon in between them to differentiate
        //NEVER read and write from the same file at the same time!!!!
        try(Scanner fileScanner = new Scanner(originFile);
            PrintWriter writer = new PrintWriter(outputFile)) {

            //as long as there is a new line to read from the file
            // go ahead  and read it
            while(fileScanner.hasNextLine()){

                String line = fileScanner.nextLine();

                //if there is a 6 in the line, completely skip writing it
                if(!line.contains("6")) {

                    //replace 1's with 8's
                    if (line.contains("1")) {
                        line = line.replace("1", "8");

                    }

                    writer.println(line);
                }
            }



        } catch(Exception ex) {
            System.out.println("Something went wrong");
        }

    }

}
