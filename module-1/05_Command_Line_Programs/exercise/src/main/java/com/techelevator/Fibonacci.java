package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a number:");
		//number entered
		String fibonacciNumbersStr = input.nextLine();

		int inputFibonacciNumber = Integer.parseInt(fibonacciNumbersStr);
		int firstNumber = 0;
		int secondNumber = 1;


		if (inputFibonacciNumber <= 0) {
			System.out.print("0, 1 ");

			} else{
			System.out.print("0, 1, ");
				for (int thirdNumber = 1; thirdNumber <= inputFibonacciNumber; thirdNumber = firstNumber + secondNumber) {
					firstNumber = secondNumber;
					secondNumber = thirdNumber;

					System.out.print(thirdNumber + ", ");
				}

			}
		}
	}







