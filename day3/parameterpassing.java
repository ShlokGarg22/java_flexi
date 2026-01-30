class Test{
    void modifyvalue(int x){
        x = x + 10;
        System.out.println(x);
    }

    public static void main(String args[]){
        int a = 5;
        Test obj = new Test();
        obj.modifyvalue(a);
        System.out.println(a);
    }
}