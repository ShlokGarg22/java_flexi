class BankAccount {
    // Private data - cannot be accessed directly from outside
    private double balance;
    private String accountNumber;
    
    // Public methods to interact with private data
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    // Getter method - provides READ-ONLY access
    public double getBalance() {
        return balance;
    }
    
    // Setter method - provides CONTROLLED write access
    public void setAccountNumber(String accNum) {
        if(accNum.length() == 10) {
            this.accountNumber = accNum;
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        
        // These work - using public methods
        myAccount.deposit(1000);
        myAccount.withdraw(500);
        System.out.println("Current balance: $" + myAccount.getBalance());
        
        // These WON'T work - trying to access private data directly
        // myAccount.balance = 10000;  // ERROR: balance has private access
        // System.out.println(myAccount.accountNumber);  // ERROR
    }
}
