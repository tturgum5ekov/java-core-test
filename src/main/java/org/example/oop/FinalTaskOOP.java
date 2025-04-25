package org.example.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;

public class FinalTaskOOP {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String menu = """
                === Меню ===
                    [1] - Добавить новую публикацию
                    [2] - Вывести список всех публикаций
                    [3] - Поиск публикаций по автору
                    [4] - Вывести общее количество публикаций
                    [0] - Выйти
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
                    int choiceType;
                    System.out.println("""
                    === Выберите тип публикации ===
                        [1] - Книга
                        [2] - Журнал
                        [3] - Газета
                        [0] - Вернуться в меню
                    """);
                    System.out.print("Ваш выбор: ");

                    while (!scanner.hasNextInt()) {
                        System.out.print("Ошибка! Введите число (номер пункта меню): ");
                        scanner.next();
                    }

                    choiceType = scanner.nextInt();
                    scanner.nextLine();

                    if (choiceType != 0) {
                        Publication publication = null;

                        System.out.print("Введите название: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Введите автора: ");
                        String author = scanner.nextLine().trim();

                        int year = 0;
                        while (true) {
                            try {
                                System.out.print("Введите год: ");
                                year = Integer.parseInt(scanner.nextLine().trim());

                                if (year <= 2025 && year > 0) {
                                    break;
                                } else {
                                    System.out.println("Ошибка! Введите корректный год.");
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка! Введите корректный год (число).");
                            }
                        }

                        switch (choiceType) {
                            case 1:
                                System.out.print("Введите ISBN: ");
                                String ISBN = scanner.nextLine().trim();
                                publication = new Book(title, author, year, ISBN);
                                break;

                            case 2:
                                System.out.print("Введите номер издания: ");
                                int issueNumber = Integer.parseInt(scanner.nextLine().trim());
                                publication = new Magazine(title, author, year, issueNumber);
                                break;

                            case 3:
                                System.out.print("Введите день издания: ");
                                String publicationDay = scanner.nextLine().trim();
                                publication = new Newspaper(title, author, year, publicationDay);
                                break;

                            default:
                                System.out.println("Ошибка! Выбран неверный тип публикации!");
                                break;
                        }

                        if (publication != null) {
                            library.addPublication(publication);
                            System.out.println("Публикация успешно добавлена!");
                        }
                    }

                    break;

                case 2:
                    System.out.println("=== Спиисок всех публикаций ===");
                    library.listPublications();

                    break;

                case 3:
                    System.out.println("=== Поиск книг по автору ===");
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine().trim();
                    library.searchByAuthor(author);

                    break;

                case 4:
                    System.out.println("=== Общее количество публикаций ===");
                    System.out.println("Количество: " + Publication.getPublicationCount());

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
