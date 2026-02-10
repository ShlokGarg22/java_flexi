class Parent{
    void show(){
        System.out.println("parents show method")
    }
}

class Child extends Parent{
    @Override
    void show(){
        System.out.println("Child's show method")
    }
}




class Main{
    public static void main(String args[]){
        Parent obj = new Child();
        obj.show();
    }
}