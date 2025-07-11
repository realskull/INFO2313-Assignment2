package assignment2;

public class TestRobust {
    public static void main(String[] args) {
        System.out.println("=== Starting Robust Test ===");

        // A. Multiple Accounts Setup
        Account a1 = new Account(2001, "Main");
        Account a2 = new Account(2002, "Secondary");
        Account a3 = new Account(2003, "Tertiary");
        Account a4 = new Account(); // Testing default constructor

        // B. Deposit Valid/Invalid
        a1.deposit(1000);
        a1.deposit(-50); // Invalid
        a1.deposit(0);   // Edge

        // C. Withdrawal Valid/Invalid
        a1.withdraw(500);     // Valid
        a1.withdraw(600);     // Overdraw
        a1.withdraw(-10);     // Invalid
        a1.withdraw(0);       // Edge

        // D. Display All
        a1.displayAccountInfo();
        a4.displayAccountInfo();

        // E. Combine accounts with matching and mismatched names
        a2.deposit(3000);
        a3.deposit(2000);
        a2.combine(a3); // Should not combine unless names match

        a3.setAccountName("Secondary");
        a2.combine(a3); // Now should work

        a2.displayAccountInfo();

        // F. Rename and reassign
        a2.setAccountName("Unified");
        a2.setAccountNum(7777);

        // G. High Volume Transactions
        for (int i = 0; i < 1000; i++) {
            a2.deposit(1);
            a2.withdraw(0.5);
        }
        System.out.println("After 1000 small transactions:");
        a2.displayAccountInfo();

        // H. Null or dummy usage (if applicable)
        Account nullAccount = null;
        try {
            nullAccount.deposit(100);
        } catch (Exception e) {
            System.out.println("Handled null account safely.");
        }

        // I. Confirm balance logic
        if (Math.abs(a1.getBalance() - 500.0) > 0.001) {
            System.out.println("Balance mismatch on a1!");
        }

        // J. Stress testing withdrawal loop
        while (a2.getBalance() > 0.0) {
            a2.withdraw(100); // Should eventually hit zero or overdraw
        }

        a2.displayAccountInfo();

        System.out.println("=== Robust Test Completed ===");
    }
}
