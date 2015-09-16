package com.epam.oksana_yusyna.java.lesson_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Оксана on 13.09.2015.
 */
/**
 * Oksana Yusyna Task 2
 * When user eneter empty string task finishes.
 */

public class WorkWithString {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ArrayList<String> listWitgString = new ArrayList<String>();
    private ArrayList<String> listWithWords = new ArrayList<String>();

    private String enteredString;
    private int middle_lenght;
    private double result;

    public void startWorkWithString() {
        //task 1
        System.out.println("Task 1");
        getShortestAndLongestString(getEneteredStrings());
        removeList();
        //task 2
        System.out.println("Task 2");
        printMoreThanMid(getMiddleLenght(getEneteredStrings()));
        removeList();
        //task 3
        System.out.println("Task 3");
        printLessThanMid(getMiddleLenght(getEneteredStrings()));
        removeList();
        //task 4
        System.out.println("Task 4");
        findWordDifChars(getWords(getEneteredStrings()));
        removeList();
        //task 5
        System.out.println("Task 5");
        getUniqueWord(getWords(getEneteredStrings()));
        removeList();
        //task 6
        System.out.println("Task 6");
        getStringWithDigits(getWords(getEneteredStrings()));
        removeList();
    } /*This function calls all functions below. */

    private void printMessage(String message1, String message2, String str , int lenght) {
        System.out.println(message1 + str +  " " + "\n" +
                message2 + lenght);
    }
    private void getShortestAndLongestString(ArrayList<String> list) { //task 1
        int min_lenght = Integer.MAX_VALUE;
        int max_lenght = 0;
        String maxString = null;
        String minString = null;
        String messForShortest = "The shortest string is: ";
        String messForShortLenght = "The shortest's string lenght is: ";
        String messForLongest = "The longest string is: ";
        String messForLongLenght = "The longest's string lenght is: ";

        for (String str : list) {
            if (str.length() > max_lenght) {
                maxString = str;
                max_lenght = str.length();
            }
            if (str.length() < min_lenght) {
                minString = str;
                min_lenght = str.length();
            }
        }
        printMessage(messForShortest, messForShortLenght, minString, min_lenght);
        printMessage(messForLongest, messForLongLenght, maxString, max_lenght);

    } /*Gets the shortest and longest strings. */

    private double getMiddleLenght(ArrayList<String> list) {
        middle_lenght = 0;
        for (String str : list) {
            middle_lenght += str.length();
        }
        result = (double)middle_lenght/listWitgString.size();
        System.out.println("Lenght of middle string is: " + result);
        return result;
    } /*Gets middle lenght of all entered strings. */

    private void printLessThanMid(double middle) { //task 3
        System.out.println("Less than middle length: ");
        for (String str : listWitgString) {
            if ((str.length()) < middle) {
                System.out.println(str + " Lenght: " + str.length());
            }
        }
    } /*Prints string which lendht less than middle lenght of all entered strings. */

    private void printMoreThanMid(double middle) { //task 2
        System.out.println("More than middle length: ");
        for (String str : listWitgString) {
            if ((str.length()) > middle) {
                System.out.println(str + " Lenght: " + str.length());
            }
        }
    } /*Prints string which lendht more than middle lenght of all entered strings. */

    private ArrayList<String> getEneteredStrings() {
        System.out.println("Type the string: ");
        try {
            while (true) {
                enteredString = reader.readLine();
                if (enteredString.isEmpty() == true) {
                    break;
                } else {
                    listWitgString.add(enteredString);
                }

            }
        } catch (IOException e) {
            e.getMessage();
        }
        return listWitgString;
    } /*Saves all entered strings to listWitgString. */

    private ArrayList<String> getWords(ArrayList<String> list) {
        String[] result;
        for (String str : list) {
            result = str.split(" ");
            for (String res : result) {
                listWithWords.add(res);
            }
        }
        /*for (String s : listWithWords) {
            System.out.println(s);
        }*/
        return listWithWords;
    } /*Separates words from entered strings and saves them to listWithWords. */

    private void getUniqueWord(ArrayList<String> list) {
        boolean result = false;
        for (String str : list) {
            result = checkWord(str);
            if (result) {
                System.out.println("This is string with unique characters: " + str);
                break;
            }
        }
    } /*Prints first word with differents characters. If there aren't words with different characters prints message. */

    private boolean checkWord(String word) {
        HashSet set = new HashSet(word.length());
        for (char c : word.toCharArray()) {
            if (!set.add(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    } /*Compares all chars in word and returns true if all characters are different. */

    private void getStringWithDigits(ArrayList<String> list) {
        int index = 0;
        int count =0;
        for (String str : list) {
            if (str.matches("\\d*$")) {
                count++;
                index = list.indexOf(str);
            }
            if (count == 2) {
                System.out.println("The second string which contains  only digits: " + list.get(index));
            }
        }
    } /*Compares each string with pattern and prints the second word, which contains only digits. */

    private void removeList() {
        listWitgString.clear();
        listWithWords.clear();
    } /*Remove all elements from lists. */

    private void findWordDifChars(ArrayList<String> list) {
        String result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (getMinDifChars(result) > getMinDifChars(list.get(i))) {
                result = list.get(i);
            }
        }
        System.out.println("The string wirh minimum different characters; " + result);
    } /*Compares count of same characters in two words. */

    private int getMinDifChars(String word) {
        char[] wordChar = word.toCharArray();
        int countOfRepeat = 0;
        for (int i = 1; i < wordChar.length; i++) {
            if (wordChar[0] != wordChar[i]) {
                countOfRepeat++;
            }
        }
        return countOfRepeat;
    } /*Gets count of same characters in word. */
}

