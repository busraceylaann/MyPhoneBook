import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean exit = true;
        Scanner input = new Scanner(System.in);
        byte secim = -1;
        while (exit) {
            System.out.println("------------------Telefon Rehberim------------------");
            System.out.println("|  1-Yeni Kayıt Ekle                               |");
            System.out.println("|  2-Kişi Güncelle                                 |");
            System.out.println("|  3-Kişi Ara                                      |");
            System.out.println("|  4-Kişi Sil                                      |");
            System.out.println("|  5-Listele                                       |");
            System.out.println("|  6-Çıkış                                         |");
            System.out.println("----------------------------------------------------");
            System.out.print("Bir seçenek Giriniz : ");
            secim = input.nextByte();

            switch (secim) {
                case 1:
                    CreateData createData = new CreateData();
                    createData.create();
                    break;

                case 2:
                    UpdateData updateData = new UpdateData();
                    updateData.update();
                    break;
                case 3:
                    SearchData searchData = new SearchData();
                    searchData.search();
                    break;
                case 4:
                    DeleteData deleteData = new DeleteData();
                    deleteData.delete();
                    break;
                case 5:
                    ShowAllData showAllData = new ShowAllData();
                    showAllData.showData();
                    break;
                default:
                case 6:
                    System.out.println("Sistem Kapanıyor!!");
                    exit = false;
                    break;
            }
        }
    }

}
