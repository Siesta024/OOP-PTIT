import java.util.*;

class Student {
    int id;
    String name;
    double gpa;

    Student(int i, String name, double gpa) {
        this.id = i;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

    public String toString() {
        return "id: " + id + ", name: " + name + ", gpa: " + gpa;
    }
}

public class test {
    public static void main(String[] args) {
        LinkedList<Student> arr = new LinkedList<>();

        arr.add(new Student(1, "Duy", 4.0));
        arr.add(new Student(2, "Dung", 3.95));
        arr.add(new Student(3, "Long", 3.98));

        
    }
}