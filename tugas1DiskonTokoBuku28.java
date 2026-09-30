import java.util.Scanner;

public class tugas1DiskonTokoBuku28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Apakah pelanggan member? (true/false): ");
        boolean isMember = sc.nextBoolean();

        System.out.print("Masukkan total belanja: ");
        double totalBelanja = sc.nextDouble();

        double diskon;
        double totalBayar;

        if (isMember) {
            if (totalBelanja >= 500000) {
                diskon = 0.20;
            } else {
                diskon = 0.10;
            }
        } else {
            if (totalBelanja >= 500000) {
                diskon = 0.05;
            } else {
                diskon = 0;
            }
        }

        totalBayar = totalBelanja - (totalBelanja * diskon);

        System.out.println("Diskon yang didapat: " + (diskon * 100) + "%");
        System.out.println("Total yang harus dibayar: Rp. " + totalBayar);
    }
}