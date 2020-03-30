package models;

import java.util.Random;

public class CheckingAccount implements AccountAble{
    private Long accountNumber;
    private Long balance;

    public CheckingAccount() {
        //TODO needs checks and balances
        Random random = new Random();
        this.accountNumber = random.nextLong();
        this.balance = 0L;
    }

    public boolean withdraw(Long amount) {
        if(amount < balance){
            balance = balance - amount;
            return true;
        } else return  false;
    }

    public void deposit(Long amount) {
        balance = balance + amount;
    }

    public String ToString(){
        return String.format("accountNumber: %s\nbalance: %s", this.accountNumber, this.balance);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Long getBalance() {
        return balance;
    }
}