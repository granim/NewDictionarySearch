package com.insuranceInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readCSVFIle {

    String fileName = "Fl_In_Samp.csv";
    private List<String> list = new ArrayList<>();
    private List<String> headers = new ArrayList<>();

    //read the file and place all contents into list
    //TODO Separate into meaningful data sets
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
        headers.forEach(System.out::println);
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


    public List<List<String>> combineList(List<String> headers, List<String> data){
        List<List<String>> newList = new ArrayList<>();
        String headerArray[] = headers.toString().split(",");
        String[][] allDataLines = new String[data.size()][];
        //use to increase the index and add each header
        int index= 0;
        //puts the headers into newList
        for(String heads : headerArray){
            newList.add(new ArrayList<>());
            newList.get(index).add(heads);
            index++;
        }
        index = 0;
        //places all the data lines into an Array of arrays
        for(String data1 : data){
            String[] hold = data1.toString().split(",");
            allDataLines[index] = hold;
            index++;
        }

        //loop through array of array break down and put each into proper place in newLis
        for(List<String> strings : newList) {
            
        }

        return newList;

    }




    public static void main(String[] args) {
        String fileName = "Fl_In_Samp.csv";
        readCSVFIle read = new readCSVFIle();
       List<String> headers = read.getTheHeaders(fileName);
       List<String> theData = read.getTheData(fileName);
        read.combineList(headers, theData);
    }



}
