class Student{
    String name;
    int age;

    // Student(){
    //     name="default name";
    //     age = 18;
    // }


    Student(String a , int ages){
        name = a;
        age = ages;
    }
    void display(){
        System.out.println("name " + name + "age " + age);
    }
}

public class constructor{
    public static void main(String args[])
    {
        Student student1 = new Student("Shashank",19);
        student1.display();
    }
}

hw
write a program in java param,ertized constucot wil be sot r name and division of three students
