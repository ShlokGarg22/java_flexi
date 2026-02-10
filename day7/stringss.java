public class StringMethods{
    public static void main(String args[]){
        String str = " Java Programming "

        System.out.println("Length" + str.length());
        System.out.println("Trimmed" + str.trim());
        System.out.println("upppercase" + str.toUpperCase());
        System.out.println("Substring" + str.substring(2,6));
        System.out.println("replace java with python" + str.replace("Java" , "Python"));
    }
}