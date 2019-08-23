package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class SearchWord {

	public static void findWord(HashMap<String, String> useDiction) {
		
		// compares the user input against the key inside the hashmap and outputs both
		// key and value if found
		while (true) {
			Scanner scan = new Scanner(System.in);
			String userInput = scan.next().toLowerCase();
			
			
			if (useDiction.containsKey(userInput)) {
				System.out.println(useDiction.get(userInput));
				System.out.println("Enter a word: " + " Or enter exit to exit the program");
			} else if (!(useDiction.containsKey(userInput)) && !(userInput.equals("exiting"))) {
				System.out.println("Sorry did not recognize that word, try again. ");
			}
			if (userInput.equals("exiting")) {
				System.out.println("Thank you for useing my program! ");
				scan.close();
				break;
			}

		}

	}

}
