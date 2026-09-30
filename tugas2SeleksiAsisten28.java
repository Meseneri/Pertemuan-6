import java.util.Scanner;

public class tugas2SeleksiAsisten28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Apakah mahasiswa berstatus aktif? (true/false): ");
        boolean statusAktif = sc.nextBoolean();

        System.out.print("Apakah mahasiswa sedang sanksi akademik? (true/false): ");
        boolean sanksiAkademik = sc.nextBoolean();

        System.out.print("Masukkan nilai Dasar Pemrograman: ");
        int nilaiDasproq = sc.nextInt();

        System.out.print("Apakah punya sertifikat kompetensi pemrograman? (true/false): ");
        boolean punyaSertifikat = sc.nextBoolean();

        System.out.print("Masukkan nilai wawancara: ");
        int nilaiWawancara = sc.nextInt();

        if (statusAktif && !sanksiAkademik) {
            if (nilaiDasproq >= 80 || punyaSertifikat) {
                if (nilaiWawancara >= 75) {
                    System.out.println("Selamat! Mahasiswa diterima sebagai asisten praktikum");
                } else {
                    System.out.println("Gagal! Nilai wawancara belum mencapai 75");
                }
            } else {
                System.out.println("Gagal! Nilai Dasar Pemrograman kurang dari 80 dan tidak memiliki sertifikat kompetensi");
            }
        } else {
            System.out.println("Gagal! Status mahasiswa tidak aktif atau sedang mendapat sanksi akademik");
        }
    }
}