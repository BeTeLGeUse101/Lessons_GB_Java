//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

import java.util.LinkedList;
import java.util.Random;

public class Task_1 {

    public static LinkedList<Integer> UpendList(LinkedList<Integer> localList) {
        LinkedList<Integer> upendlist = new LinkedList<>();

        for (int i = localList.size() - 1; i >= 0; i--) {
            upendlist.add(localList.get(i));
        }

        return upendlist;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(1, 100));
        }

        System.out.println(list);

        System.out.println(UpendList(list));
    }
}