package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// we want to change from decimal to binary
		System.out.println("Change from Decimal to Binary");

		//ask user to enter the decimal they want to change to binary
		System.out.print("Enter the decimal you want to change to binary:");

		String decimalNumbersStr = input.nextLine();

		String[] decimal = decimalNumbersStr.split(" ");

		for (int i = 0; i < decimal.length; i++) {
			int binaryNumber = Integer.parseInt(decimal[i]);
			String resultBinary = Integer.toBinaryString(binaryNumber);

			System.out.println("The decimal number " + binaryNumber  + " is " + resultBinary);
		}

	}
}



















