package Lesson_1;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = sc.nextInt();

        // Вычисление n-ого треугольного числа
        int triangularNum = 0;
        for (int i = 1; i <= n; i++) {
            triangularNum += i;
        }
        System.out.println("n-ое треугольное число: " + triangularNum);

        // Вычисление факториала n
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("n! = " + factorial);
        sc.close();
    }
}