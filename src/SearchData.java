import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchData {
    public void search() throws IOException {
        try {
            Scanner input=new Scanner(System.in);
            System.out.print("Getirilecek Kaydı Girin: ");
            String c=input.next();
            FileReader fr = new FileReader("dosya.txt");
            BufferedReader br = new BufferedReader(fr);
            String line=null;
            System.out.println("----------------------------------------------------");
            System.out.println("|ID  İSİM    SOYİSİM    NUMARA                     |");
            System.out.println("----------------------------------------------------");
            while((line=br.readLine())!=null) {
                if(line.contains(c)) System.out.println(line);
            }
            System.out.println("----------------------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
