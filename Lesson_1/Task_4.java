package Lesson_1;

public class Task_4 {
    public static void main(String[] args) {
        boolean foundSolution = false;

        for (int q = 0; q <= 9; q++) {
            for (int w = 0; w <= 9; w++) {
                for (int e = 0; e <= 9; e++) {
                    int left = 20 + q * 10 + w;
                    int right = e * 10 + 9;
                    if (left == right) {
                        System.out.printf("%d%d + %d5 = %d9\n", q, w, e, left / 10);
                        foundSolution = true;
                    }
                }
            }
        }

        if (!foundSolution) {
            System.out.println("Решение не найдено");
        }
    }
}