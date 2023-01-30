package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the temperature:");

		//create an input to have user enter the temp
		String temperatureDegreeStr = input.nextLine();


		//Ask if its celsius or fahrenheit
		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit?");
		String optionSelected = input.nextLine();


		//Check if the input is a c or f
		//if celcius want to convert to fahrenheit
		if(optionSelected.equalsIgnoreCase("C")) {
			int temperatureCelsius = Integer.parseInt(temperatureDegreeStr);
			double temperatureFarenheit = temperatureCelsius * 1.8 + 32;

			//print out the results with the
			//System.out.println

			System.out.println(temperatureDegreeStr + "C is " + temperatureFarenheit);
		}

		//if fahrenheit want to convert to celcius
		if(optionSelected.equalsIgnoreCase("F")) {
			int temperatureFarenheit = Integer.parseInt(temperatureDegreeStr);
			double temperatureCelcius = (temperatureFarenheit - 32) / 1.8;

			//print out the results with the
			//System.out.println

			System.out.println(temperatureDegreeStr + "F is " + temperatureCelcius + "C");
		}
















	}

}
