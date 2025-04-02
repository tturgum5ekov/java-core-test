package org.example.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;

interface Printable {
    void printDetails();
}

abstract class Publication implements Printable {
    private String title;
    private String author;
    private int year;

    private static int publicationCount = 0;

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        publicationCount++;
    }

    public static int getPublicationCount() {
        return publicationCount;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year
                && Objects.equals(title, that.title)
                && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return getType() + " => title=" + title + ", author=" + author + ", year=" + year;
    }
}

class Book extends Publication {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getType() {
        return "Book";
    }

    @Override
    public void printDetails() {
        System.out.println("Тип: " + getType());
        System.out.println("Название: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год: " + getYear());
        System.out.println("ISBN: " + getISBN());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN=" + ISBN;
    }
}

class Magazine extends Publication {
    private int IssueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.IssueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return IssueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        IssueNumber = issueNumber;
    }

    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {
        System.out.println("Тип: " + getType());
        System.out.println("Название: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год: " + getYear());
        System.out.println("Номер выпуска: " + getIssueNumber());
    }

    @Override
    public String toString() {
        return super.toString() + ", IssueNumber=" + IssueNumber;
    }
}

class Newspaper extends Publication {
    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    public String getType() {
        return "Газета";
    }

    @Override
    public void printDetails() {
        System.out.println("Тип: " + getType());
        System.out.println("Название: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год: " + getYear());
        System.out.println("День издания: " + getPublicationDay());
    }

    @Override
    public String toString() {
        return super.toString() + ", publicationDay=" + publicationDay;
    }
}

class Library {
    private List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<Publication>();
    }

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println("Список публикаций пуст!");
        } else {
            for (int i = 0; i < publications.size(); i++) {
                System.out.println((i + 1) + ") " + publications.get(i));
            }
        }
    }

    public void searchByAuthor(String author) {
        if (author == null) {
            System.out.println("Ошибка! Автор не указан");
        } else {
            for (Publication pub : publications) {
                if (pub.getAuthor().equals(author)) {
                    System.out.println(pub);
                }
            }
        }

    }
}

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
