package org.example.oop;

class Book {
    String title;
    String author;
    int pages;

    void read() {
        System.out.println("Вы читаете книгу '" + title + "' авторства " + author + ".");
    }
}

public class Task1 {
    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Война и мир";
        book.author = "Лев Толстой";

        book.read();
    }
}
