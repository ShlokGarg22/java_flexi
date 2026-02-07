class BankAccount{
    double getInterestRate(){
        return 0.0;
    }
}

class SavingAccount extends BankAccount{
    // @Override
    double getInterestRate(){
        return 4.5;
    }
}
class CurrentAccount extends BankAccount{
    // @Override
    double getInterestRate(){
        return 3.0;
    }
}

public class method_overinding{
    public static void main(String args[]){
        BankAccount sa = new SavingAccount();
        BankAccount ca = new CurrentAccount();

    System.out.println("Savings Interest Rate: " + sa.getInterestRate());
    System.out.println("Current Interest Rate: " + ca.getInterestRate());
    
    }
}