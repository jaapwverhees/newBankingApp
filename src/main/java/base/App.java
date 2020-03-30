package base;

import factory.AccountFactory;
import models.CheckingAccount;
import models.SavingsAccount;
import sun.applet.Main;

public class App {
    public static void main(String[] args) {

        AccountFactory bank = new AccountFactory();
        CheckingAccount account1 = (CheckingAccount) bank.create("checking");
        SavingsAccount account2 = (SavingsAccount) bank.create("checking");
    }
}
