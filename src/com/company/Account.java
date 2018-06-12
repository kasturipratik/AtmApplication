package com.company;

import java.util.HashMap;

public class Account {

    private String userName;
    private double balance;
    private int pin;
    private double withdraw;
    private double deposit;
    // hashmap to store account number and pin as key and value respectively
    HashMap<String, Integer> account = new HashMap<>();
    /*
        getters and setters for all the variables
    */


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public HashMap<String, Integer> getAccount() {
        return account;
    }

    public void setAccount(HashMap<String, Integer> account) {
        this.account = account;
    }

    /*

        constructor
    */
    public Account(){
        // adding values to the hashmap
        account.put("1", 1);
        account.put("2",2);
        account.put("3",3);
        balance = 500;
    }

    // returning the balance after calculation
    public double balance(){

        balance = balance - withdraw + deposit;
        return balance;
    }


}
