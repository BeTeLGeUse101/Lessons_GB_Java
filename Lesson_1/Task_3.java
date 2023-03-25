package Lesson_1;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.print("Введите первое число: ");
        num1 = scan.nextDouble();

        System.out.print("Введите оператор (+, -, *, /): ");
        operator = scan.next().charAt(0);

        System.out.print("Введите второе число: ");
        num2 = scan.nextDouble();

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.printf("%.2f + %.2f = %.2f", num1, num2, result);
                break;

            case '-':
                result = num1 - num2;
                System.out.printf("%.2f - %.2f = %.2f", num1, num2, result);
                break;

            case '*':
                result = num1 * num2;
                System.out.printf("%.2f * %.2f = %.2f", num1, num2, result);
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Деление на 0 невозможно");
                    break;
                }
                result = num1 / num2;
                System.out.printf("%.2f / %.2f = %.2f", num1, num2, result);
                break;

            default:
                System.out.println("Неправильный оператор");
                break;
        }

        // Закрываем сканер
        scan.close();
    }
}