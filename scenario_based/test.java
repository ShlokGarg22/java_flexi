import java.util.ArrayList;

class test {
    public static void main(String[] args) {
      
        String arr[] = {"shlok", "krrish"};

        ArrayList<String> j = new ArrayList<>();

        j.add("shlok");
        j.add("shashank");

        j.remove(0);

        int a = j.size();

        System.out.println(a);
        System.out.println(j);


    }
}