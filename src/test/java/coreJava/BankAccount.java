package coreJava;

public class BankAccount {
	private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Withdrawal failed! Available balance: " + balance + ", Requested: " + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
    }

	public static void main(String[] args) {
		BankAccount account = new BankAccount(5000); // Initial balance = 5000

        try {
            account.withdraw(2000); // ✅ Successful
            account.withdraw(4000); // ❌ Will throw exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
	}
}
