# JOBSHEET 5 - PEMILIHAN 2

**Identitas Mahasiswa:**
* **Nama:** Syauqi Khosyi Damar Agandi
* **NIM:** 264107020033
* **Kelas / No. Presensi:** TI-1D / 28

---

## 1: TUJUAN PRAKTIKUM

Berikut adalah tujuan pelaksanaan praktikum pada bab ini:

1. Mahasiswa mampu menyelesaikan permasalahan/studi kasus menggunakan sintaks pemilihan bersarang.
2. Mahasiswa mampu menerapkan sintaks pemilihan bersarang ke dalam program Java.
3. Mahasiswa mampu menerapkan operator logika &&, ||, dan ! pada struktur pemilihan.

---

## 2: HASIL PERCOBAAN & ANALISIS

### 2.1 Percobaan 1: Nested IF untuk Mengecek Syarat Ujian Skripsi

Percobaan ini membuat program untuk memeriksa syarat pendaftaran ujian skripsi. Sistem terlebih dahulu memeriksa status bebas kompen, kemudian memeriksa jumlah log bimbingan dengan Pembimbing 1 dan Pembimbing 2 menggunakan struktur pemilihan bersarang (Nested IF).

#### 2.1.1 Kode Program Java

```java
// nestedUjianSkripsi28.java
import java.util.Scanner;

public class nestedUjianSkripsi28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pesan;

        System.out.print("Apakah mahasiswa sudah bebas kompen? (Ya/Tidak): ");
        String bebasKompen = sc.nextLine().trim();

        System.out.print("Masukkan jumlah log bimbingan Pembimbing 1: ");
        int bimbinganP1 = sc.nextInt();
        System.out.print("Masukkan jumlah log bimbingan Pembimbing 2: ");
        int bimbinganP2 = sc.nextInt();

        if (bebasKompen.equalsIgnoreCase("Ya")) {
            if (bimbinganP1 >= 8 && bimbinganP2 >= 4) {
                pesan = "Semua syarat terpenuhi. Mahasiswa boleh mendaftar ujian skripsi";
            } else if (bimbinganP1 < 8 && bimbinganP2 < 4) {
                pesan = "Gagal! Log bimbingan P1 kurang dari 8 kali dan P2 kurang dari 4 kali";
            } else if (bimbinganP1 < 8) {
                pesan = "Gagal! Log bimbingan P1 belum mencapai 8 kali";
            } else {
                pesan = "Gagal! Log bimbingan P2 belum mencapai 4 kali";
            }
        } else {
            pesan = "Gagal! Mahasiswa masih memiliki tanggungan kompen";
        }

        System.out.println(pesan);
    }
}
```

#### 2.1.2 Jawaban Pertanyaan / Pertanyaan Refleksi

* **Pertanyaan 1:** Apa yang terjadi jika mahasiswa menjawab "No" pada pertanyaan bebas kompen? Mengapa demikian?
  * **Jawab:** Program akan langsung mencetak pesan "Gagal! Mahasiswa masih memiliki tanggungan kompen". Hal ini terjadi karena kondisi bebasKompen.equalsIgnoreCase("Ya") bernilai salah, sehingga program langsung masuk ke blok else pada level pertama tanpa perlu memeriksa jumlah log bimbingan sama sekali.

* **Pertanyaan 2:** Jelaskan maksud dari potongan kode if (bimbinganP1 >= 8 && bimbinganP2 >= 4)!
  * **Jawab:** Kode tersebut memeriksa apakah kedua syarat log bimbingan terpenuhi secara bersamaan, yaitu bimbingan Pembimbing 1 sudah mencapai minimal 8 kali **dan** bimbingan Pembimbing 2 sudah mencapai minimal 4 kali. Karena menggunakan operator && (AND), kondisi keseluruhan hanya bernilai benar apabila kedua syarat tersebut sama-sama terpenuhi.

* **Pertanyaan 3:** Bagaimana alur pemeriksaan syarat mahasiswa dari awal sampai akhir? Jelaskan secara runtut untuk semua kondisi!
  * **Jawab:** Pertama, sistem memeriksa status bebas kompen. Jika belum bebas kompen, proses berhenti dan langsung menampilkan pesan gagal. Jika sudah bebas kompen, sistem lanjut memeriksa jumlah log bimbingan pada level kedua: apabila P1 dan P2 sama-sama memenuhi syarat, mahasiswa dinyatakan boleh mendaftar; apabila keduanya belum memenuhi syarat, ditampilkan pesan bahwa keduanya kurang; apabila hanya P1 yang kurang, ditampilkan pesan khusus untuk P1; dan apabila hanya P2 yang kurang, ditampilkan pesan khusus untuk P2.

---

### 2.2 Percobaan 2: Operator Logika untuk Menentukan Akses WiFi Kampus

Percobaan ini membuat program untuk menentukan akses WiFi kampus berdasarkan status pengguna (mahasiswa/dosen) dan status blokir akun, dengan menerapkan operator logika &&, ||, dan !.

#### 2.2.1 Kode Program Java

