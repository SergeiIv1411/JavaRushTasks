package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.frequency;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList list = new ArrayList<>();
        ArrayList  list2 = new ArrayList ();
        while(fileInputStream.available() > 0){
            list.add(fileInputStream.read());
        }
        fileInputStream.close();
        int min = 999999999;
        for (int i = 0; i < list.size(); i ++)
        {
            if(frequency(list, list.get(i)) < min){
                min = frequency(list, list.get(i));
            }
        }
        for(int i=0;list.size()>i;i++){

            if(frequency(list,list.get(i)) == min) {


                if(!list2.contains(list.get(i))) {
                    System.out.print(list.get(i) + " ");
                    list2.add(list.get(i));

                }
            }


        }
    }
}
