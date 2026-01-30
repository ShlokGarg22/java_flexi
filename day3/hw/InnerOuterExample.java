class OuterClass {
    private String outerMsg = "Message from Outer Class";

    // Inner Class
    class InnerClass {
        void display() {
            System.out.println("Inner Class: Accessing " + outerMsg);
        }
    }

    void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

public class InnerOuterExample {
    public static void main(String[] args) {
        // Option 1: Using outer class method to create inner
        OuterClass outer = new OuterClass();
        System.out.println("Calling inner class via outer class method:");
        outer.createInner();

        // Option 2: Directly creating inner class object
        System.out.println("\nCreating inner class object directly:");
        OuterClass.InnerClass innerObj = outer.new InnerClass();
        innerObj.display();
    }
}