```java
// operatorLogikaWifi28.java
import java.util.Scanner;

public class operatorLogikaWifi28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean mahasiswa;
        boolean dosen;
        boolean akunDiblokir;

        System.out.print("Apakah pengguna mahasiswa? (true/false): ");
        mahasiswa = sc.nextBoolean();

        System.out.print("Apakah pengguna dosen? (true/false): ");
        dosen = sc.nextBoolean();

        System.out.print("Apakah akun sedang diblokir? (true/false): ");
        akunDiblokir = sc.nextBoolean();

        if ((mahasiswa || dosen) && !akunDiblokir) {
            System.out.println("Akses WiFi diberikan");
        } else {
            System.out.println("Akses WiFi ditolak");
        }
    }
}
```

#### 2.2.2 Tabel Pengujian Parameter Output

| No | mahasiswa | dosen | akunDiblokir | Output yang Dihasilkan | Status Eksekusi |
| :---: | :---: | :---: | :---: | :--- | :---: |
| 1 | true | false | false | "Akses WiFi diberikan" | Valid |
| 2 | false | true | false | "Akses WiFi diberikan" | Valid |
| 3 | true | false | true | "Akses WiFi ditolak" | Valid |
| 4 | false | false | false | "Akses WiFi ditolak" | Valid |

#### 2.2.3 Jawaban Pertanyaan / Pertanyaan Refleksi

* **Pertanyaan 1:** Jelaskan fungsi operator ||, &&, dan ! pada kondisi program tersebut.
  * **Jawab:** Operator || (OR) menghasilkan nilai benar apabila salah satu dari dua kondisi bernilai benar. Operator && (AND) menghasilkan nilai benar hanya apabila kedua kondisi sama-sama bernilai benar. Operator ! (NOT) membalik nilai boolean, dari true menjadi false atau sebaliknya.

* **Pertanyaan 2:** Mengapa pengguna dosen tetap dapat memperoleh akses ketika nilai mahasiswa = false?
  * **Jawab:** Karena kondisi (mahasiswa || dosen) menggunakan operator OR, sehingga cukup salah satu bernilai benar agar keseluruhan kondisi bernilai benar. Meskipun mahasiswa bernilai false, selama dosen bernilai true, hasilnya tetap true.

* **Pertanyaan 3:** Ubah operator || menjadi &&. Jalankan kembali program menggunakan data uji 1 dan 2. Apa yang terjadi dan mengapa?
  * **Jawab:** Jika diubah menjadi (mahasiswa && dosen), maka pada data uji 1 (mahasiswa=true, dosen=false) dan data uji 2 (mahasiswa=false, dosen=true), hasilnya berubah menjadi "Akses WiFi ditolak". Hal ini terjadi karena AND mensyaratkan kedua kondisi harus bernilai benar secara bersamaan, padahal seorang pengguna biasanya hanya berstatus mahasiswa **atau** dosen saja, sehingga penggunaan AND tidak sesuai dengan logika masalah aslinya.

* **Pertanyaan 4:** Pada ekspresi mahasiswa || dosen, kapan kondisi dosen tidak perlu dievaluasi? Jelaskan berdasarkan *short-circuit evaluation*!
  * **Jawab:** Kondisi dosen tidak perlu dievaluasi apabila mahasiswa sudah bernilai true. Pada operator OR, begitu operand pertama sudah bernilai benar, hasil keseluruhan ekspresi sudah pasti benar, sehingga Java tidak perlu lagi mengevaluasi operand kedua demi efisiensi.

* **Pertanyaan 5:** Pada ekspresi (mahasiswa || dosen) && !akunDiblokir, kapan kondisi !akunDiblokir tidak perlu dievaluasi?
  * **Jawab:** Kondisi !akunDiblokir tidak perlu dievaluasi apabila hasil dari (mahasiswa || dosen) sudah bernilai false. Pada operator AND, jika operand pertama sudah bernilai salah, hasil keseluruhan ekspresi sudah pasti salah, sehingga operand kedua tidak perlu dievaluasi lagi.

---

### 2.3 Percobaan 3: Nested IF dan Operator Logika untuk Menentukan Akses Laboratorium

Percobaan ini menggabungkan Nested IF dengan operator logika untuk menentukan akses laboratorium di luar jadwal kuliah, berdasarkan status keaktifan mahasiswa, status sanksi, izin dosen, dan status asisten lab.

#### 2.3.1 Kode Program Java

```java
// nestedAksesLab28.java
import java.util.Scanner;

public class nestedAksesLab28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean mahasiswaAktif;
        boolean sedangDisanksi;
        boolean punyaIzinDosen;
        boolean asistenLab;

        System.out.print("Apakah mahasiswa berstatus aktif? (true/false): ");
        mahasiswaAktif = sc.nextBoolean();

        System.out.print("Apakah mahasiswa sedang disanksi? (true/false): ");
        sedangDisanksi = sc.nextBoolean();

        System.out.print("Apakah mahasiswa punya izin dosen? (true/false): ");
        punyaIzinDosen = sc.nextBoolean();

        System.out.print("Apakah mahasiswa asisten lab? (true/false): ");
        asistenLab = sc.nextBoolean();

        if (mahasiswaAktif && !sedangDisanksi) {
            if (punyaIzinDosen || asistenLab) {
                System.out.println("Akses laboratorium diberikan");
            } else {
                System.out.println("Akses ditolak: membutuhkan izin dosen atau status asisten lab");
            }
        } else {
            System.out.println("Akses ditolak: status mahasiswa tidak memenuhi syarat");
        }
    }
}
```

