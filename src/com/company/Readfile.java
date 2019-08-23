package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Readfile {

	private static String hold;
	private static String[] stringArray = new String[1];

	private static HashMap<String, String> diction = new HashMap<String, String>();
	private static HashMap<String, List<String>> dictionTwo = new HashMap<>();

	public static HashMap<String, List<String>> getDictionTwo() {
		return dictionTwo;
	}

	public static void setDictionTwo(HashMap<String, List<String>> dictionTwo) {
		Readfile.dictionTwo = dictionTwo;
	}

	public HashMap<String, String> getDiction() {
		return diction;
	}

	public void setDiction(HashMap<String, String> diction) {
		Readfile.diction = diction;
	}

	
	/*
	 * Reads the .txt file and populates the hashMap, Key being the word and the
	 * value the definition of the word The Variable hold, holds the entire string
	 * for each line. The below if statement breaks up hold into the needed Key
	 * value and pair .
	 */
	ArrayList<String> test = new ArrayList<>();
	public static void createMap(File file) {
  diction.put("sdfsd", "sfdss");
  try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			hold = bufferedReader.readLine();
			while (hold != null) {

				if (bufferedReader.readLine() != "") {
					stringArray = hold.split(" ");
					diction.put(stringArray[0].toLowerCase(), hold);

					if(diction.containsKey(stringArray[0])){
						dictionTwo.put(stringArray[0], new ArrayList<String>());
						dictionTwo.get(stringArray[0]).add(hold);
				}
					hold = bufferedReader.readLine();

				}

			/*	if (!bufferedReader.readLine().equals("")) {
					stringArray = hold.split(" ");
						if( ! diction.containsKey(stringArray[0].toLowerCase())) {
							diction.put(stringArray[0].toLowerCase(), new ArrayList<String>());
						}
					if( diction.containsKey(stringArray[0].toLowerCase())) {
						if(diction.get(stringArray[0]) ==  null){
							System.out.println("This is null for some reason");
						}
						diction.get(stringArray[0]).add(hold);
					}
							hold = bufferedReader.readLine();
						
					
				}*/
			
			}

		} catch (FileNotFoundException e) {
			System.out.println("Sorry could not find the proper file " + file);
		} catch (IOException e) {
			System.out.println("Sorry there was a problem with the program ");
		}

	}

	@Override
	public String toString() {
		return "Readfile [getDiction()=" + getDiction() + "]";
	}

	
	
	
	
}
