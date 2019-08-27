package com.insuranceInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readCSVFIle {

    String fileName = "Fl_In_Samp.csv";
    private List<String> list = new ArrayList<>();
    private List<String> headers = new ArrayList<>();
    //list that hold all the data
    private List<List<String>> mainList = new ArrayList<>();


    //read the file and place all contents into list
    public List<String> parseFIle(String file) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
       list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
        return list;
    }

    //get the headers and place them into a list
    public List<String> getTheHeaders(String file){
        //try with resource
        try(Stream<String> stream = Files.lines(Paths.get(file))){
            headers = stream
                    .filter(line -> line.startsWith("p"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
        }
       // headers.forEach(System.out::println);
        return headers;
    }

    //get the data skips the first line in the file then place the rest of the info into a list
    public List<String> getTheData(String fileName){
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            list = stream
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //combines the data array and header list into one main list with the header being index[0]
    public List<List<String>> combineList(List<String> headers, List<String> data){
         mainList = new ArrayList<>();
        String headerArray[] = headers.toString().split(",");
        String[][] allDataLines = new String[data.size()][];
        //use to increase the index and add each header
        int index= 0;
        //puts the headers into newList
        for(String heads : headerArray){
            mainList.add(new ArrayList<>());
            mainList.get(index).add(heads);
            index++;
        }
        index = 0;
        //places all the data lines into an Array of arrays
        for(String data1 : data){
            String[] hold = data1.toString().split(",");
            allDataLines[index] = hold;
            index++;
        }

        //loop through array of array break down and put each into proper place in newList
        //places each column of information inside the newList list as 18 separate columns
        for(List<String> strings : mainList) {
            int newIndex = 0;
            for(String[] s : allDataLines){
                String hold = s[newIndex];
                mainList.get(newIndex).add(hold);
                newIndex++;
                if(newIndex == 18){
                    newIndex = 0;
                }
            }

        }
        System.out.println(Arrays.toString(allDataLines[15]));
        System.out.println(mainList.get(0).size());
        return mainList;
    }
    //So now we have 2 workable data structures and the list of headers
    //One contains all lines of data in an Array Of Arrays
    //One contains 18 columns of each data row example a list of all policy ID's or point_latitude


    //So now we create methods that searches for certain data in each column


            //Searches the mainlist and populate the number of commercial and res occurrences.
            public int  countLineTypes(ArrayList<List<String>> list1, String lineType){
                List<String> propType = list1.get(15);
                int resCount = 0;
                int comCount = 0;
                    for (String s : propType){
                        if(s.equalsIgnoreCase("residential")) {
                            resCount++;
                        } if(s.equalsIgnoreCase("commercial")) {
                            comCount++;
                        }
                    }
                    if(lineType.equalsIgnoreCase("Residential")) {
                        return resCount;
                    } else {
                        return comCount;
                    }
            }

            //create a method that searches for all occurrences of a certain given county
            public int allCounties(String[][] allDataLines, String input){
                int count = 0;
                for(String[] search : allDataLines) {
                 if(search.toString().contains(input)) {
                     count++;
                 }
                }
               return count;
            }


            //find a certain policy number
            public String[] findPolicyById(String[][] allDataLines, String policyId){
                String[] arrayToReturn = new String[0];
                for(String[] search : allDataLines){
                    if(search[0].contains(policyId)){
                      arrayToReturn = search.clone();
                    }  else {
                        System.out.println("Sorry no policy exist with that number");
                    }
                }
                return arrayToReturn;
            }


            public static void main(String[] args) {
                String fileName = "Fl_In_Samp.csv";
                readCSVFIle read = new readCSVFIle();
                List<String> headers = read.getTheHeaders(fileName);
                List<String> theData = read.getTheData(fileName);
                read.combineList(headers, theData);

            }


}
