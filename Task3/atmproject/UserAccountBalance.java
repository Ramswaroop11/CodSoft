
package atmproject;

//class to manage user's bank account balance
public class UserAccountBalance {
 private double accountBalance = 10000;//initial balance is 10000

 // getter method to retrieve account balance
 public double getAccountBalance() {
     return accountBalance;
 }

 // setter method to update account balance
 public void setAccountBalance(double accountBalance) {
     this.accountBalance = accountBalance;
 }

 // main method to initiate the ATM interface
 public static void main(String[] args) {
     ATMinterface atm = new ATMinterface();
     atm.atmInterface();
 }
}

