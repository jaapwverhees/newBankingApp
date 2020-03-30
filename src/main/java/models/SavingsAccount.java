package models;

import java.util.Random;

public class SavingsAccount implements AccountAble {
    private Long accountNumber;
    private Long balance;
    private static final double intrestRate = 0.5;

    public SavingsAccount() {
        //TODO needs checks and balances
        Random random = new Random();
        this.accountNumber = random.nextLong();
        this.balance = 0L;
    }

    public boolean withdraw(Long amount) {
        if(amount < balance){
            balance = balance - amount;
            return true;
        } else return false;
    }

    public void deposit(Long amount) {
        balance = balance + amount;
    }

    public String ToString(){
        return String.format("accountNumber: %s\nbalance: %s\nintressrate: %s", this.accountNumber, this.balance, intrestRate);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }
}

