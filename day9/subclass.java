class SuperClass{
    void method(){
        System.out.println("superclass method executed");
    }
}

class SubClass extends SuperClass{
    @override
    void method() throws ArithemeticException{
        System.out.println("subclass in Subclass");
        throw new ArithemeticException("exception in subclass");
    }
}

public static void main(String args[]){
    SuperClass s = new SubClass();

    try{
        s.method();
    }catch(ArithemeticException e){
        System.out.println("caught exception" + e,getMessage());
    }

}