#### 2.3.2 Tabel Pengujian Parameter Output

| No | mahasiswaAktif | sedangDisanksi | punyaIzinDosen | asistenLab | Output yang Dihasilkan |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | true | false | true | false | "Akses laboratorium diberikan" |
| 2 | true | false | false | true | "Akses laboratorium diberikan" |
| 3 | true | false | false | false | "Akses ditolak: membutuhkan izin dosen atau status asisten lab" |
| 4 | false | false | true | true | "Akses ditolak: status mahasiswa tidak memenuhi syarat" |

#### 2.3.3 Jawaban Pertanyaan / Pertanyaan Refleksi

* **Pertanyaan 1:** Mengapa pemeriksaan punyaIzinDosen || asistenLab ditempatkan di dalam IF pertama?
  * **Jawab:** Karena pemeriksaan tersebut merupakan syarat kedua yang hanya relevan diperiksa apabila syarat pertama (status aktif dan tidak disanksi) sudah terpenuhi. Penempatan di dalam nested IF membuat program lebih efisien sekaligus memungkinkan pesan penolakan yang berbeda untuk tiap level kegagalan.

* **Pertanyaan 2:** Jelaskan fungsi operator &&, ||, dan ! pada program tersebut.
  * **Jawab:** Operator && digunakan untuk memastikan dua syarat terpenuhi bersamaan (mahasiswa aktif dan tidak disanksi). Operator || digunakan untuk memeriksa apakah salah satu dari dua syarat terpenuhi (izin dosen atau status asisten lab). Operator ! digunakan untuk membalik nilai sedangDisanksi, sehingga kondisi terpenuhi apabila mahasiswa **tidak** sedang disanksi.

* **Pertanyaan 3:** Apakah syarat akses dapat ditulis menjadi satu kondisi: mahasiswaAktif && !sedangDisanksi && (punyaIzinDosen || asistenLab)? Jelaskan apakah keputusan akses akhirnya sama.
  * **Jawab:** Ya, syarat dapat digabung menjadi satu kondisi tersebut, dan keputusan akhir (akses diberikan/ditolak) akan tetap sama persis, karena secara logika boolean kedua bentuk tersebut ekuivalen. Perbedaannya hanya pada kemampuan program memberikan pesan alasan penolakan yang berbeda.

* **Pertanyaan 4:** Apa keuntungan menggunakan Nested IF dibandingkan hanya satu IF jika sistem perlu menampilkan alasan penolakan yang berbeda?
  * **Jawab:** Keuntungannya adalah program dapat menampilkan pesan alasan penolakan yang lebih spesifik dan informatif, yaitu dapat membedakan apakah penolakan terjadi karena status mahasiswa tidak memenuhi syarat (level pertama) atau karena tidak adanya izin dosen maupun status asisten lab (level kedua). Jika menggunakan satu kondisi gabungan, program hanya bisa menampilkan pesan penolakan yang sama secara umum.

* **Pertanyaan 5:** Buat satu kombinasi masukan yang menyebabkan akses ditolak pada level pertama dan satu kombinasi yang menyebabkan akses ditolak pada level kedua.
  * **Jawab:**
    - **Ditolak level pertama**: mahasiswaAktif = false, sedangDisanksi = false → hasil: "Akses ditolak: status mahasiswa tidak memenuhi syarat".
    - **Ditolak level kedua**: mahasiswaAktif = true, sedangDisanksi = false, punyaIzinDosen = false, asistenLab = false → hasil: "Akses ditolak: membutuhkan izin dosen atau status asisten lab".

---

## 3: TUGAS MANDIRI

Berikut adalah daftar tugas yang dikerjakan pada Jobsheet ini:

- [x] **Tugas 1:** Mengimplementasikan sistem diskon toko buku menggunakan Nested IF.
- [x] **Tugas 2:** Membuat program sistem seleksi calon asisten praktikum.

### 3.1 Implementasi Kode Tugas 1 — Sistem Diskon Toko Buku (Latihan 2)

**Kode Program Java:**

```java
// tugas1DiskonTokoBuku28.java
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
```

### 3.2 Implementasi Kode Tugas 2 — tugas2SeleksiAsisten28.java

```java
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
```

---

## 4: KESIMPULAN

Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa struktur pemilihan bersarang (Nested IF) memungkinkan program untuk melakukan pengecekan syarat secara berlapis dan memberikan pesan yang lebih spesifik untuk setiap kondisi kegagalan, dibandingkan hanya menggunakan satu kondisi gabungan. Selain itu, operator logika &&, ||, dan ! sangat berguna untuk menyederhanakan penulisan beberapa kondisi sekaligus dalam satu ekspresi, serta memanfaatkan mekanisme *short-circuit evaluation* agar program berjalan lebih efisien.
