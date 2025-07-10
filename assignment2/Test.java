package assignment2;

public class Test {

	public static void main(String[] args) {
		Account account = new Account(1122, "my checking account");

		account.deposit(3000);
		account.withdraw(2500);
		account.deposit(800);
		account.withdraw(200);
		account.displayAccountInfo();

		if (account.getBalance() != 1100) {
			System.out.println("Something went wrong! " + account.getAccountName() + " should have 1100 CAD balance.");
		}

		System.out.println();
		
		Account accountSavings = new Account(1133, "my savings account");
		accountSavings.deposit(10000);
		accountSavings.deposit(2000);
		accountSavings.displayAccountInfo();

		System.out.println();

		account.combine(accountSavings);
		account.setAccountNum(1190);
		account.setAccountName("my all money at the bank");
		account.displayAccountInfo();
	}
}
