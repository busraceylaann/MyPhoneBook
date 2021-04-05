
import javax.swing.*;
import java.io.*;
import java.util.Scanner;


public class DeleteData {
    private Scanner x;

    public void delete() throws IOException {
        Scanner veri = new Scanner(System.in);
        String filepath = "dosya.txt";
        String tempFile = "delete.txt";
        File oldFile = new File(filepath); //Eski Dosyamızı Belirttik.
        File newFile = new File(tempFile); //Oluşturduğumuz boş dosyayıyı atadık.
        System.out.print("Lütfen Silinecek ID'yi Girin: "); //İd numarasını aldık.
        String input = veri.next();

        String id = "";
        String name = "";
        String surName = "";
        String number = "";

        try {
            FileWriter fileWriter = new FileWriter(tempFile, true);//Boş dosyamıza eklemek için filewritter kullandık.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);//Karakterlerin byte'a dönmesini engelledik.
            PrintWriter printWriter = new PrintWriter(bufferedWriter);//Satır satır yazdırma işlemi için kullandık.

            x = new Scanner(new File(filepath)); //Scannerle dosyamızı okuyoruz ve x değişkenine atıyoruz.
            x.useDelimiter("[\t\n]");//Modelin sınıflandırmasını belirttik yani verimizin nasıl olduğunu annlattık.
            while (x.hasNext()) { //Bulunduğu satırdan sonra okuduğumuz dosyada veri var mı yok mu kontrol eder.
                id = x.next();
                name = x.next();
                surName = x.next();
                number = x.next().strip();
                if (!id.equals(input)) {
                    printWriter.println(id + "\t" + name + "\t" + surName + "\t" + number);

                }
            }
            x.close(); //Okuma işlemini kapattık.
            printWriter.flush();
            printWriter.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}

