package org.example.oop;

class BookTest {
    String title;
    String author;
    int pages;

    void read() {
        System.out.println("Вы читаете книгу '" + title + "' авторства " + author + ".");
    }
}

public class Task1 {
    public static void main(String[] args) {
        BookTest book = new BookTest();
        book.title = "Война и мир";
        book.author = "Лев Толстой";

        book.read();
    }
}
