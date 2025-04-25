package org.example.oop;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Magazine)) return false;
        if (!super.equals(obj)) return false;
        Magazine magazine = (Magazine) obj;
        return IssueNumber == magazine.IssueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IssueNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", IssueNumber=" + IssueNumber;
    }
}
