package org.example.basics;

import java.util.Scanner;

public class JavaBasicsFinalTask {
    public static void main(String[] args) {
        String menu = """
                === Меню ===
                    [1] - Добавить контакт
                    [2] - Вывести список контактов
                    [3] - Найти контакт
                    [4] - Удалить контакт
                    [0] - Выйти
                """;
        Scanner scanner = new Scanner(System.in);
        final int SIZE_CONTACT_BOOK = 2;
        String[] names = new String[SIZE_CONTACT_BOOK];
        String[] numbers = new String[SIZE_CONTACT_BOOK];
        int contactCount = 0;
        int choice;

        do {
            System.out.println();
            System.out.print(menu);
            System.out.print("Ваш выбор: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ошибка! Введите число (номер пункта меню): ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            String name;
            String number;

            System.out.println();
            switch (choice) {
                case 1:
                    if (contactCount >= SIZE_CONTACT_BOOK) {
                        System.out.println("Телефонная книга заполнена! Максивальное количество контактов - " + SIZE_CONTACT_BOOK);
                    } else {
                        System.out.println("=== Добавление нового контакта ===");
                        System.out.print("Введите имя: ");
                        name = scanner.nextLine().trim();

                        System.out.print("Введите номер телефона: ");
                        number = scanner.nextLine().trim();

                        if (name.isEmpty() || number.isEmpty()) {
                            System.out.println("Ошибка: Имя и номер телефона не могут быть пустыми!");
                            continue;
                        }

                        names[contactCount] = name;
                        numbers[contactCount] = number;
                        contactCount++;

                        System.out.println("Контакт - " + name + " успешно добавлен!");
                    }
                    break;

                case 2:
                    System.out.println("=== Список всех контактов ===");
                    if (contactCount == 0) {
                        System.out.println("Список пуст!");
                    } else {
                        for (int i = 0; i < contactCount; i++) {
                            System.out.println(i + 1 + ". " + names[i] + " - " + numbers[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("=== Поиск контакта ===");
                    System.out.print("Имя для поиска: ");
                    name = scanner.nextLine().trim();
                    int findIndexContact = -1;

                    for (int i = 0; i < contactCount; i++) {
                        if (names[i].equals(name)) {
                            findIndexContact = i;
                            break;
                        }
                    }

                    if (findIndexContact != -1) {
                        System.out.println("Телефон " + " " + name + ": " + numbers[findIndexContact]);

                    } else {
                        System.out.println("Контакт не найден!");
                    }

                    break;

                case 4:
                    System.out.println("=== Удаление контакта ===");
                    System.out.print("Введите имя: ");
                    name = scanner.nextLine();
                    int index = -1;

                    for (int i = 0; i < contactCount; i++) {
                        if (names[i].equals(name)) {
                            index = i;
                        }
                    }

                    if (index != -1) {
                        for (int i = index; i < contactCount - 1; i++) {
                            names[i] = names[i + 1];
                            numbers[i] = numbers[i + 1];
                        }

                        names[contactCount - 1] = null;
                        numbers[contactCount - 1] = null;
                        contactCount--;
                        System.out.println("Контакт - " + name +  " удален!");
                    } else {
                        System.out.println("Контакт не найден!");
                    }
                    break;

                case 0:
                    System.out.println("=== Программа завершена ===");
                    break;

                default:
                    System.out.println("Выбран не верный пункт в меню!");
                    break;
            }
        } while (choice != 0);
    }
}
