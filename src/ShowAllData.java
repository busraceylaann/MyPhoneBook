import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowAllData {
    public void showData()throws IOException{
        String path="dosya.txt";
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        System.out.println("----------------------------------------------------");
        System.out.println("|ID  İSİM    SOYİSİM    NUMARA                     |");
        System.out.println("----------------------------------------------------");
        String line=null;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        System.out.println("----------------------------------------------------");
        bufferedReader.close();
    }
}
