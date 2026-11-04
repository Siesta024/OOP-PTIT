import java.util.*;
import java.io.*;

public class tinhtong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int s = 0;
        while (sc.hasNext()) {
            String a = sc.next();
            try {
                s += Integer.parseInt(a);
            }
            catch (NumberFormatException e) {

            }
        }

        System.out.println(s);
    }
}
