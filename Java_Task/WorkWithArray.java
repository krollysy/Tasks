package com.epam.oksana_yusyna.java.lesson_1.task_1;

/**
 * Created by Oksana_Yusyna on 9/11/2015.
 */

/**
 * Oksana Yusyna Task 1
 */

public class WorkWithArray {
    private int min_border = -10;
    private int max_border = 10;
    private int array_size = 20;

    private int targetArray [] = new int[array_size];

    public void startWorkWithArray() {
        // task 1
        System.out.println("Task 1");
        printArray(getTargetArray());
        printArray(changeMinAndMax());
        // task 2
        System.out.println("Task 2");
        printArray(getTargetArray());
        getSumOfEvenElements();
        // task 3
        System.out.println("Task 3");
        printArray(getTargetArray());
        printArray(replaceNegativeElements());
        //task 4
        System.out.println("Task 4");
        printArray(getTargetArray());
        printArray(getIncreasedArray());
        // task 5
        System.out.println("Task 5");
        printArray(getTargetArray());
        getChange();
        // task 6
        System.out.println("Task 6");
        printArray(getTargetArray());
        printSameElements();
    } /*This function calls all functions below*/

    private int[] getTargetArray() {
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = (min_border + (int)(Math.random() * ((max_border - min_border) + 1)));
        }
        System.out.println("Array: ");
        return targetArray;
    }  /* Fills array by random values from -10 to 10 */

    private void printArray(int [] array) {
            /*System.out.println("Array: ");*/
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    } /* Print array */

    private int[] changeMinAndMax() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_index = 0;
        int min_index = 0;
        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i] < 0 && targetArray[i] > max) {
                max = targetArray[i];
                max_index = i;
            }
            if (targetArray[i] > 0 && targetArray[i] < min) {
                min = targetArray[i];
                min_index = i;
            }
        }
        /*System.out.println(max + " " + min);*/
        targetArray[min_index] = max;
        targetArray[max_index] = min;
        System.out.println("Changed min and max:");
        return targetArray;
    } /* Swaps maximum negative and minimum positive elements*/

    private void getSumOfEvenElements() {
        int sumOfElements = 0;
        for (int i = 1; i < targetArray.length; i += 2) //it can starts from i=0;
        {
            sumOfElements += targetArray[i];
        }
        System.out.println("Sum of even elements: " + sumOfElements);
    } /*Gets sum of all elements which placed on pairs places */

    private int[] replaceNegativeElements() {
        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i] < 0) {
                targetArray[i] = 0;
            }
        }
        System.out.println("Replaced negative elements; ");
        return targetArray;
    } /*Replaces all negative elements to zero value*/

    private int[] getIncreasedArray() {
        for (int i = 0; i < targetArray.length-1; i++) {
            if (targetArray[i] > 0 && targetArray[i+1] < 0) {
                targetArray[i] *= 3;
            }
        }
        System.out.println("Increased positive elements: ");
        return targetArray;
    } /*Increases every positive element in three times*/

    private void getChange() {
        int sum = 0;
        int min = targetArray[0];
        double change = 0;
        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i] < min) {
                min = targetArray[i];
            }
            sum += targetArray[i];
        }
        change = ((sum/2) - min);
        System.out.println("Shange between arithmetic avarage and minimum element is: " + change);
    } /*Gets change between arithmetic avarage and minimum element*/

    private void printSameElements() {
        System.out.println("The same elements: ");
        for (int i = 0; i < targetArray.length; i++) {
            for (int j = i+1; j < targetArray.length; j++) {
                if (targetArray[i] == targetArray[j]) {
                    if (i%2 != 0) {
                        System.out.print(targetArray[i] + " ");
                    }
                }
            }
        }
    } /*Print the same elements which situated on odd places*/
}


