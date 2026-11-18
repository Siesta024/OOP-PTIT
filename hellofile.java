import java.io.*;
import java.util.*;

public class hellofile {
    public static void main(String[] args) {
        String path = "Hello.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
