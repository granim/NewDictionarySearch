package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findNumbers {


//algorithmic thinking
    public static void main(String[] args) {
        //simple algorithm to check for a single peak
        int[] numbers = {1,2,3,4,5,6,7,8,7,6,5,4,3,2,1};
        int hold = 0;
        //for each loop to go over the array and check for the a largest number
            for (int a : numbers) {
                if(a <= numbers[a + 1]) {
                    continue;
                }
                hold = a;
            }
            System.out.println(hold + " Is the peak");
            //Orrr
            List<Integer> number = new ArrayList<>();
            for(int i = 0; i < 1000; i ++) {
                number.add(i);
            }
            //Sort the list if it was not already sorted
             Collections.sort(number);
            //Find the max
            Collections.max(number);
            System.out.println(number.size() + " The Size");

            //create a int the size of the array and then divide it by 2 to get the center index position
            int checkLength = numbers.length;
             checkLength = checkLength / 2;


             int[] a = {1,2,3,4,5,6,7,8,7,6,5,4,3,2,1};
             ///if numbers index 7
               for(int p : a) {
                    //if index 0 is less then index 0 + 1 and index 0 is greater then index 0 -1 print
                    //is not working
                    //if index 5  is less then index 5 + 1 and index 5 is greater then index 5 -1 print
                  if(a[p] < a[p+1] && a[p] > a[p-1] ) {
                        System.out.println(p + " Position");
                    }
                }


           //  if( numbers[checkLength] < numbers[checkLength + 1] && numbers[checkLength] > numbers[checkLength -1]){


        List<Integer> smallArray = new ArrayList<>();
        for(int s : numbers) {
           smallArray.add(numbers[s]);
        }
        System.out.println(smallArray.size());


        for(int p : smallArray) {
            if(smallArray.get(p) <= smallArray.get(p + 1)) {
               continue;
            }
            System.out.println(p + " p");
        }

        int[][] ints = {{1,2,3,4,},{5,6,7,8,9},{10,11,10,8}};

        for(int[] i : ints) {

        }



    }



}
