class Account {
	public double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public double calculateInterest() {
		return balance * 0.02;
	}
}

class SavingsAccount extends Account {
	public SavingsAccount(double balance) {
		super(balance);
	}

	@Override
	public double calculateInterest() {
		double interest = balance * 0.04;
		if (balance > 50000) {
			interest += 500;
		}
		return interest;
	}
}

class FixedDeposit extends SavingsAccount {
	public FixedDeposit(double balance) {
		super(balance);
	}

	@Override
	public double calculateInterest() {
		double parentInterest = super.calculateInterest();
		double extra = balance * 0.02;
		return parentInterest + extra;
	}
}

public class main1{
	public static void main(String args[]){
		Account a1 = new SavingsAccount(10000);
		System.out.println("TC 1: " + a1.calculateInterest()); // Expected: 400

		Account a2 = new SavingsAccount(60000);
		System.out.println("TC 2: " + a2.calculateInterest()); // Expected: 2900

		Account a3 = new FixedDeposit(60000);
		System.out.println("TC 3: " + a3.calculateInterest()); // Expected: 4100
	}
}
