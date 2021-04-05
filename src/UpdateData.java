import java.io.*;
import java.util.Scanner;

public class UpdateData {

    public void update() throws IOException {

        String yeni_ad = null ;
        String yeni_soyad = null;
        String yeni_numara = null;
        boolean flag = true;

        Scanner console = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.print("İndex Numarası Girin: ");
        int id = console.nextInt();

        try {
            System.out.print("Güncellenecek Alanı Seçiniz (Ad : 1/ Soyad : 2 / Telefon : 3 / Hepsi : 4) : ");
            int secimId = console.nextInt();

            if (secimId == 1){
                System.out.print("Yeni İsim Girin: ");
                yeni_ad = console.next();
            }
            else if (secimId == 2) {
                System.out.print("Yeni Soyad Girin: ");
                yeni_soyad = console.next();

            }
            else if (secimId == 3) {
                System.out.print("Yeni Numara Girin: ");
                yeni_numara = console.next();

            }
            else if (secimId == 4) {

                System.out.print("Yeni İsim Girin: ");
                yeni_ad = console.next();
                System.out.print("Yeni Soyad Girin: ");
                yeni_soyad = console.next();
                System.out.print("Yeni Numara Girin: ");
                yeni_numara = console.next();

            }
            else { flag = false;}


            if (flag == true) {
                System.out.println("----------------------------------------------------");
                File originalFile = new File("dosya.txt");
                BufferedReader br = new BufferedReader(new FileReader(originalFile));

                File tempFile = new File("temp.txt");
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile)); //tempfile satır satır yazdırır

                String line = null;

                while ((line = br.readLine()) != null) {  //Okuttuğumuz dosyayı line değişkenine aktarıyoruz.
                    String[] array = line.split("\t");
                    if (Integer.valueOf(array[0]).equals(id)) {
                        if (array != null) {
                            array[0] = String.valueOf(id);
                            if (yeni_ad != null)
                                array[1] = yeni_ad;
                            if (yeni_soyad != null)
                                array[2] = yeni_soyad;
                            if (yeni_numara !=  null)
                                array[3] = yeni_numara;


                             line = array[0] + "\t" + array[1] + "\t" + array[2] + "\t" +  array[3];
                        }
                    }
                    pw.println(line);
                    pw.flush();
                }
                pw.close();
                br.close();

                if (!originalFile.delete()) {
                    System.out.println("Dosya Silinemedi");
                    return;
                } else if (!tempFile.renameTo(originalFile)) {
                    System.out.println("Dosya İsmi Değişmedi");
                    return;
                } else {
                    System.out.println("Kişi Güncellendi.");
                    return;
                }
            }
        }
        catch (Exception e){
            System.out.println("Yanlış Değer girdiniz");

        }




    }
}





