import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class b2{
    static class sub{
        String code, name, method;
        public sub(String c, String n, String m){
            code=c;
            name=n;
            method=m;
        }

        public String toString(){
            return code + " " + name + " " + method;
        }
    }
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<sub> a = new ArrayList<>();
        sc.nextLine();
        for(int i=0; i<n; i++){
            a.add(new sub(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
        a.sort((x, y) -> x.code.compareTo(y.code));

        for(int i=0;i<n;i++) System.out.println(a.get(i));
    }
}