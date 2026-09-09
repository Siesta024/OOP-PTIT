class Student {
    private String name;
    private int[] grades;
    private double Avg_grade;
    private String Ispass;
    private int highest_grade;

    public Student(String s, int[] g) {
        this.name = s;
        this.grades = g;

        double sum = 0;
        double cnt = 0;
        int h = 0;
        
        for (int i = 0; i < g.length; i++) {
            sum += g[i];
            cnt++;
            if (h < g[i]) {
                h = g[i];
            }
        }

        double avg = sum / cnt;
        this.Avg_grade = avg;
        this.Ispass = (avg >= 50) ? "Pass" : "Fail";
        this.highest_grade = h;

        System.out.printf("Name: %s\nAvg score: %.2f, Pass: %s, Highest grade: %d\n", 
                  this.name, this.Avg_grade, this.Ispass, this.highest_grade);
    }
}

public class Stu {
    public static void main(String[] args) {
        int[] grades = {70, 85, 40, 90, 60};
        Student student = new Student("Alice", grades);
    }
}
