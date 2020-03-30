package factory;

import models.AccountAble;
import models.CheckingAccount;
import models.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountFactoryTest {

    SavingsAccount account1;
    CheckingAccount account2;
    CheckingAccount account3;
    AccountFactory accountFactory;


    @BeforeEach
    void setUp() {
        account1 = new SavingsAccount(UUID.randomUUID());
        account1.deposit(2000L);
        account2 = new CheckingAccount(UUID.randomUUID());
        account2.deposit(2000L);
        account3 = new CheckingAccount(UUID.randomUUID());
        accountFactory = new AccountFactory();
        accountFactory.addAccount(account3);
    }

    @Test
    void addAccount() {
        //TODO could maybe use mocking. defacto not useful, reaction can be predicted
        accountFactory.addAccount(account1);
        accountFactory.addAccount(account2);
        AccountAble testAccount1 = accountFactory.getAccount(account1.getAccountNumber());
        AccountAble testAccount2 = accountFactory.getAccount(account2.getAccountNumber());
        assertEquals(testAccount1, account1);
        assertEquals(testAccount2, account2);
    }

    @Test
    void getAccount() {
        //assert that the correct account is returned
        assertEquals(account3, accountFactory.getAccount(account3.getAccountNumber()));
        //assert that nothing is returned, account is not in the list.
        assertNull(accountFactory.getAccount(new SavingsAccount(UUID.randomUUID()).getAccountNumber()));
    }

    @Test
    void transferAllOfFundIsValid() {
        assertTrue(accountFactory.TransferFunds(account1, account2, 2000L));
    }

    @Test
    void transferValidAmount() {
        assertTrue(accountFactory.TransferFunds(account1, account2, 1000L));
    }

    @Test
    void updateAccountList() {
        //account field updated to check
        account3.deposit(1000L);
        //assert that this account that is not in the list
        SavingsAccount account = new SavingsAccount(UUID.randomUUID());
        assertFalse(accountFactory.updateAccountList(account));
        //assert that account is in the list
        assertTrue(accountFactory.updateAccountList(account3));
        //assert that the reset value is present in the list
        assertEquals(1000L, accountFactory.getAccount(account3.getAccountNumber()).getBalance());
    }

    @Test
    void create() {
        //assert that SavingsAccount is created
        assertTrue(accountFactory.create("saving") instanceof SavingsAccount);
        //assert that CheckingsAccount is created
        assertTrue(accountFactory.create("checking") instanceof CheckingAccount);
        //Assert that Something is created
        assertNotNull(accountFactory.create("checking"));
        assertNotNull(accountFactory.create("saving"));
        //assert that input string is invalid, and nothing is created
        assertNull(accountFactory.create("null"));
    }
}