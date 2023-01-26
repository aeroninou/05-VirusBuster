package com.virusbuster.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static void  textParse(List<String> wordlist) {
        String verb, noun;
        List<String> items = new ArrayList<>(Arrays.asList("Camu Camu", "Zippo Lighter", "Silver Pen", "Sumalak", "Glacier Magical Plant"));

    }

    public static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);

        for (String word : words) {
            strlist.add(word);
        }
    return strlist;
    }
}

