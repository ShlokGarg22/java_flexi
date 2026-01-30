public class wrapper{
    
    public static void main(String args[]){
        int i = 3;
        double d = 2.4;

        System.out.println("integer i -->" + i);
        System.out.println("double d --->" + d);

        Integer i1 = Integer.valueOf(i);
        Integer d2 = Integer.valueOf(d);

        String str1 = "123";
        String str2 = "256";

        System.out.println("answer is" + (str1 + str2));
