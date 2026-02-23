public class EXCP{
    public static void main(String args[]){
        try{

            int []n = new int[5];
            int divisor = 0;

            for(int i = 0;i<n.length;i++){
                int res = n[i]/divisor;
                System.out.println(res);
            }
        }
        catch(ArithemeticException e){
            throw new RuntimeException
            ("error division by zero occurred",e);
        }
    }
}