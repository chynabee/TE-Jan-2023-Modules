package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */

Scanner consoleInput = new Scanner(System.in);

		System.out.println("Please enter the file:");
		String fileName = consoleInput.nextLine();

		System.out.println("What is the search word you are looking for");
		String wordSearched = consoleInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N)" );
		String isCaseSensitive = consoleInput.nextLine();

		//Step 1: Create file object in Java
		File file = new File(fileName);

		//Step 2: Open a try with resources with a scanner
		try(Scanner fileScanner = new Scanner(file)) {
		int lineNumber = 0;



			//Step 3: read from the file as long as there is a new line to read
			while(fileScanner.hasNextLine()) {

				//Step 4: read the line from the file and save it as a string
				String line = fileScanner.nextLine();
				lineNumber++;

				if(isCaseSensitive.equalsIgnoreCase("N")){
					String lowercaseLine = line.toLowerCase();
					String lowercaseWordSearched = wordSearched.toLowerCase();

					if(lowercaseLine.contains(lowercaseWordSearched)) {
						System.out.println(lineNumber + ") " + line);
					}

				}



				//Step 5: implement an if or whatever business logic- we want to print

				else if(line.contains(wordSearched)) {
					System.out.println(lineNumber + ") " + line);
				}

			}




		} catch (FileNotFoundException ex) {
		System.out.println("File was not found");
		}


	}

}
