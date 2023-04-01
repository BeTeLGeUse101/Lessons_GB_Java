//Реализовать алгоритм сортировки слиянием

package Lesson_3;

import java.util.Arrays;

public class Task_1 {
    
    public static void sort(int[] arr) {
        // Если в массиве менее двух элементов, он уже отсортирован
        if (arr.length < 2) {
            return;
        }
        
        // Делим массив на две части
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        
        // Рекурсивно сортируем левую и правую части массива
        sort(leftArr);
        sort(rightArr);
        
        // Объединяем отсортированные левую и правую части массива в исходный массив
        merge(arr, leftArr, rightArr);
    }
    
    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        // Создаем переменные-счетчики для каждого массива
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        
        // Создаем временный массив, в который будем складывать элементы
        int[] resultArr = new int[leftArr.length + rightArr.length];
        
        // Пока не достигли конца одного из массивов,
        // выбираем наименьший элемент и помещаем его в временный массив
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                resultArr[resultIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                resultArr[resultIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }
        
        // Копируем оставшиеся элементы из левого массива во временный массив
        while (leftIndex < leftArr.length) {
            resultArr[resultIndex] = leftArr[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        
        // Копируем оставшиеся элементы из правого массива во временный массив
        while (rightIndex < rightArr.length) {
            resultArr[resultIndex] = rightArr[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        
        // Копируем отсортированные элементы из временного массива в исходный массив
        System.arraycopy(resultArr, 0, arr, 0, resultArr.length);
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 4, 7, 1, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}