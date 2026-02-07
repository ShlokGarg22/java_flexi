import java.util.ArrayList;

public class ArrayListExample{
    public static void main(Stirng args[]){
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("cherry");

        System.out.println("fruits " + fruits);

        fruits.remove("banana");
        System.out.println("fruits " + fruits);
        System.out.println("size " + fruits.size());
        System.out.println("fruit have apple ? " + fruits.contains("cherry"));



            }
}