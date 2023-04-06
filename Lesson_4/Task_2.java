//Реализуйте очередь с помощью LinkedList со следующими методами:
//• enqueue() — помещает элемент в конец очереди,
//• dequeue() — возвращает первый элемент из очереди и удаляет его,
//• first() — возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Task_2 {

    int returnElem = 0;

    private static Queue<Integer> QDF(Queue<Integer> localQlist, Scanner localScan) {
        int returnEl = 0;

        System.out.println("Выберите функцию: \n"
                + "1. Помещает элемент в конец очереди\n"
                + "2. Возвращает первый элемент из очереди и удаляет его\n"
                + "3. Возвращает первый элемент из очереди, не удаляя");

        System.out.print("Номер функции: ");
        int inScan = localScan.nextInt();
        System.out.println();

        if (inScan == 1) {
            System.out.print("Введите новый элемент: ");
            localQlist.add(localScan.nextInt());
        }

        if (inScan == 2) {
            returnEl = localQlist.poll();
            System.out.printf("Элемент '%d' записан и удалён из очереди!", returnEl);
        }

        if (inScan == 3) {
            returnEl = localQlist.element();
            System.out.printf("Элемент '%d' записан!", returnEl);
        }

        return localQlist;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Random rand = new Random();
            Queue<Integer> qList = new LinkedList<>();

            for (int i = 0; i < 10; i++) {
                qList.add(rand.nextInt(100));
            }

            System.out.println(qList);
            System.out.println();

            while (true) {
                qList = QDF(qList, scan);
                System.out.println();
                System.out.print("Измененная очередь: ");
                System.out.println(qList);
                System.out.println();
            }
        }
    }
}