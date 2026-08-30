import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberReader {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(Integer.parseInt(line));
                System.out.println(Double.parseDouble(line));
            }
        }catch(IOException exception){
            System.out.println("Could not read from file");
        }
    }
}
