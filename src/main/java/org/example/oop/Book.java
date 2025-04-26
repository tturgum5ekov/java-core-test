package org.example.oop;

import java.util.Objects;

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
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        if (!super.equals(obj)) return false;
        Book book = (Book) obj;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN=" + ISBN;
    }
}