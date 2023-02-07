package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald {
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);

		System.out.println("Welcome to the Farm");
		System.out.println();
		System.out.println("What do you want to do?");
		System.out.println("1) Sing the Song");
		System.out.println("2) Go to the Market");
		System.out.print("Select an option: ");

		String option = input.nextLine();

		System.out.println();
		System.out.println();

		if(option.equals("1"))
		{
			List<Singable> singables = new ArrayList<>();
			singables.add(new Cow());
			singables.add(new Chicken());
			singables.add(new Pig());
			singables.add(new Tractor());


			for (Singable singable : singables)
			{
				String name = singable.getName();
				String sound = singable.getSound();
				System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
				System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
				System.out.println("With a " + sound + " " + sound + " here");
				System.out.println("And a " + sound + " " + sound + " there");
				System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
				System.out.println();
			}
		}
		else
		{
			System.out.println("Welcome to the Market!");
			System.out.println();

			// going to the market
			List<Sellable> sellables = new ArrayList<>();
			sellables.add(new Egg());
			sellables.add(new Pig());

			// list all of the items that we want to sell
			// name and price
			for(Sellable sellable: sellables)
			{
				System.out.println("Get your " + sellable.getName() + " for only $" + sellable.getPrice());
			}

		}
	}
}