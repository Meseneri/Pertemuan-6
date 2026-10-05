import java.util.Scanner;

public class tugas1DiskonTokoBuku28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String namaBuku;
        int jumlahBuku;
        int diskon;
        int diskonkamus = 10;
        int diskonnovel = 7;
        int diskonlain = 5;

        System.out.println("Masukkan nama buku : ");
        namaBuku = sc.nextLine();

        System.out.println("jumlah buku yang dibeli : ");
        jumlahBuku = sc.nextInt();

        if (namaBuku.equalsIgnoreCase("kamus") && jumlahBuku <= 2) {
            diskon = diskonkamus;
        } else if (namaBuku.equalsIgnoreCase("kamus") && jumlahBuku > 2) {
            diskon = diskonkamus + 2;
        } else if (namaBuku.equalsIgnoreCase("novel") && jumlahBuku <= 3) {
            diskon = ++diskonnovel;
        } else if (namaBuku.equalsIgnoreCase("novel") && jumlahBuku > 3) {
            diskon = diskonnovel + 2;
        } else if (!namaBuku.equalsIgnoreCase("kamus") && !namaBuku.equalsIgnoreCase("novel") && jumlahBuku > 3) {
            diskon = diskonlain;
        } else {
            diskon = 0;
        }

        System.out.println("---Toko Buku---");
        System.out.println("Buku yang dibeli : " + namaBuku);
        System.out.println("Jumlah buku yang dibeli : " + jumlahBuku);
        System.out.println("Diskon yang didapat : " + diskon + "%");
        sc.close();
    }
}