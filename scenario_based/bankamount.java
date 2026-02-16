import java.util.ArrayList;

// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Account Class
class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Withdraw
    public void withdraw(double amount) throws InsufficientFundsException {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    // Transfer
    public void transfer(Account targetAccount, double amount)
            throws InsufficientFundsException {

        if (targetAccount == null) {
            System.out.println("Target account not found.");
            return;
        }

        this.withdraw(amount);   // may throw exception
        targetAccount.deposit(amount);

        System.out.println("₹" + amount + " transferred successfully.");
    }

    // Display details
    public void displayAccountDetails() {
        System.out.println("----------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("----------------------------");
    }
}

// Bank Class
class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    public void createAccount(String accountNumber,
                              String accountHolderName,
                              double initialBalance) {

        Account account = new Account(accountNumber,
                                      accountHolderName,
                                      initialBalance);

        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public Account getAccount(String accountNumber) {

        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }

        return null;
    }

    public void displayAllAccounts() {
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        // Create Accounts
        bank.createAccount("101", "Shlok", 10000);
        bank.createAccount("102", "Rahul", 5000);

        // Get Accounts
        Account acc1 = bank.getAccount("101");
        Account acc2 = bank.getAccount("102");

        try {

            // Deposit
            acc1.deposit(2000);

            // Withdraw
            acc1.withdraw(3000);

            // Transfer
            acc1.transfer(acc2, 4000);

            // Attempt over-withdraw (Exception case)
            acc2.withdraw(20000);

        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Display all accounts
        bank.displayAllAccounts();
    }
}
