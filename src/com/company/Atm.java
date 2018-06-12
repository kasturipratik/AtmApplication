package com.company;

import java.util.Scanner;

public class Atm{

    /*
        variable declaration for user input and setting values to account class
    */
    private String userName;
    private String accountNumber;
    private int pinNumber;
    private int userInput;

/*
    constructor
*/

    public Atm(){
      
    }

    /*
        methods for user interaction
    */
    public void userInput(){

        /*
            variable declaration
        */
         double deposit,withdrawal;
         boolean condition = false;

         /*
            account method instantiate
         */
         Scanner input = new Scanner(System.in);
         Account transaction = new Account();

         //user name user input request
        System.out.println("Enter your user name");
        userName = input.nextLine();

        //setting the user name to account username
        transaction.setUserName(userName);

        // account number user input request
        System.out.println("Enter your account number");
        accountNumber = input.nextLine();

        //boolean value for deciding the print statement for pin number
        boolean pinCount = true;
        // condition to check if the user input of account number exist in the database or hashmap in out case
        if(transaction.getAccount().containsKey(accountNumber)) {
              //pin number user request
            System.out.println("Enter your pin number");
            pinNumber = input.nextInt();
            input.nextLine();

            // counter for pin number and exit if count is less than 3
            int count = 1;

            //looping to get user pin request if the user pin is not correct
            while (count < 3 ) {
                // condition to check if the user pin equals the account number entered
                if (transaction.getAccount().get(accountNumber) == pinNumber) {

                    //if the condition is met user is prompted to input transaction
                    System.out.println("Welcome: " + transaction.getUserName());
                    System.out.println("Enter 1 to deposit:: 2 to withdraw::" +
                            " 3 to check balance and see transaction details");
                    userInput = input.nextInt();
                    input.nextLine();
                    // deposit condition
                    if (userInput == 1) {
                        System.out.println("Enter deposit amount");
                        deposit = input.nextDouble();
                        input.nextLine();
                        transaction.setDeposit(deposit);
                        condition = true;
                    }
                    //withdrawal condition
                    else if (userInput == 2) {
                        System.out.println("Enter withdrawal amount");
                        withdrawal = input.nextDouble();
                        input.nextLine();
                        transaction.setWithdraw(withdrawal);
                        condition = true;

                    }
                    //balance review condition
                    else if (userInput == 3) {
                        condition = true;
                    }
                    // invalid transaction request
                    else {
                        System.out.println("You entered an invalid entry");
                        condition = false;
                    }

                    // if the transaction was successful, transaction details is printed
                    if (condition) {
                        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("Account Number: " + accountNumber);
                        System.out.println("User Name: " + transaction.getUserName());
                        System.out.println("Initial Balance " + transaction.getBalance());
                        System.out.println("Final Balance: " + transaction.balance());
                        System.out.println("Withdrawals:  " + transaction.getWithdraw());
                        System.out.println("Deposit: " + transaction.getDeposit());
                    }
                    // set the counter to 4 to exit the loop
                    count =4;
                    // set the pin condition true
                    pinCount = true;
                }

// condition to loop to request pin for the account number 3 times
                else if(count <3 && transaction.getAccount().get(accountNumber) != pinNumber) {
                    count++;
                    System.out.println("You Entered a wrong pin: Enter your pin number");
                    pinNumber = input.nextInt();
                    input.nextLine();
                    pinCount = false;
                }
            }
        }
// condition to exit if the user input invalid account number after entering username
        else{
            System.out.println("Your account number does not exist. Thank you for using the system ");
        }

        // condition to lock the account for the user as they entered the pin for 3 times
        if(pinCount == false) {
            System.out.println("You entered wrong pin for more than 3 times. you have been logged out of the system");
        }
        // if transaction is complete a thank you message
        else{
            System.out.println("Thank you for using the system");
        }
    }


}
