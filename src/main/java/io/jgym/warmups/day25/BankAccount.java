package io.jgym.warmups.day25;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        deposit(-amount);
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void transferTo(BankAccount recipient, double amount) {
        synchronized (this) {
            synchronized (recipient) {
                withdraw(amount);
                recipient.deposit(amount);
            }
        }
    }
}
