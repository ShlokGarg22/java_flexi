class Person{
    String name;

    void display(){
        System.out.println("name -->" +  name);
    }

    public static void main(String args[]){
        Person p = new Person();
        Person s = new Person();
        Person q = new Person();

        p.display();
        s.display();
        q.display();

        p.name = "Shashank";
        s.name = "Shlok";
        q.name = "sayantan";
    }
}