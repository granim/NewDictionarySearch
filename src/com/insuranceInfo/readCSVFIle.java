package com.insuranceInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readCSVFIle {

    String fileName = "FL_insurance_sample.csv";
    private List<String> list = new ArrayList<>();
        //read the file and place all contents into list
    //TODO Separate into meaningful data sets 
    public void parseFIle() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
           list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.forEach(System.out::println);
    }

}
