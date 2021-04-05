import java.io.*;
import java.util.Scanner;

public class CreateData {
    File file = new File("dosya.txt"); //Yeni dosya oluşturduk.

    public void create() throws IOException, FileNotFoundException {
        Kisi kisi;
        if (!file.exists()) {  //Dosyamız eğer yoksa yeniden oluşturduk.
            file.createNewFile();
        }

        File originalFile = new File("dosya.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));//Dosyamızı okumak için aldık.

        String line;
        int max = 0;

        while ((line = br.readLine()) != null) { //line değişkenine okutulan dosyayı atadık.
            String[] array = line.split("\t");
            if (Integer.valueOf(array[0]) > max) { //Dizinin 0.indexsini integer'a çevirdik ve bu değeri max değişkenimizle karşılaştırdık.
                max = Integer.valueOf(array[0]); //Eğer dizimizdeki 0.index max değişkeninden büyükse dizinin 0.indexsini maxsimum yaptık.
            }
        }
        br.close();//Okuma işlemini kapattık.

        FileWriter fileWriter = new FileWriter(file, true); //txt biçimli dosyamızı yazdırmak için filewritter kullandık.
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //Dosyaya kayıt yaparken bize bir tampon bellek oluşturdu bu  işlem karakterler byte'a dönmesini engellemek için kullanıldı.
        String[] array = new String[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Kişinin Adı: ");
        array[0] = input.nextLine();       //set metoduyla kişi clasımıza verileri set ettik
        System.out.print("Kişinin Soyadı: ");
        array[1] = input.nextLine();
        System.out.print("Kişinin Numarası: ");
        array[2] = input.nextLine();
        kisi = new Kisi(array[0], array[1], array[2]);//oluşturduğumuz kişi classını çağırdık.
        kisi.setId(max);//Maksimum değeri set ettik kişi classındaki id  ye.
        bufferedWriter.write(kisi.getId() + "\t" + kisi.getAdı() + "\t" + kisi.getSoyadı() + "\t" + kisi.getNumara()); //get metodu ile verilerimizi dosyaya yazdırdık.
        bufferedWriter.newLine();//Yeni Satır.
        bufferedWriter.close(); //Dosya yazma işlemini kapattık.
    }
}
