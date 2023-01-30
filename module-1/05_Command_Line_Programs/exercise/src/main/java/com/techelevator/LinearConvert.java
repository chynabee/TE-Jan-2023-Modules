package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length:");

		//create an input to have user enter the measurement
		String measurementStr = input.nextLine();


		//Ask if measurement is by foot or by meter
		System.out.print("Is the measurement in (m)eter, or (f)eet?");
		String optionSelected = input.nextLine();


		//Check if the input is a m or f
		//if meter want to convert to feet
		if(optionSelected.equalsIgnoreCase("m")) {
			int measurementMeter = Integer.parseInt(measurementStr);
			double measurementFeet = measurementMeter * 3.2808399;

			//print out the results with the
			//System.out.println

			System.out.println(measurementStr + "m " + "is " + measurementFeet + "f.");
		}

		//if feet want to convert to meter
		if(optionSelected.equalsIgnoreCase("f")) {
			int measurementFeet = Integer.parseInt(measurementStr);
			double measurementMeter = measurementFeet * 0.3048;

			//print out the results with the
			//System.out.println

			System.out.println(measurementStr + "f " + "is " + measurementMeter + "m.");
		}






	}

}
