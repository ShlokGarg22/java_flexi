// Case Study 1: The Smart Payment Gateway

abstract class Payment {
    private String transactionId;
    private double amount;

    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    abstract double processPayment();
}

class CreditCardPayment extends Payment {

    public CreditCardPayment(String transactionId, double amount) {
        super(transactionId, amount);
    }

    @Override
    double processPayment() {
        // 2% convenience fee
        return getAmount() + (getAmount() * 0.02);
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String transactionId, double amount, String upiId) {
        super(transactionId, amount);
        this.upiId = upiId;
    }

    public String getUpiId() {
        return upiId;
    }

    @Override
    double processPayment() {
        // Simple UPI ID check
        if (upiId == null || !upiId.contains("@")) {
            System.out.println("Invalid UPI ID for transaction: " + getTransactionId());
            return 0.0;
        }
        return getAmount();
    }
}

class PaymentProcessor {
    public double process(Payment payment) {
        return payment.processPayment();
    }
}

public class SmartPaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // TC 1: Credit Card Processing
        Payment ccPayment = new CreditCardPayment("TXN1234567", 1000.0);
        double ccResult = processor.process(ccPayment);
        System.out.println("TC 1 Result: " + ccResult); // 1020.0

        // TC 2: UPI Processing
        Payment upiPayment = new UPIPayment("TXN7654321", 1000.0, "user@upi");
        double upiResult = processor.process(upiPayment);
        System.out.println("TC 2 Result: " + upiResult); // 1000.0

        // TC 3: Polymorphic Array
        Payment[] payments = {
            new CreditCardPayment("TXN1111111", 1000.0),
            new UPIPayment("TXN2222222", 1000.0, "payee@bank")
        };

        double total = 0.0;
        for (Payment payment : payments) {
            total += processor.process(payment);
        }

        System.out.println("TC 3 Total: " + total); // 2020.0
    }
}
