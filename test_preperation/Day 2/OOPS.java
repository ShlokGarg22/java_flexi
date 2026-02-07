package OOPS;
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("The Animal is sleeping.");
    }
}

// Subclass (inherit from Animal)
class Dog extends Animal { // Inheritance
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The dog says: woof");
    }
}

// Subclass (inherit from Animal)
class Pig extends Animal { // Polymorphism
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

class Name { // Encapsulation
    private String name; // private = restricted access
    // Getter
    public String getName() {
        return name;
    }
    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
}

class OOPs {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // Abstraction
        myDog.animalSound();
        myDog.sleep();

        Name petName = new Name();
        petName.setName("Lucy"); // Encapsulation
        System.out.println("The Dog's name is: " + petName.getName());

        Animal myPig = new Pig(); // Polymorphism
        myPig.animalSound();
        myPig.sleep();

        petName.setName("Peppa"); // Encapsulation
        System.out.println("The Pig's name is: " + petName.getName());
    }
}