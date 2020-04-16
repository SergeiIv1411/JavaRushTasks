package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";

        data = new String(Files.readAllBytes(Paths.get(reader.readLine())));
        reader.close();
        data = data.replaceAll(System.getProperty("line.separator"), "");
        String[] dataMas = data.split(" ");

        StringBuilder result = getLine(dataMas);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder("");

        Map<String, char[]> map = new HashMap<>();
        ArrayList<String> currentWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            currentWords.add(words[i]);
        }

        char[] symbolsOfWord;
        char[] symbols;
        for (int i = 0; i < words.length; i++){
            symbolsOfWord = words[i].toLowerCase().toCharArray();
            symbols = new char[]{symbolsOfWord[0], symbolsOfWord[symbolsOfWord.length - 1]};
            map.put(words[i], symbols);
        }

        ArrayList<String> reserve = new ArrayList<>();
        for (String word : currentWords){
            reserve.add(word);
        }

        StringBuilder str = new StringBuilder("");
        char currentSymbol;
        char lastSymbol;
        int cycleCount = 0;
        int count = 0;

        for (int i = 0; currentWords.size() != 0; i++) {
            currentWords = new ArrayList<>();
            for (String word : reserve){
                currentWords.add(word);
            }

            str = new StringBuilder("");
            str.append(currentWords.get(i));
            lastSymbol = map.get(currentWords.get(i))[1];
            currentWords.remove(i);

            while (currentWords.size() > 0) {
                currentSymbol = map.get(currentWords.get(count))[0];
                if (currentSymbol == lastSymbol) {
                    lastSymbol = map.get(currentWords.get(count))[1];
                    str.append(" " + currentWords.get(count));
                    currentWords.remove(count);
                    cycleCount = 0;
                } else count++;

                if (count == currentWords.size() && cycleCount == 0){
                    count = 0;
                    cycleCount++;
                } else {
                    if (count == currentWords.size() && cycleCount > 0) {
                        cycleCount = 0;
                        count = 0;
                        break;
                    }
                }
            }
        }

        return str;
    }
}
