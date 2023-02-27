package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//When we declare a new map, we have to specity what data type
		//the key and the value are. They can be different data types or the same

		//Example where key is Integer and value is Integer
		Map<Integer, Integer> integerMap = new HashMap<>();

		//Example where key is String and value is String
		Map<String, String> stringMap = new HashMap<>();

		//Example where key is Integer and value is Double
		Map<Integer, Double> doubleMap = new HashMap<>();

		//Maps typically do not keep any order, but if we want to force it to enforce the order
		//(numeric, alphabetical, etc.) instead of using a HashMap we can use a TreeMap
		Map<String, String> treeMap = new TreeMap<>();

		//And if you want to keep the order that you put items into it
		Map<String, String> linkedMap = new LinkedHashMap<>();

		//To mimic the mall directory, we can use Integer as the Key and String as the value
		Map<Integer, String> mallDirectory = new HashMap<>();

		//****If I wanted to get crazy, I could say the key is an Integer and the value is a List<String>
		Map<Integer, List<String>> listMap = new HashMap<>();//if multiple stores located in key "118"

		//To enter new key value pairs into the map
		mallDirectory.put(118, "360 Clothing Studios");
		mallDirectory.put(142, "Blush Gallery");
		mallDirectory.put(127, "Eighty8ight Beauty");
		mallDirectory.put(2020, "Prestigious Pose Pros");
		mallDirectory.put(131, "Charley's Philly Steaks");
		mallDirectory.put(124, "Blush Gallery");

		//If we want to update any of the existing values
		mallDirectory.put(127, "New Venue");

		//If we want to check if the key already exists
		boolean doesKeyExist = mallDirectory.containsKey(2020);

		System.out.println("Does the key for Prestigious Pose Pros already exist: " + doesKeyExist);

		//If we want to remove a value
		mallDirectory.remove(124);

		//If we want to iterate through all of the entries in our map:
		for (Map.Entry<Integer, String> entry : mallDirectory.entrySet()) {
			System.out.println("Key: " +entry.getKey() + " - Value: " + entry.getValue());

		//If we want to iterate throught only the keys in our map:
		for(Integer key : mallDirectory.keySet())	{
			System.out.println("Key: " + key);
		}
		//If we want to iterate through only the values in our map:
			for (String value : mallDirectory.values()) {
				System.out.println("Key: " + value);
			}
		}
		//Return the book genre when given a title
		 public static String get {

			Map<String, String> bookMap = new HashMap<>();
			bookMap.put("The Shining", "Horror");
			bookMap.put("The Hobbit", "Fantasy");
			bookMap.put("Twilight", "Romance");
			bookMap.put("Ready Player One", "Sci-Fi");
			bookMap.put("Harry Potter", "Best Seller/Fantasy");

			return null;
		}



	}

}
