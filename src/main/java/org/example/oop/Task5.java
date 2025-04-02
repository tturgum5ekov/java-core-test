package org.example.oop;

abstract class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    abstract void withdraw(double amount);
}


interface PrintableTest {
    void printInfo();
}


class SavingAccount extends Account implements PrintableTest {
    public SavingAccount(double balance) {
        super(balance);
    }
    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    @Override
    public void printInfo() {
        System.out.println("Balance: " + balance);
    }
}


class CreditAccount extends Account implements PrintableTest {
    double credit;

    public CreditAccount(double balance, double credit) {
        super(balance);
        this.credit = credit;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= credit + balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    @Override
    public void printInfo() {
        System.out.println("Balance: " + balance + "\nCredit: " + credit);
    }
}


public class Task5 {
    public static void main(String[] args) {
        SavingAccount saving = new SavingAccount(500);
        CreditAccount credit = new CreditAccount(500, 100);

        saving.withdraw(500);
        saving.printInfo();
        saving.deposit(100);
        saving.printInfo();

        credit.withdraw(601);
        credit.printInfo();
    }
}
