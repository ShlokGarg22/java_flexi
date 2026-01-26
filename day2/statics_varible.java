class Counter{
    static String rollPrefix = "24070122";
    static int count = 0; 

    String name;
    String rollNumber;

    Counter(String name) {
        this.name = name;
        count++;
        this.rollNumber = rollPrefix + count;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber);
    }
}

public class StaticsVariable {
    public static void main(String[] args) {
        Counter user1 = new Counter("Shlok");

        user1.display();
    }
}