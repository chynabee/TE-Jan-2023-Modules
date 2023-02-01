package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//When we declare a new map, we have to specify what data type
		// the key and the value are. They can be different data types
		// or the same

		//Example where key is Integer and value is Integer
		Map<Integer, Integer> integerMap = new HashMap<>();

		// Example where key is String and value is String
		Map<String, String> stringMap = new HashMap<>();

		//Example where the key is a Integer and the value is a Double
		Map<Integer, Double> doubleMap = new HashMap<>();

		//If I wanted to get really crazy, I could say the key is an Integer and the value is a List<String>
		Map<Integer, List<String>> listMap = new HashMap<>();

		//Maps typically do not keep any order, but if we want to force it to enforce order (numeric, alphabetical, etc.)
		//instead of using a HashMap we can use a TreeMap
		Map<String, String> treeMap = new TreeMap<>();

		//And if you want to keep the order that you put items into it
		Map<String, String> linkedMap = new LinkedHashMap<>();

		//To mimic the mall directory, we can use Integer as the Key, and String as the Value
		Map<Integer, String> mallDirectory = new HashMap<>();

		//To enter new key-value pairs into the map
		mallDirectory.put(118, "360 Clothing Studios");
		mallDirectory.put(142, "Blush Gallery");
		mallDirectory.put(124, "The Carvery");
		mallDirectory.put(117, "Champs Sports");
		mallDirectory.put(131, "Charley's Philly Steaks");
		mallDirectory.put(144, "Starbucks");
		mallDirectory.put(155, "Starbucks"); // Totally fine to have duplicate values, just never duplicate keys

		//if we want to update any of of the existing values
		mallDirectory.put(117, "Gamestop");

		//if we want to check if the key already exists
		boolean doesKeyExist = mallDirectory.containsKey(124);
		System.out.println("Does the key for 'The Carvery' (124) already exist:" + doesKeyExist );

		// if we want to remove a value
		mallDirectory.remove(155);

		//if we want to iterate through all the entries in our map:
		for(Map.Entry<Integer, String> entry : mallDirectory.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value:" + entry.getValue());
		}

		//if we wanted to iterate through only the keys in our map:
		for(Integer key : mallDirectory.keySet()){
			System.out.println("Key: " + key);
		}

		//if we wanted to iterate through only the values in our map:
		for(String value : mallDirectory.values()) {
			System.out.println("Value: " + value);
		}

		String genre = getBookGenre("Ready Player One");
		System.out.println("Our genre for Ready Player One is " + genre);

		String genre1 = getBookGenre("Twilight");
		System.out.println("Our genre for Twilight is " + genre1);

		//if we pass in a key that does not exist, it return null
		String genre2 = getBookGenre("Dr. Sleep");
		System.out.println("Our genre for Dr. Sleep is " + genre2);

		//what if I pass in The Hobbit, but it's all caps?
		String genre3 = getBookGenre("THE HOBBIT");
		System.out.println("Our genre for THE HOBBIT is " + genre3);

		//if I can change the values of the map, I can make them all one case, and then force
		// the title to be that same case

		//Now what if I want to be mean and pass in a null
		String genre4 = getBookGenre(null);
		System.out.println("Our genre for null is " + genre4);


		Map<String, Integer> frenchFries = new HashMap<>();
		frenchFries.put("Cori", 26);
		frenchFries.put("Violet", 75);
		Map<String, Integer> equalFries =  makeFairShare(frenchFries);

		Map<String, Integer> equalFries2 =  makeFairShareWithDadTax(frenchFries);

		Map<String, Integer> comicsMap = countComics();

		System.out.println("Finished");
	}

	// Return the book genre when given a title
	public static String getBookGenre(String title) {

		Map<String, String> bookMap = new HashMap<>();
		bookMap.put("the shining", "Horror");
		bookMap.put("the hobbit", "Fantasy");
		bookMap.put("twilight", "Romance");
		bookMap.put("ready player one", "Sci-Fi");
		bookMap.put("harry potter", "Best-Seller/Fantasy");

		if(title == null || !bookMap.containsKey(title.toLowerCase())) {
			return "Unknown";
		}

		return bookMap.get(title.toLowerCase());
	}

	// if the french fries are more than 10 fries different, then make them equal
	public static Map<String, Integer> makeFairShare(Map<String, Integer> originalFrenchFries) {

		int fries1 = originalFrenchFries.get("Cori");
		int fries2 = originalFrenchFries.get("Violet");

		// Math is a java library, and .abs gives me the absolute value
		int difference = Math.abs(fries1 - fries2);

		if(difference > 10) {

			int totalFries = fries1 + fries2;

			// we will divide the total fries by 2
			int fries1Equal = totalFries / 2;

			// because integers can't hold decimals, and no one wants to waste a french frie, just give the
			// remaining french fries to the second happy meal
			int fries2Equal = totalFries / 2;

			//add the dad tax
			int dadTax = totalFries - (fries1Equal + fries2Equal);

			//we don't need these print statements, but just to show what the new values are:
			System.out.println("Original fries: " + fries1 + " now becomes " + fries1Equal);
			System.out.println("Original fries: " + fries2 + " now becomes " + fries2Equal);
			System.out.println("Dad tax is " + dadTax);

			originalFrenchFries.put("Cori", fries1Equal);
			originalFrenchFries.put("Violet", fries2Equal);
			originalFrenchFries.put("Dad", dadTax);

		}

		return originalFrenchFries;
	}

	public static Map<String, Integer> makeFairShareWithDadTax(Map<String, Integer> originalFrenchFries) {

		int fries1 = originalFrenchFries.get("Cori");
		int fries2 = originalFrenchFries.get("Violet");

		// Math is a java library, and .abs gives me the absolute value
		int difference = Math.abs(fries1 - fries2);

		if(difference > 10) {

			int totalFries = fries1 + fries2;

			// we will divide the total fries by 2
			int fries1Equal = totalFries / 2;

			// because integers can't hold decimals, and no one wants to waste a french frie, just give the
			// remaining french fries to the second happy meal
			int fries2Equal = totalFries - fries1Equal;

			//we don't need these print statements, but just to show what the new values are:
			System.out.println("Original fries: " + fries1 + " now becomes " + fries1Equal);
			System.out.println("Original fries: " + fries2 + " now becomes " + fries2Equal);

			originalFrenchFries.put("Cori", fries1Equal);
			originalFrenchFries.put("Violet", fries2Equal);

		}

		return originalFrenchFries;
	}



	public static Map<String, Integer> countComics( ) {

		List<String> comics = new ArrayList<>();
		comics.add("Spiderman");
		comics.add("Thor");
		comics.add("Batman");
		comics.add("Locke And Key");
		comics.add("Batman");
		comics.add("Batman");
		comics.add("Spiderman");

		Map<String, Integer> comicsMap = new HashMap<>();

		for(String comic : comics) {

			if(!comicsMap.containsKey(comic)) {
				comicsMap.put(comic, 1);
			} else {
				int currentCount = comicsMap.get(comic);
				currentCount++;
				comicsMap.put(comic, currentCount);
			}

		}

		return comicsMap;

	}

}
