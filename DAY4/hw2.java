class Parent {
    void show() {
        System.out.println("This is Parent class method");
    }
}

class Child extends Parent {

    void show() {
        super.show();  // calling parent method
        System.out.println("This is Child class method");
    }

    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}
