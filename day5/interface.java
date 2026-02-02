//what is the use of interface?

//diamond problem can only be solved sing interface

interface Animal{
    void sound();
}

class Dog implements Animal{
    public  void (){
        System.out.println("Dog barks");
    }
}
public class InterfaceExample{
    public static void main(String args[]){
        Animal a = new Dog();
        a.sound();
    }
}

// write a program in java to implement interface to solve the diagramm problem