class Account {
    protected double balance;

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
        return super.calculateInterest() + (balance * 0.02);
    }
}

public class MultiTierInterestSystem {
    public static void main(String[] args) {
        SavingsAccount tc1 = new SavingsAccount(10000);
        SavingsAccount tc2 = new SavingsAccount(60000);
        FixedDeposit tc3 = new FixedDeposit(60000);

        System.out.println("TC 1 - SavingsAccount(10000): " + tc1.calculateInterest());
        System.out.println("TC 2 - SavingsAccount(60000): " + tc2.calculateInterest());
        System.out.println("TC 3 - FixedDeposit(60000): " + tc3.calculateInterest());

        Account acc = new FixedDeposit(60000);
        System.out.println("Polymorphism Demo (Account ref -> FixedDeposit obj): "
                + acc.calculateInterest());
    }
}
