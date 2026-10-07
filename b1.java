import java.util.*;

public class b1 {
    static class Employee implements Comparable<Employee> {
        String id, name;
        double salary;

        public Employee(String id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            if (this.salary != o.salary) {
                return Double.compare(o.salary, this.salary);
            }
            return this.id.compareTo(o.id);
        }
    }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       if (!sc.hasNextLine()) return;
       
       int n = Integer.parseInt(sc.nextLine().trim());
       List<Employee> list = new ArrayList<>();
       
       for (int i = 0; i < n; i++) {
           String id = sc.nextLine().trim();
           String name = sc.nextLine().trim();
           double basic = Double.parseDouble(sc.nextLine().trim());
           double days = Double.parseDouble(sc.nextLine().trim());
           double coef = Double.parseDouble(sc.nextLine().trim());
           
           double salary = basic * days * coef / 22.0;
           list.add(new Employee(id, name, salary));
       }
       
       Collections.sort(list);
       
       int q = Integer.parseInt(sc.nextLine().trim());
       for (int i = 1; i <= q; i++) {
           String[] parts = sc.nextLine().trim().split("\\s+");
           double a = Double.parseDouble(parts[0]);
           double b = Double.parseDouble(parts[1]);
           
           System.out.println(i);
           for (Employee e : list) {
               if (e.salary >= a && e.salary <= b) {
                   System.out.printf(Locale.US, "%s %s %.2f\n", e.id, e.name, e.salary);
               }
           }
       }
       sc.close();
   }
}
