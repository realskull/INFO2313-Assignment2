// Version History:
// v1.0 - Initial draft with core functionality.
// v2.0 - Improved error handling (System.err for validation), added combine() null check, and refined inline documentation.
//
// AI Use Declaration:
// I declare that this assignment was completed with the assistance of generative AI tools like ChatGPT
// to debug issues and bugs. I have also used GitHub Copilot integrated inside my VSCode IDE to auto-complete
// certain parts to save time.
//
// Additional resources such as online documentation (Oracle Java docs and Gemini summarized Google search)
// and StackOverflow were also consulted to enhance my understanding of Java programming concepts.

package assignment2;

import java.util.Date;


//The Account class models a simple bank account with basic operations.

public class Account {
    // Private data fields as we do not want other classes to modify these directly.
    // These fields are initialized to default values.
    private int accountNum = 0;
    private String accountName = "none";
    private double balance = 0.0;
    private int numTransactions = 0;
    private Date dateCreated;


    //No-argument constructor initializes default values and sets creation date as today.

    public Account() {
        this.dateCreated = new Date();
    }


    //Constructor that sets account number and name.

    public Account(int accountNum, String accountName) {
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.dateCreated = new Date();
    }

    // Accessors and mutators for accountNum and accountName
    public int getAccountNum() {
        return accountNum;
    }
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    // Accessors for balance and dateCreated
    public double getBalance() {
        return balance;
    }
    public Date getDateCreated() {
        return dateCreated;
    }


    //Deposits a positive amount into the account and increments transaction count.
    public void deposit(double amount) {
        if (amount <= 0) {
            System.err.println("[Error] Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        numTransactions++;
    }

    //Withdraws a positive amount if sufficient funds exist and increments transaction count.

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.err.println("[Error] Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.err.println("[Error] Insufficient funds. Cannot withdraw " + amount);
            return;
        }
        balance -= amount;
        numTransactions++;
    }

    //Displays formatted account information to standard output.
    
    public void displayAccountInfo() {
        System.out.println("Account num: " + accountNum);
        System.out.println("Account name: " + accountName);
        System.out.printf("Balance: %.2f CAD%n", balance);
        System.out.println(numTransactions + " transactions since created at " + dateCreated);
    }

    
    //Combines this account with another by summing balances and transactions.
    //Does not modify the otherAccount; prints a warning if otherAccount is null.
     
    public void combine(Account otherAccount) {
        if (otherAccount == null) {
            System.err.println("[Warning] Cannot combine with a null account.");
            return;
        }
        balance += otherAccount.balance;
        numTransactions += otherAccount.numTransactions;
    }
}
