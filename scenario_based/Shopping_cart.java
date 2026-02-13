import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {

    ArrayList<Product> products;

    // Constructor
    ShoppingCart() {
        products = new ArrayList<>();
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void removeProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.equals(productName)) {
                products.remove(i);
                break;
            }
        }
    }

    double calculateTotalCost() {
        double sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).price;
        }
        return sum;
    }

    void displayCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Name: " + products.get(i).name +
                               " Price: " + products.get(i).price);
        }
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println("-----------------------------");
    }
}

class Main {
    public static void main(String args[]) {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 500));
        cart.addProduct(new Product("Keyboard", 1500));

        cart.displayCart();

        cart.removeProduct("Mouse");

        cart.displayCart();
    }
}

