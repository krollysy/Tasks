package com.epam.oksana_yusyna.java.lesson_1.task_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Oksana_Yusyna on 9/14/2015.
 */

/**
 * Oksana Yusyna Task 3
 */

public class CalculateClass {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ArrayList<Integer> listForNum = new ArrayList<Integer>();
    private int number_A;
    private int number_B;
    private String operation;
    public void letsCalculate() {
        getEnteredNumbers();
    } /*This function calls all functions below*/

    private void getEnteredNumbers() {
        try {
            while (true) {
                System.out.println("Type first number: ");
                number_A = Integer.parseInt(reader.readLine());
                listForNum.add(number_A);

                System.out.println("Type the second number: ");
                number_B = Integer.parseInt(reader.readLine());
                listForNum.add(number_B);

                System.out.println("Choose one of the operations: " +
                        "Type: + or - or * or /");
                operation = reader.readLine();
                if (operation.equals("+")) {
                    getSum(listForNum, operation);
                    break;
                } else if (operation.equals("-")) {
                    getChange(listForNum, operation);
                    break;
                } else if (operation.equals("*")) {
                    getMultiple(listForNum, operation);
                    break;
                } else if (operation.equals("/")) {
                    getSplit(listForNum, operation);
                    break;
                } else {
                    System.out.println("Do you want to cancel? Type Y or N: ");
                    operation = reader.readLine();
                    if (operation.equals("Y")) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong number! Please try again.");
            getEnteredNumbers();
        }
    } /*Reads two entered numbers and option and calls appropriate function. */

    private void getSum(ArrayList<Integer> list, String operation) {
        System.out.println("The answer is: " + (list.get(0) + list.get(1)));
        //return list.get(0) + list.get(1);
    } /*Implements "+" option*/

    private void getChange(ArrayList<Integer> list, String operation) {
        System.out.println("The answer is: " + (list.get(0) - list.get(1)));
    } /*Implements "-" option*/

    private void getMultiple(ArrayList<Integer> list, String operation) {
        System.out.println("The answer is: " + (list.get(0) * list.get(1)));
    } /*Implements "*" option*/

    private void getSplit(ArrayList<Integer> list, String operation) {
        System.out.println("The answer is: " + ((double)list.get(0) / (double)list.get(1)));
    } /*Implements "/" option*/
}
