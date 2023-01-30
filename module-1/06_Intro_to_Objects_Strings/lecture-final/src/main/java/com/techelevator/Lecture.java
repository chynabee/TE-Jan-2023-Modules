package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		/*
		// this is the object based on the Person blueprint (class)
		Person christopher = new Person();
		Person christopher2 = new Person();

		christopher.sayHello();

		if(christopher == christopher2) { //false

		}

		if(christopher.equals(christopher2)) {  //this can be true

		}


		int i = 2;
		int j = 3;
		if(i == j) {
			System.out.println("THese are equal!");
		}

		String name = "Christopher";
		String name2 = "Chris";
		String duplicateName = name;
		if(name.equals(name2)){
			System.out.println("These are equal!");
		}


		 */

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		String animal = "cat";
		String pet = "dog";

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		String company = "Tech Elevator";

		boolean endsWithElevator = company.endsWith("Elevator");
		System.out.println("Ends with Elevator: " + endsWithElevator);

		boolean endsWithTech = company.endsWith("Tech");
		System.out.println("Ends with Tech: " + endsWithTech);

		boolean endsWithTor = company.endsWith("tor");
		System.out.println("Ends with tor: " + endsWithTor);

		boolean startsWithT = company.startsWith("T");
		System.out.println("Starts with T: " + startsWithT);

		int indexOfFirstInstance = company.indexOf("e");
		System.out.println("Index of e: " + indexOfFirstInstance);

		int lastIndexOfInstance = company.lastIndexOf("e");
		System.out.println("Last index of e: " + lastIndexOfInstance);

		System.out.println("Length of my string is:" + company.length());


		String partOfString = company.substring(0, 4);
		System.out.println("Substring starting at 0 and going until 4: " + partOfString);

		int indexOfSpace = company.indexOf(" ");
		String lastPartOfString = company.substring(indexOfSpace+1);
		System.out.println("Substring after the space: "+lastPartOfString);

		System.out.println("All to lower case: " + company.toLowerCase());

		System.out.println("All to upper case: " + company.toUpperCase());

		String withSpaceExample = "       Tech Elevator        ";
		System.out.println("Trim any whitespace: " + withSpaceExample.trim());


		System.out.println("Replacing each instance of e with E: " + company.replace("e", "E"));

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
