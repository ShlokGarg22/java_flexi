class Exception{
    static void fun(){
        try{
            throw new NullPointerException("demo");
        }catch(NullPointerException e){
            System.out.println("caught inside fun()");
            throw e;
        }
    }

    public static void main(String args[]){
        try{
            fun();
        }catch(NullPointerException e){
            System.out.println("caught in main");
        }
    }
}