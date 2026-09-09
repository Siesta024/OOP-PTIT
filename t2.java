import java.util.*;

public class t2 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("Java");

        a.append(" Programming");
        a.insert(0, "Language ");
        a.reverse();

        System.out.println(a);
    }
}
