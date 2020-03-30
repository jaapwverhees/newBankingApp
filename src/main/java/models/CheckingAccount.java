package models;

import java.util.UUID;

public class CheckingAccount implements AccountAble {
    private UUID accountNumber;
    private Long balance;

    public CheckingAccount(UUID uuid) {
        this.accountNumber = uuid;
        this.balance = 0L;
    }

    public boolean withdraw(Long amount) {
        //check if amount is positive and less then balance
        if (amount <= 0 || amount > this.balance) return false;

        this.balance = this.balance - amount;
        return true;
    }

    public boolean deposit(Long amount) {
        if (amount <= 0) return false;

        this.balance = this.balance + amount;
        return true;

    }

    public String toString() {
        return String.format("accountNumber: %s\nbalance: %s", this.accountNumber, this.balance);
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }
}