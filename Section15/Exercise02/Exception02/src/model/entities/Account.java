package model.entities;

import model.exceptions.BalanceException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit (Double value) {
        this.balance += value;
    }

    public void withdraw (Double value) throws BalanceException{
        if (this.balance < value || this.balance == 0) {
            throw new BalanceException("The current balance is not enough to withdraw the required value.");
        }

        if (this.withdrawLimit < value) {
            throw new BalanceException("The amount exceeds the withdraw limit.");
        }
        this.balance -= value;
    }

    @Override
    public String toString() {
        return "New balance: " + this.balance;
    }
}
