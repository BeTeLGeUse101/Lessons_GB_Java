//В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int count = 0;
            double num1 = 0, num2 = 0, result = 0;
            char operator = ' ';

            while (true) {
                if (count == 0) {
                    System.out.print("Введите первое число: ");
                    num1 = scan.nextDouble();
                    System.out.print("Отменить последнее действие? yes/no: ");
                    String answer = scan.next();
                    System.out.println();
                    if (answer.equals("yes"))
                        count = 0;
                    else if (answer.equals("no"))
                        count++;

                }
                if (count == 1) {
                    System.out.print("Введите оператор (+, -, *, /): ");
                    operator = scan.next().charAt(0);
                    System.out.print("Отменить последнее действие? yes/no: ");
                    String answer = scan.next();
                    System.out.println();
                    if (answer.equals("yes"))
                        count = 1;
                    else if (answer.equals("no"))
                        count++;

                }
                if (count == 2) {
                    System.out.print("Введите второе число: ");
                    num2 = scan.nextDouble();
                    System.out.print("Отменить последнее действие? yes/no: ");
                    String answer = scan.next();
                    System.out.println();
                    if (answer.equals("yes"))
                        count = 2;
                    else if (answer.equals("no"))
                        count++;

                }
                if (count == 3) {
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
                    count = 0;
                    System.out.println();
                }
            }
        }
    }
}