package factory;

import models.AccountAble;
import models.CheckingAccount;
import models.SavingsAccount;

import java.util.ArrayList;
import java.util.Random;

public class AccountFactory implements AbstractFactory{

    private ArrayList<SavingsAccount> savingsAccounts = new ArrayList();

    private ArrayList<CheckingAccount> checkingAccounts = new ArrayList();


    public void addAccount(SavingsAccount account){
        savingsAccounts.add(account);
    }

    public void addAccount(CheckingAccount account){
        checkingAccounts.add(account);
    }

    public boolean TransferFunds(AccountAble withdrawAccount, AccountAble depositAccount, Long amount){
        if(withdrawAccount.withdraw(amount)){
            depositAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public void updateAccountList(SavingsAccount account){
        for (SavingsAccount listedaccount :this.savingsAccounts) {
            if(listedaccount.getAccountNumber().equals(account.getAccountNumber())){
                listedaccount = account;
            }
        }
    }

    public void updateAccountList(CheckingAccount account){
        for (CheckingAccount listedaccount :this.checkingAccounts) {
            if(listedaccount.getAccountNumber() == account.getAccountNumber()){
                listedaccount = account;
            }
        }
    }

    @Override
    public AccountAble create(String choice) {
        return CreateAccount.create(choice);
    }


    private static class CreateAccount {
        public static AccountAble create(String choice) {
            Random random = new Random();
            switch (choice) {
                case "checking":
                    return new CheckingAccount();
                case "saving":
                    return new SavingsAccount();
                default:
                    return null;
            }
        }
    }
}
