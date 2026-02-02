abstract class Shape{
    abstract void draw();


    void message(){
        System.out.println("this is a shape");
    }
}

class Circle extends Shape{
    void draw(){
        System.out.println("drawing a circle")
    }

}

public class AbstractExample{
    public static void main(String args[]){
        Shape s = new Circle();
        s.draw();
        s,message();
    }
}



//write a program in java where we will be using the abstract keyword to design a calculator application