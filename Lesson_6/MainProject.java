/*Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.

Создать множество ноутбуков.

Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. Например:

“Введите цифру, соответствующую необходимому критерию:

1 - ОЗУ

2 - Объём ЖД

3 - Операционная система

4 - Цвет …

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainProject {

    public static void FilterLaptops(HashSet<Laptop> laptops) {
        HashSet<Laptop> timeBox = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
    
        // Создаем карту критериев фильтрации
        Map<Integer, String> filterCriteria = new HashMap<>();
        filterCriteria.put(1, "Объём оперативной памяти");
        filterCriteria.put(2, "Объём накопителя");
        filterCriteria.put(3, "Операционная система");
        filterCriteria.put(4, "Марка ноутбука");
        filterCriteria.put(5, "Сенсорный экран(Yes/No)");
        filterCriteria.put(6, "Цена ноутбука");
    
        // Запрашиваем у пользователя критерии фильтрации
        System.out.print("Введите цифру, соответствующую необходимому критерию:");
        System.out.println();
        for (Map.Entry<Integer, String> entry : filterCriteria.entrySet()) {
            System.out.printf("%d - %s%n", entry.getKey(), entry.getValue());
        }
        System.out.print("Ввод: ");
        String input = scanner.nextLine();
        System.out.println();
        String[] filterCriteriaArr = input.split("\\s+");
        Map<String, String> filterParams = new HashMap<>();
        for (String criteria : filterCriteriaArr) {
            System.out.printf("Введите минимальное значение для критерия \"%s\":%n", filterCriteria.get(Integer.parseInt(criteria)));
            System.out.print("Ввод: ");
            String value = scanner.nextLine();
            filterParams.put(filterCriteria.get(Integer.parseInt(criteria)), value);
        }
    
        // Фильтруем ноутбуки и выводим результат
        System.out.println("Найденные ноутбуки:");
        System.out.println();
        for (Laptop laptop : laptops) {
            boolean matchesFilter = true;
            for (Map.Entry<String, String> entry : filterParams.entrySet()) {
                String filterKey = entry.getKey();
                String filterValue = entry.getValue();
                switch (filterKey) {
                    case "Объём оперативной памяти":
                        if (laptop.getRAM() < Integer.parseInt(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case "Объём накопителя":
                        if (laptop.getStorage() < Integer.parseInt(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case "Операционная система":
                        if (!laptop.getOpSys().equals(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case "Марка ноутбука":
                        if (!laptop.getBrand().equals(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case "Сенсорный экран(Yes/No)":
                        if (!laptop.getIsTouchscreen().equals(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    case "Цена ноутбука":
                        if (laptop.getPrice() < Double.parseDouble(filterValue)) {
                            matchesFilter = false;
                        }
                        break;
                    default:
                        System.out.println("Неизвестный критерий фильтрации: " + filterKey);
                }
            }
            if (matchesFilter) {
                System.out.println(laptop);
                timeBox.add(laptop);
                System.out.println();
            }
        }
        System.out.println("Всего найдено ноутбуков: " + timeBox.size());
        scanner.close();
    }
        
    public static HashSet<Laptop> CreatLaptopInfo(int quan) {

        //Создаём случайную информацию о каждом ноутбуке и записываем в класс Laptop
        Random ran = new Random();
        String[] difM = { "Leopard", "Creator", "Modern", "Stealth", "Summit", "Raider", "Katana", "Alpha" };
        String[] procesB = { "AMD", "INTEL" };
        ArrayList<String> serials = new ArrayList<>();
        ArrayList<String> models = new ArrayList<>();
        ArrayList<String> brands = new ArrayList<>(Arrays.asList("MSI", "PALIT", "ASUS", "GIGABYTE", "LENOVO", "ACER", "APPLE", "DELL", "HP", "HUAWEI", "HONOR"));
        ArrayList<String> processors = new ArrayList<>(Arrays.asList());
        ArrayList<Integer> RAMs = new ArrayList<>(Arrays.asList(4, 6, 8, 16, 32, 64));
        ArrayList<Integer> storages = new ArrayList<>(Arrays.asList(128, 256, 512, 1000, 2000));
        ArrayList<String> isTouchscreen = new ArrayList<>(Arrays.asList("Yes", "No"));
        ArrayList<String> opSyses = new ArrayList<>(Arrays.asList("Windows", "MAC", "Linux"));

        for (int i = 0; i < 100; i++) {
            serials.add(String.format("GP%dUH-%dUS", ran.nextInt(1000, 10000), ran.nextInt(100, 1000)));
            models.add(String.format("GP%d %s %dUH", ran.nextInt(10, 100), difM[ran.nextInt(0, difM.length)],
                    ran.nextInt(1, 10)));
            processors.add(String.format("%s A%d %d00M", procesB[ran.nextInt(0, 2)], ran.nextInt(6, 10),
                    ran.nextInt(44, 120)));
        }

        HashSet<Laptop> localDataLap = new HashSet<>();

        for (int i = 0; i < quan; i++) {

            double price = ran.nextDouble(55000, 60000);
            String brand = brands.get(ran.nextInt(brands.size()));

            if (brand.equals("MSI") || brand.equals("GIGABYTE") || brand.equals("APPLE"))
                price += ran.nextDouble(10000, 15000);
            else
                price += ran.nextDouble(3000, 4000);

            String proTest = "INTEL";
            String processor = processors.get(ran.nextInt(processors.size()));

            if (processor.contains(proTest))
                price += ran.nextDouble(9000, 12000);
            else
                price += ran.nextDouble(2000, 3000);

            Integer RAM = RAMs.get(ran.nextInt(RAMs.size()));

            if (RAM <= 6)
                price += ran.nextDouble(1000, 2000);
            else
                price += ran.nextDouble(9000, 10000);

            Integer storage = storages.get(ran.nextInt(storages.size()));

            if (storage >= 1000)
                price += ran.nextDouble(4000, 7000);
            else
                price += ran.nextDouble(1000, 2000);

            String opSys = opSyses.get(ran.nextInt(opSyses.size()));

            if (brand.equals("APPLE")) {
                opSys = opSyses.get(1);
                price += ran.nextDouble(20000, 25000);
            }

            if (opSys.equals("MAC") && !brand.equals("APPLE"))
                opSys = opSyses.get(0);

            Laptop lap = new Laptop(serials.get(ran.nextInt(serials.size())), brand,
                    models.get(ran.nextInt(models.size())),
                    ran.nextDouble(7, 14), processor, RAM, storage,
                    isTouchscreen.get(ran.nextInt(isTouchscreen.size())), opSys, price);

            localDataLap.add(lap);
        }

        return localDataLap;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите кол-во ноутбуков: ");
        int quan = Integer.parseInt(scan.nextLine());
        HashSet<Laptop> dataLap = CreatLaptopInfo(quan);

        for (Laptop laptop : dataLap) {
            System.out.println(laptop);
            System.out.println();
        }

        System.out.println("-------------------------------");
        System.out.println("Всего ноутбуков: " + dataLap.size());
        System.out.println();

        FilterLaptops(dataLap);

        scan.close();
    }
}