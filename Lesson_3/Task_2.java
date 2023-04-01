//Пусть дан произвольный список целых чисел, удалить из него чётные числа

package Lesson_3;

import java.util.ArrayList;

public class Task_2 {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 0; i <= 20; i++) {
        numbers.add(i);
    }

    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) % 2 == 0) {
        numbers.remove(i);
        i--;
      }
    }

    System.out.println(numbers);
  }
}