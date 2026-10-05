import java.util.Scanner;

public class tugas2SeleksiAsisten28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean mahasiswaAktif;
        boolean kenaSanksi;
        double nilaiDaspro;
        boolean sertifProgamming;
        int wawancara;

        System.out.println("---Seleksi Calon Asisten---");
        System.out.println("Apakah mahasiswa aktif? (true/false): ");
        mahasiswaAktif = sc.nextBoolean();

        System.out.println("Apakah mahasiswa sedang terkena sanksi akademik? (true/false): ");
        kenaSanksi = sc.nextBoolean();


        if (mahasiswaAktif && !kenaSanksi) {
            System.out.println("Mahasiswa aktif dan tidak sedang menjalankan sanksi\nMahasiswa lulus seleksi awal");

            System.out.println("Berapa nilai daspro mahasiswa?: ");
            nilaiDaspro = sc.nextDouble();

            System.out.println("Apakah mahasiswa memiliki sertifikat Prohamming? (true/false); ");
            sertifProgamming = sc.nextBoolean();

            if (nilaiDaspro >= 80 || sertifProgamming) {
                System.out.println("Mahasiswa lulus seleksi tahap 2");

                System.out.println("Masukkan nilai wawancara : ");
                wawancara = sc.nextInt();

                if (wawancara >= 75) {
                    System.out.println("Selamat! Mahasiswa lulus seleksi sebagai asisten praktikum");
                } else {
                    System.out.println("Maaf nilai mahasiswa kurang dari 75\nMahasiswa gagal menjadi asisten praktikum");
                }
            } else {
                System.out.println("Nilai dasar pemrograman mahasiswa kurang dari 80 atau tidak punya sertifikat programing\nMahasiswa gagal");
            }
        } else if (!mahasiswaAktif) {
            System.out.println("Bukan merupakan mahasiswa aktif\nTidak lulus Seleksi");
        } else if (kenaSanksi) {
            System.out.println("Mahasiswa sedang menjalani sanksi akademik\nTidak lulus Seleksi");
        } else {
            System.out.println("GAGAL! Mahasiswa tidak memenuhi syarat");
        }
        sc.close();
    }
}