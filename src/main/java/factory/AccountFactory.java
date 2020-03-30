package factory;

import models.AccountAble;
import models.CheckingAccount;
import models.SavingsAccount;

import java.util.ArrayList;
import java.util.UUID;

public class AccountFactory implements AbstractFactory<AccountAble> {

    private static ArrayList<AccountAble> accounts = new ArrayList<>();

    public void addAccount(AccountAble account) {
        accounts.add(account);
    }

    public AccountAble getAccount(UUID accountNumber) {
        for (AccountAble account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean TransferFunds(AccountAble withdrawAccount, AccountAble depositAccount, Long amount) {
        return withdrawAccount.withdraw(amount) && depositAccount.deposit(amount);
    }

    public boolean updateAccountList(AccountAble account) {
        for (AccountAble listedaccount : accounts) {
            if (listedaccount.getAccountNumber().equals(account.getAccountNumber())) {
                listedaccount = account;
                return true;
            }
        }
        return false;
    }


    @Override
    public AccountAble create(String choice) {
        return CreateAccount.create(choice);
    }

    private static class CreateAccount {
        public static AccountAble create(String choice) {
            switch (choice) {
                case "checking":
                    return new CheckingAccount(generateUUID());
                case "saving":
                    return new SavingsAccount(generateUUID());
                default:
                    return null;
            }
        }

        //TODO maybe not the place to generate this. on the other hand, IRL this would be handled by the Database.
        private static UUID generateUUID() {
            boolean checker;
            UUID uuid;
            do {
                checker = false;
                uuid = UUID.randomUUID();
                for (AccountAble account : AccountFactory.accounts) {
                    if (account.getAccountNumber().equals(uuid)) {
                        checker = true;
                    }
                }
            }
            while (checker);
            return uuid;
        }
    }
}
