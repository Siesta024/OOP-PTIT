import java.io.*;

public class read_write_file {
    public static void writefile(String s) {
        String path = "file.txt";

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(path, true))) {
            wr.write(s);
            wr.newLine();
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void readfile() {
        String path = "file.txt";
        
        try (BufferedReader rd = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readfile();
        writefile("max verstappen");
        writefile("come back of all comeback");
    }
}
