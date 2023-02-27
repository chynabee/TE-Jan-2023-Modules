package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		//date type
		//can only be one type
		List<String> names = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();

		//To add a new value to the list, use the .add method
		names.add("Hulk");
		names.add("Black Widow");
		names.add("Captain America");
		names.add("Iron Man");

		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		doubles.add(2.2);
		doubles.add(3.3);

		booleans.add(true);
		booleans.add(true);
		booleans.add(false);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		for (int i=0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}



		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Captain America");
	/*
		for (int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		String[] animals = {"cat", "dog", "ferret"};
		for(String a : animals) {
			System.out.println(a);
		}
	*/
		//for each variable in this list do something with it
		for (String name : names) {
			System.out.println(name);
		}

		for (Double myDouble : doubles) {
			System.out.println(myDouble);

		}



		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.remove(3, "Scarlet Witch");



		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(0); // hulk is at 0
		// OR
		// names.remove("Hulk");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


	}
}
