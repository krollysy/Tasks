/**
 * Created by Оксана on 23.04.2015.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameJava {
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int low_border = Integer.parseInt(reader.readLine());
        int high_border = Integer.parseInt(reader.readLine());
        int randValue = low_border + (int)(Math.random() * ((high_border - low_border) + low_border));
        System.out.println(randValue);  //проверка
         guessNumber(randValue, low_border, high_border);
    }

    private static void guessNumber(int rand, int start, int end) {

        boolean count = false;

        try {
        while (count == false){
            int input = Integer.parseInt(reader.readLine());
            if (input < start || input > end){
                System.out.println("Out of range:");
                System.out.println("Please enter again from " + start + " to " + input);
                list.add(input);
                getStatistic();
            } else {
                if (input == rand){
                    list.add(input);
                    System.out.println("Congratulations!!! You guessed the number!");
                    System.out.println("The right number is: " + rand);
                    getStatistic();
                    count = true;
                } else if (input < rand){
                    list.add(input);
                    System.out.println("This number is too low.");
                    System.out.println("Please enter again from " + input + " to " + end);
                    getStatistic();
                    guessNumber(rand, input, end);
                } else if (input > rand){
                    list.add(input);
                    System.out.println("This number is too high.");
                    System.out.println("Please enter again from " + start + " to " + input);
                    getStatistic();
                    guessNumber(rand, start, input);
                }
            }
        }
        } catch (Exception e){
            System.out.println("Wrong input data. Try again:");
            guessNumber(rand, start, end);
        }
    }

    private static void getStatistic(){
        for (int i=0; i < list.size(); i++){
            System.out.println("Statistic: " + (i+1) + " - " + list.get(i));
        }
    }
}
