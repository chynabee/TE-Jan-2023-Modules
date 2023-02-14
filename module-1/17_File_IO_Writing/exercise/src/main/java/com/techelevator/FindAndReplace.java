package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */

        int counter = 0;

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFileName = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFileName = userInput.nextLine();

        File sourceFile = new File(sourceFileName);
        File destinationFile = new File(destinationFileName);

        try(Scanner fileScanner = new Scanner (sourceFile);
            PrintWriter writer = new PrintWriter(destinationFile)) {

            while(fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                counter++;


                   String newline = line.replaceAll(searchWord, replacementWord);


                writer.println(newline);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }











    }

}
