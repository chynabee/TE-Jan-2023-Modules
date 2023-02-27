package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {

        //Given a file with a new number on each line
        //I want to double every even number
        //and triple every odd number
        //and write out the results to a new file

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
        try(Scanner fileScanner = new Scanner(originFile);
        PrintWriter writer = new PrintWriter(outputFile)) {

            //as long as there is a new line to read from the file
            //go ahead and read it
            while(fileScanner.hasNextLine()){

                String line = fileScanner.nextLine();
                int num = Integer.parseInt(line);

                //if its an even number I want to double it
                //remember we can use the remainder operator to check if its even
                if(num % 2 == 0){
                    num *= 2;
                }

                //if its an odd number I want to triple it
                //remember if its odd, then %2 will always result in 1 as a remainder
                if(num % 2 == 1) {
                    //num = num * 3; can be written as below
                    num *= 3;

                }
                //print this to our new file
                writer.println(num);
            }




        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }


    }
}
