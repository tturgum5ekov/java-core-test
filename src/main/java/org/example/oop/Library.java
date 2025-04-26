package org.example.oop;

import java.util.ArrayList;
import java.util.List;

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
