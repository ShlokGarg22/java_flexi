public class Student {
    String name;
    int prn;
    String division;

    Student(String name, int prn, String division) {
        this.name = name;
        this.prn = prn;
        this.division = division;
    }

    void printing() {
        System.out.println("The name of the student is " + name + ", the division is " + division + ", the PRN is " + prn);
    }
}

class Parahw {
    public static void main(String[] args) {
        Student stu1 = new Student("Shlok", 24070122187L, "CSEB4");

        stu1.printing();
    }
}