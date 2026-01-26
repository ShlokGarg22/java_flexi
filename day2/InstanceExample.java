// Demonstrates the use of instance methods with both instance and static variables in Java
public class InstanceExample {
    
    int instanceVar;

    static int staticVar = 0;

    InstanceExample(int value) {
        this.instanceVar = value;
    }

    void displayValues() {
        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
    }

    public static void main(String[] args) {
        InstanceExample obj1 = new InstanceExample(10);
        InstanceExample obj2 = new InstanceExample(20);

        InstanceExample.staticVar = 100;

        obj1.displayValues();
        obj2.displayValues();
    }
}