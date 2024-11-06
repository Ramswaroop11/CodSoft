package atmproject;

import java.util.Scanner;

public class ATMinterface {
    // Instance of UserAccountBalance to manage the user's balance
    UserAccountBalance u = new UserAccountBalance();
    Scanner sc = new Scanner(System.in); // Scanner for user input

    // Main method for the ATM interface
    void atmInterface() {
        System.out.println("-------Welcome To ATM--------");
        System.out.println();
        System.out.println("Please Enter your 10 Digit Card Number:");
        long cardNo = sc.nextLong(); // Get card number from user As we haven't saved any card details it checks with digits only
        long res = Digit.digitCount(cardNo); // Validate card number length
        if (res == 10) {
            System.out.println("Enter Your 6 Digit Pin: ");
            int pin = sc.nextInt(); // Get PIN from user as we haven't saved any pin details it checks with digits only
            int count = Digit.digitCount(pin); // Validate PIN length
            if (count == 6) {
                showServices(); // Show available ATM services
            } else {
                System.out.println("Pin Number Should Be 6 Digit Try Again..");
                atmInterface(); // Restart if PIN is invalid
            }
        } else {
            System.out.println("Card Number Should Be 10 Digit Try Again..");
            atmInterface(); // Restart if card number is invalid
        }
    }

    // Display available services
    void showServices() {
        System.out.println("Our Services");
        System.out.println("------------");
        System.out.println("1. Withdraw Cash.");
        System.out.println("2. Deposit Amount.");
        System.out.println("3. Check Balance.");
        System.out.println("4. Exit.");
        System.out.print("Enter Option: ");
        int opt = sc.nextInt(); // Get user option
        switch (opt) {
            case 1:
                withdraw(); // Call withdraw method
                break;
            case 2:
                deposit(); // Call deposit method
                break;
            case 3:
                checkBalance(); // Call check balance method
                break;
            case 4:
                exit(); // exit the services
                return; 
            default:// handle invalid option
                System.out.println("Invalid option. Please try again.");
                System.out.println();
                atmInterface();
                break; 
            	
        }
    }

    // Method to withdraw cash
    void withdraw() {
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble(); // Get withdrawal amount from user
        double currentBalance = u.getAccountBalance(); // Get current balance
        if (amount <= currentBalance) { // Check if sufficient balance exists
            u.setAccountBalance(currentBalance - amount); // Update balance
            System.out.println("Withdraw Successful.");
            System.out.println("Would You Like To Display Balance Amount Yes/No :");
            String res = sc.next();
            if (res.equalsIgnoreCase("yes")) {
                checkBalance(); // Display balance if user wants to see it
            } else {
                System.out.println("Thank You Visit Again.");
            }
        } else {
            System.out.println("Insufficient Balance."); // Inform user of insufficient funds
        }
    }

    // Method to deposit cash
    void deposit() {
        System.out.print("Enter Amount: ");
        double deposit = sc.nextDouble(); // Get deposit amount from user
        if (deposit > 0) { // Check if deposit is valid
            double currentBalance = u.getAccountBalance(); // Get current balance
            u.setAccountBalance(currentBalance + deposit); // Update balance
            System.out.println("Deposit Successful!");
            System.out.println("Would You Like To Display Balance Yes/No:");
            String res = sc.next();
            if (res.equalsIgnoreCase("yes")) {
                checkBalance(); // Display balance if user wants to see it
            } else {
                System.out.println("Thank You Visit Again.");
            }
        } else {
            System.out.println("Enter valid Amount."); // Inform user if deposit is invalid
        }
    }

    // Method to check current balance
    void checkBalance() {
        System.out.println("Your Balance Is: " + u.getAccountBalance()); // Display current balance
        exit(); // Optionally exit after checking balance
    }

    // Method to handle exiting the service
    void exit() {
        System.out.println("Thank You Visit Again..");
        System.out.println();
        // Pause for 5 seconds before returning to the main menu
        try {
             Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle interruption exception
        }
        atmInterface(); // Restart ATM interface
    }
}

