package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		// The big takeaway from all this is that most of the file system operations
		// that we do (checking how large a file is, creating a new file,
		// checking if it's a directory, etc.) we can do programmtically in java

		System.out.println("Please enter the file name:");
		String fileName = userInput.nextLine();

		File file = new File(fileName);

		//this confirms whether or not the file already exists in the system
		if(file.exists()) {
			System.out.println("Our file exists!");

			//we can get the absolute path of the file
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("File size: " + file.length());

			if(file.isFile()) {
				System.out.println("This is a file, not a directory");
			} else {
				System.out.println("This is a directory");
			}



		} else {
			System.out.println("Our file does not exist, so we will create it");

			//file.createNewFile();


		}

		// if we want to write to a file
		// NOTE: this will overwrite everything
		/*try(PrintWriter writer = new PrintWriter(file)) {
			writer.println("Hello Universe!");
		} catch(Exception ex) {
			System.out.println("Something went wrong");
		} */

		//if we want to append to the existing file content, then we use
		//FileOutputStream
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){

			writer.println("Goodnight Moon!");

		}


	}

}
