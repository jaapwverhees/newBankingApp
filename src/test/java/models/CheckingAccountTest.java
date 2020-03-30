package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;


public class CheckingAccountTest {

    CheckingAccount account1;
    UUID uuid = UUID.randomUUID();


    @BeforeEach
    void setUp() {
        account1 = new CheckingAccount(uuid);
        account1.deposit(2000L);

    }

    @Test
    void canWithdrawValidAmount() {
        account1.withdraw(1000L);
        Assertions.assertEquals(1000L, account1.getBalance());
    }

    @Test
    void canWithdrawEntireBalance() {
        account1.withdraw(2000L);
        Assertions.assertEquals(0L, account1.getBalance());
    }

    @Test
    void canNOTWithdrawNegativeAmount() {
        Assertions.assertFalse(account1.withdraw(-1000L));
    }
    @Test
    void canNOTWithdrawMoreThenBalance() {
        Assertions.assertFalse(account1.withdraw(-0L));
        Assertions.assertFalse(account1.withdraw(-5000L));
        Assertions.assertEquals(2000L, account1.getBalance());
    }

    @Test
    void canDepositValidAmount() {
        Assertions.assertTrue(account1.deposit(1000L));
    }


    @Test
    void cantDepositInValidAmount() {
        Assertions.assertFalse(account1.deposit(0L));
        Assertions.assertFalse(account1.deposit(-1L));
    }

    @Test
    void testToString() {
        Assertions.assertEquals(String.format("accountNumber: %s\nbalance: 2000", uuid), account1.toString());
    }

    @Test
    void getAccountNumber() {
        Assertions.assertEquals(uuid, account1.getAccountNumber());
    }

    @Test
    void getBalance() {
        Assertions.assertEquals(2000L, account1.getBalance());
    }
}
