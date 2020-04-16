package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        StringBuilder lines = new StringBuilder();
        while (bufferedReader.ready()){
            lines.append(bufferedReader.readLine()).append(" ");
        }
        bufferedReader.close();
        fileInputStream.close();
        String[] line = lines.toString().split("\\s");
        lines.setLength(0);
        for (int i=0; i<line.length-1; i++){
            if (line[i].equals(sb.append(line[i+1]).reverse().toString())){
                Pair pair = new Pair();
                pair.first = line[i];
                pair.second = line[i+1];
                if (!result.contains(pair)) result.add(pair);
            }
            sb.setLength(0);
        }


        for (Pair pair: result){
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
