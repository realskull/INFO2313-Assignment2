/*
 Version History:
 v1.0 - Initial draft with core functionality.
 
 AI Use Declaration:
 I declare that this assignment was completed with the assistance of generative AI tools like ChatGPT
 to debug issues and bugs. I have also used Github Copilot integrated inside my VSCode IDE to auto-complete certain parts to save time.

 Additional resources such as online documentation (Oracle java docs and Gemini sumarrized google search) and stackoverflow were also consulted to ehance my understanding of Java programming concepts.
 */
package assignment2;
import java.util.Date;


//Account class is a simple bank account with basic operations.
public class Account {
    // Private data fields
    private int accountNum = 0;
    private String accountName = "none";
    private double balance = 0.0;
    private int numTransactions = 0;
    private Date dateCreated;


    //Default contructor to set date when an account is created.
    public Account() {
        this.dateCreated = new Date();
    }

    //Constructor that sets account number and name.
    public Account(int accountNum, String accountName) {
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.dateCreated = new Date();
    }

    // Getters and Setters
    public int getAccountNum()
    { 
        return accountNum; 
    }
    public void setAccountNum(int accountNum) 
    {
         this.accountNum = accountNum;
    
    }
    public String getAccountName() 
    {
         return accountName; 
    }

    public void setAccountName(String accountName)
    { 
        this.accountName = accountName;
    }


    public double getBalance() 
    { 
        return balance;
    }

    public Date getDateCreated() 
    {
         return dateCreated;
    }


    //Deposits x amount into the account and track transactions.

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            numTransactions++;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    
    //Withdraws amount if we have enough money and increase  transactions by one.
     
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numTransactions++;
        } else {
            System.out.println("Withdrawal amount invalid or exceeds balance.");
        }
    }

    
    //Displays formatted account information.

    public void displayAccountInfo() {
        System.out.println("Account num: " + accountNum);
        System.out.println("Account name: " + accountName);
        System.out.printf("Balance: %.2f CAD%n", balance);
        System.out.println(numTransactions + " transactions since created at " + dateCreated);
    }

    //Combines this account with another by summing balances and transactions.

    public void combine(Account otherAccount) {
        if (otherAccount != null) {
            this.balance += otherAccount.balance;
            this.numTransactions += otherAccount.numTransactions;
        }
    }
}