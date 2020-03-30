package models;

public interface AccountAble {
    public boolean withdraw(Long amount);
    public void deposit(Long amount);
    public String ToString();
}
