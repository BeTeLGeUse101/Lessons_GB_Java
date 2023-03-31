//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task_2 {
    private static final Logger LOGGER = Logger.getLogger(Task_2.class.getName());

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 12, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        try {
            FileHandler handler = new FileHandler("Lesson_2/log_task2.txt");
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);

            LOGGER.log(Level.INFO, "Исходный массив: " + Arrays.toString(arr));

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        LOGGER.log(Level.INFO, String.format("Итерация {%d} {%d} - {%s}", i, j, Arrays.toString(arr)));
                    }
                }
            }

            handler.close();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ошибка записи в лог-файл: ", e);
        }
    }
}