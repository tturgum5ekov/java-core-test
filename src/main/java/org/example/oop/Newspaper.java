package org.example.oop;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Newspaper)) return false;
        if (!super.equals(obj)) return false;
        Newspaper newspaper = (Newspaper) obj;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public String toString() {
        return super.toString() + ", publicationDay=" + publicationDay;
    }
}
