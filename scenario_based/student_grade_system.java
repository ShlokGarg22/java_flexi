import java.util.ArrayList;

class Student {

    String name;
    ArrayList<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        if (grades.size() == 0) {
            return 0;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }
}

class GradeManager {

    ArrayList<Student> students;

    GradeManager() {
        students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayAllStudents() {

        for (Student student : students) {

            System.out.println("Name: " + student.name);

            System.out.print("Grades: ");
            for (double grade : student.grades) {
                System.out.print(grade + " ");
            }

            System.out.println();

            System.out.println("Average: " + student.calculateAverage());

            System.out.println("-----------------------------");
        }
    }
}

public class student_grade_system{

    public static void main(String[] args) {

        GradeManager manager = new GradeManager();

        Student s1 = new Student("Rahul");
        s1.addGrade(85);
        s1.addGrade(90);
        s1.addGrade(78);

        Student s2 = new Student("Amit");
        s2.addGrade(70);
        s2.addGrade(88);
        s2.addGrade(92);

        manager.addStudent(s1);
        manager.addStudent(s2);

        manager.displayAllStudents();
    }
}
