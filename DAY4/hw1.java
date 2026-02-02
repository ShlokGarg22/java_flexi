class Parent {
    int x = 10;

    Parent(int x) {
        System.out.println("Parent constructor called");
        System.out.println("Parent x = " + x);
    }
}

class Child extends Parent {
    int x = 20;

    Child(int x) {
        super(x);                 // calls Parent constructor
        this.x = x;               // refers to Child variable
        System.out.println("Child constructor called");
        System.out.println("Child x = " + this.x);
        System.out.println("Parent x using super = " + super.x);
    }

    void display() {
        System.out.println("Child x using this = " + this.x);
        System.out.println("Parent x using super = " + super.x);
    }

    public static void main(String[] args) {
        Child obj = new Child(50);
        obj.display();
    }
}
