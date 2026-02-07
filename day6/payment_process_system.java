import java.util.Scanner;

class Gateway {

    void transfer(int cardNumber, int cvv) {
        System.out.println("You have done payment using the credit card");
        System.out.println("Payment done");
    }

    void transfer(String accountNumber, String ifscCode) {
        System.out.println("You have done payment using the bank transfer");
        System.out.println("Payment done");
    }

    void transfer(String upiId) {
        System.out.println("You have done payment using the UPI ID");
        System.out.println("Payment done");
    }
}

public class PaymentProcessSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Gateway g = new Gateway();

        System.out.println("Enter your method of payment:");
        System.out.println("1 - Credit Card");
        System.out.println("2 - Bank Transfer");
        System.out.println("3 - UPI ID");

        int paymentMethod = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        switch (paymentMethod) {

            case 1:
                System.out.println("Enter the credit card number:");
                int creditCard = scanner.nextInt();

                System.out.println("Enter the CVV:");
                int cvv = scanner.nextInt();

                g.transfer(creditCard, cvv);
                break;

            case 2:
                System.out.println("Enter the account number:");
                String accountNumber = scanner.nextLine();

                System.out.println("Enter the IFSC code:");
                String ifscCode = scanner.nextLine();

                g.transfer(accountNumber, ifscCode);
                break;

            case 3:
                System.out.println("Enter the UPI ID:");
                String upiId = scanner.nextLine();

                g.transfer(upiId);
                break;

            default:
                System.out.println("Invalid payment method");
        }

        scanner.close();
    }
}
