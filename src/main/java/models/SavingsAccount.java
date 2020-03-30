package models;

import java.util.UUID;

public class SavingsAccount implements AccountAble {
    //interest rate is the same for all SavingAccounts
    private static final double interestRate = 0.5;
    private UUID accountNumber;
    private Long balance;

    public SavingsAccount(UUID uuid) {
        this.accountNumber = uuid;
        //during creation balance is always zero
        this.balance = 0L;
    }

    public static double getInterestRate() {
        return interestRate;
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
        return String.format("accountNumber: %s\nbalance: %s\nintressrate: %s", this.accountNumber, this.balance, interestRate);
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

}

