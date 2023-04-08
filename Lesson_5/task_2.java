//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.*;

public class task_2 {
    public static void main(String[] args) {
        List<String> names = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", 
                                     "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", 
                                     "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", 
                                     "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");
        Map<String, Integer> countMap = new HashMap<>();
        
        for (String name : names) {
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        Collections.sort(sortedList, Map.Entry.<String, Integer>comparingByValue().reversed());
        
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}