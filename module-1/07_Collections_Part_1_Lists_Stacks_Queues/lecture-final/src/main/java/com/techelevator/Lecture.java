package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();

		//To add a new value to the list, we just use the .add method
		names.add("Hulk");
		names.add("Black Widow");
		names.add("Captain America");
		names.add("Iron Man");

		numbers.add(10);
		numbers.add(20);

		doubles.add(2.2);
		doubles.add(3.3);

		booleans.add(true);
		booleans.add(true);
		booleans.add(false);


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i=0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Captain America");

/*
		//originally we saw with for loops how to start at the beginning of a list
		// and walk through to the end one by one
		for(int i=0; i < names.size(); i++) {
			String name = names.get(i);
			System.out.println(name);
		}

		//the foreach loop immediately below, is doing exactly what the for loop above is doing
		for(String name : names) {
			System.out.println(name);
		}

		//we can use the foreach loop with arrays
		String[] animals = {"cat","dog","ferret"};
		for(String a : animals) {
			System.out.println(a);
		}

		//as well as lists of any data type
		for(Double myDouble : doubles) {
			System.out.println(myDouble);
		}

*/
		for(String name : names) {
			System.out.println(name);
		}



		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(3, "Scarlet Witch");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by value or by index");
		System.out.println("####################");

		//names.remove(2); // Captain America is at 2
		// OR
		names.remove("Captain America");

		//NOTE: .remove only removes the first instance it finds, not all of them
		//if we want to remove all of them, we can use .contains, like below
		while(names.contains("Captain America")){
			names.remove("Captain America");
		}

		//if we want to remove the last instance instead of the first:
		int lastIndex = names.lastIndexOf("Captain America");
		if(lastIndex >= 0) {
			names.remove(lastIndex);
		}

		for(String name : names){
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");


		System.out.println("Is Hulk an avenger? " + names.contains("Hulk"));

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		int indexOfIronMan = names.indexOf("Iron Man");
		System.out.println("Iron Man is at index: "+ indexOfIronMan);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray = names.toArray(new String[0]);
		for(String name : namesArray){
			System.out.println(name);
		}

		//We can go the other direction too, converting an array into a list
		List<String> names2 = Arrays.asList(namesArray);
		for(String name : names2){
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		Collections.sort(names);
		for(String name : names){
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);
		for(String name : names){
			System.out.println(name);
		}

		System.out.println("####################");
		System.out.println("       Stack");
		System.out.println("####################");
		System.out.println();

		Stack<String> books = new Stack<>();
		books.push("The Shining");
		books.push("Locke & Key");
		books.push("Hatchet");
		books.push("The Bible");

		System.out.println("First book out is: " + books.pop());
		System.out.println("Second book out is: " + books.pop());
		System.out.println("Third book out is: " + books.pop());
		System.out.println("Fourth book out is: " + books.pop());


		System.out.println("####################");
		System.out.println("       Queue");
		System.out.println("####################");
		System.out.println();

		Queue<String> peopleInLine = new LinkedList<>();
		peopleInLine.offer("Joe");
		peopleInLine.offer("Jane");
		peopleInLine.offer("John");

		System.out.println("First person out of line:" + peopleInLine.poll());
		System.out.println("Second person out of line:" + peopleInLine.poll());
		System.out.println("Third person out of line:" + peopleInLine.poll());
	}
}
