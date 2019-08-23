package com.company;

import java.io.File;
import java.util.HashMap;


public class Application {

	public static void main(String[] args) {



			////Dictionary
		File file = new File("src/dictionaryTwo.txt");
		// creates and populates the hashMap
		Readfile.createMap(file);
		// create a populated hashmap
		Readfile newRead = new Readfile();
		HashMap<String, String> useDiction = newRead.getDiction();

		System.out.println("Enter a word: " + " Or enter exit to exit the program");
		SearchWord.findWord(useDiction);

	}




}
