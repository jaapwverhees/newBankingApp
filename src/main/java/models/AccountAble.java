package models;

import java.util.UUID;

public interface AccountAble {
    boolean withdraw(Long amount);

    boolean deposit(Long amount);

    UUID getAccountNumber();

    Long getBalance();
}
