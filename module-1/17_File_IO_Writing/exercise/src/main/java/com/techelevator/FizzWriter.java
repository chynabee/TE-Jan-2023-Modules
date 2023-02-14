package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */


		System.out.println("Please enter the file to save results:");
		String resultsFizzBuzzFileName = userInput.nextLine();

		File fizzFile = new File(resultsFizzBuzzFileName);

		try (PrintWriter writer = new PrintWriter(fizzFile)) {
			int number = 0;
			for (int i = 1; i <= 300; i++) {
				number++;

				if (number % 3 == 0 && number % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (number % 3 == 0) {
					writer.println("Fizz");
				} else if (number % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(number);
				}
			}


		} catch (Exception ex) {
			System.out.println("Something went wrong");

		}
	}
}