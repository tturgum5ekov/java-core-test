package org.example.exceptions;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        String menu = """
                === Меню ===
                    [1] - Вывести каталог
                    [2] - Добавить книгу
                    [3] - Выдать книгу
                    [4] - Вернуть книгу
                    [0] - Выйти из приложения
                """;

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

            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("=== Каталог книг ===");
                    library.listBooks();

                    break;

                case 2:
                    System.out.println("=== Добавить книгу ===");

                    System.out.print("Введите название: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите количество копий: ");
                    int availableCopies = scanner.nextInt();

                    library.addBook(name, author, availableCopies);

                    break;

                case 3:
                    System.out.println("=== Выдача книги ===");
                    System.out.print("Введите название: ");
                    String titleTake = scanner.nextLine();

                    try {
                        library.takeBook(titleTake);
                    } catch (NoAvailableCopiesException | ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("=== Возврат книги ===");
                    System.out.print("Введите название: ");
                    String titleReturn = scanner.nextLine();

                    try {
                        library.returnBook(titleReturn);
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("=== Завершение работы программы ===");
                    break;

                default:
                    System.out.println("Ошибка! Выбран неверный пункт в меню!");
                    break;
            }
        } while (choice != 0);
    }
}
