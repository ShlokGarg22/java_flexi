class Parent{
    final void display(){
        System.out.println("final methos in parent class");
    }

}

class Child extends Parent{

}

public class FinalVariableExample{
    public static void main(String args[]){
        Child c = new Child();
        c.display();
    }
}

//wrute a program where you will be using final class and final method and feinal variable  within a sinegle program