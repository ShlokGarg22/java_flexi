class Demo {

    static void fun() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught in fun()");
            throw e;   // rethrow
        }
    }

    public static void main(String[] args) {

        try {
            fun();
        } catch (NullPointerException e) {
            System.out.println("Caught again in main()");
        }
    }
}
