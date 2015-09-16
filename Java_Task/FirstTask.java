package com.epam.oksana_yusyna.java.lesson_1.task_1;

/**
 * Created by Oksana_Yusyna on 9/11/2015.
 */
/**
 * Oksana Yusyna MainClass*/
public class FirstTask {
    public static void main (String [] args) {
        FirstTask task = new FirstTask();
        task.startApplication();

    }

    public void startApplication() {
        //Task 1
        WorkWithArray array = new WorkWithArray();
        array.startWorkWithArray();

        //Task 2
        WorkWithString string = new WorkWithString();
        string.startWorkWithString();

        //Task 3
        CalculateClass calc = new CalculateClass();
        calc.letsCalculate();
    }
}



