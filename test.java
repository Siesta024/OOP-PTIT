import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        int cnt = 0;
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                String[] words = line.split("\\+s");
                cnt += words.length;
            }
        }
        
        System.out.println(cnt);
    }
}