package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    Library() {
        this.books = new ArrayList<>();
    }

    public void listBooks() {
        if (this.books.isEmpty())
            System.out.println("Каталог пуст!");
        else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ": " + books.get(i));
            }
        }
    }

    public void addBook(String title, String author, int copies) {
        books.add(new Book(title, author, copies));
        System.out.println("Книга добавлена!");
    }

    private Book findBook(String title) throws ItemNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new ItemNotFoundException(title);
    }

    public void takeBook(String title) throws NoAvailableCopiesException, ItemNotFoundException {
            Book book = findBook(title);
            if (book.getAvailableCopies() <= 0) {
                throw new NoAvailableCopiesException(book.getTitle());
            }
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            System.out.println("Книга: " + title + " выдана!");
    }

    public void returnBook(String title) throws ItemNotFoundException {
            Book book = findBook(title);
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            System.out.println("Книга: " + title + " возвращена!");
    }
}
