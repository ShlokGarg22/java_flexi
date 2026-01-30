class WrapperExample{
    public static void main(String args[]){
        int x =5;
        Integer wrappedX = Integer.valueOf(x); //boxing
        int unwrappedX = wrappedX.intValue(); //unoxing
        System.out.println("Wrapped" + wrappedX + ", unwrappedX" + unwrappedX);

    }
}