//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package Lesson_3;

import java.util.ArrayList;
import java.util.Random;

public class Task_3 {
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int randomNum = random.nextInt(100) + 1;
            numbers.add(randomNum);
        }

        int min = numbers.get(0);
        int max = numbers.get(0);
        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int currentValue = numbers.get(i);
            if (currentValue < min) {
                min = currentValue;
            }
            if (currentValue > max) {
                max = currentValue;
            }
            sum += currentValue;
        }
        double avg = (double) sum / numbers.size();

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }
}