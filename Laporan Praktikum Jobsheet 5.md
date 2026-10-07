# JOBSHEET 6 - PEMILIHAN 2

**Identitas Mahasiswa:**
* **Nama:** Syauqi Khosyi Damar Agandi
* **NIM:** 264107020033
* **Kelas / No. Presensi:** TI-1D / 28

---

## 1: TUJUAN PRAKTIKUM

Berikut adalah tujuan pelaksanaan praktikum pada bab ini:

1. Mahasiswa mampu menyelesaikan permasalahan/studi kasus menggunakan sintaks pemilihan bersarang (*nested if*).
2. Mahasiswa mampu menerapkan sintaks pemilihan bersarang ke dalam program Java.
3. Mahasiswa mampu menerapkan operator logika `&&`, `||`, dan `!` pada struktur pemilihan.

---

## 2: HASIL PERCOBAAN & ANALISIS

### 2.1 Percobaan 1: Nested IF untuk Mengecek Syarat Ujian Skripsi

Pada percobaan ini dibuat program yang memeriksa syarat pendaftaran ujian skripsi. Level pertama memeriksa status bebas kompen, dan jika terpenuhi, level kedua memeriksa jumlah log bimbingan (minimal 8 kali dengan Pembimbing 1 dan minimal 4 kali dengan Pembimbing 2). Jika ada syarat yang tidak terpenuhi, program menampilkan alasan kegagalan.

#### 2.1.1 Kode Program Java
```java
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

#### 2.1.2 Hasil Running / Output
Berikut adalah tampilan *output* setelah program dijalankan dengan masukan `ya`, `6`, dan `5`:

```text
Apakah mahasiswa sudah bebas kompen? (Ya/Tidak): ya
Masukkan jumlah log bimbingan Pembimbing 1: 6
Masukkan jumlah log bimbingan Pembimbing 2: 5
Gagal! Log bimbingan P1 belum mencapai 8 kali
```

Hasil pengujian dengan variasi masukan lain:

| No | Bebas Kompen | Bimbingan P1 | Bimbingan P2 | Output yang Dihasilkan |
| :---: | :---: | :---: | :---: | :--- |
| 1 | Ya | 8 | 4 | Semua syarat terpenuhi. Mahasiswa boleh mendaftar ujian skripsi |
| 2 | Ya | 6 | 5 | Gagal! Log bimbingan P1 belum mencapai 8 kali |
| 3 | Ya | 9 | 2 | Gagal! Log bimbingan P2 belum mencapai 4 kali |
| 4 | Ya | 5 | 2 | Gagal! Log bimbingan P1 kurang dari 8 kali dan P2 kurang dari 4 kali |
| 5 | Tidak | 10 | 6 | Gagal! Mahasiswa masih memiliki tanggungan kompen |

#### 2.1.3 Jawaban Pertanyaan
* **Pertanyaan 1:** Apa yang terjadi jika mahasiswa menjawab "No" pada pertanyaan bebas kompen? Mengapa demikian?
  * **Jawab:** Program akan menampilkan pesan **"Gagal! Mahasiswa masih memiliki tanggungan kompen"**. Hal ini terjadi karena kondisi `bebasKompen.equalsIgnoreCase("Ya")` bernilai `false` (jawaban "No" tidak sama dengan "Ya"), sehingga program langsung masuk ke blok `else` pada level pertama dan **tidak memeriksa** log bimbingan di level kedua. Perlu dicatat, jawaban apa pun selain "Ya" (misalnya "Tidak", "Yes", atau "Ye") juga akan diperlakukan sebagai belum bebas kompen. Selain itu, program tetap meminta input jumlah bimbingan karena kedua input tersebut dibaca sebelum struktur `if` dijalankan.

* **Pertanyaan 2:** Jelaskan maksud dari potongan kode `if (bimbinganP1 >= 8 && bimbinganP2 >= 4) {`
  * **Jawab:** Potongan kode tersebut memeriksa dua syarat sekaligus menggunakan operator logika AND (`&&`). Syarat pertama `bimbinganP1 >= 8` bernilai `true` jika bimbingan dengan Pembimbing 1 minimal 8 kali, dan syarat kedua `bimbinganP2 >= 4` bernilai `true` jika bimbingan dengan Pembimbing 2 minimal 4 kali. Karena memakai `&&`, blok `if` hanya dieksekusi apabila **kedua syarat terpenuhi**. Jika salah satu saja `false`, maka kondisi keseluruhan `false` dan program berpindah ke `else if` berikutnya.

* **Pertanyaan 3:** Bagaimana alur pemeriksaan syarat mahasiswa dari awal sampai akhir? Jelaskan secara runtut untuk semua kondisi!
  * **Jawab:**
    1. Program menerima input status kompen (`bebasKompen`) dan jumlah log bimbingan (`bimbinganP1`, `bimbinganP2`).
    2. **Level 1:** diperiksa `bebasKompen.equalsIgnoreCase("Ya")`.
       * Jika `false` → `pesan = "Gagal! Mahasiswa masih memiliki tanggungan kompen"` dan pemeriksaan selesai.
       * Jika `true` → lanjut ke level 2.
    3. **Level 2** (diperiksa berurutan dari atas):
       * `bimbinganP1 >= 8 && bimbinganP2 >= 4` → semua syarat terpenuhi, mahasiswa boleh mendaftar ujian skripsi.
       * `bimbinganP1 < 8 && bimbinganP2 < 4` → gagal karena P1 kurang dari 8 kali **dan** P2 kurang dari 4 kali.
       * `bimbinganP1 < 8` → gagal karena hanya P1 yang belum mencapai 8 kali (P2 sudah cukup).
       * `else` → gagal karena hanya P2 yang belum mencapai 4 kali (P1 sudah cukup).
    4. Terakhir, isi variabel `pesan` ditampilkan dengan `System.out.println(pesan)`.

---

### 2.2 Percobaan 2: Operator Logika untuk Menentukan Akses WiFi Kampus

Percobaan ini mempraktikkan operator logika `&&` (AND), `||` (OR), dan `!` (NOT). Akses WiFi diberikan apabila pengguna adalah mahasiswa atau dosen, dan akunnya tidak sedang diblokir.

#### 2.2.1 Kode Program Java
```java
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

#### 2.2.2 Hasil Running / Output
Contoh tampilan *output* (Uji 1: `true`, `false`, `false`):

```text
Apakah pengguna mahasiswa? (true/false): true
Apakah pengguna dosen? (true/false): false
Apakah akun sedang diblokir? (true/false): false
Akses WiFi diberikan
```

#### 2.2.3 Tabel Pengujian Parameter Output

| Uji | mahasiswa | dosen | akunDiblokir | Output yang Dihasilkan | Status Akses |
| :---: | :---: | :---: | :---: | :--- | :---: |
| 1 | true | false | false | Akses WiFi diberikan | Diberikan |
| 2 | false | true | false | Akses WiFi diberikan | Diberikan |
| 3 | true | false | true | Akses WiFi ditolak | Ditolak |
| 4 | false | false | false | Akses WiFi ditolak | Ditolak |

#### 2.2.4 Jawaban Pertanyaan
* **Pertanyaan 1:** Jelaskan fungsi operator `||`, `&&`, dan `!` pada kondisi program tersebut.
  * **Jawab:**
    * `||` (OR) pada `mahasiswa || dosen` bernilai `true` jika salah satu atau keduanya `true`, sehingga pengguna yang berstatus mahasiswa **atau** dosen sama-sama memenuhi syarat identitas.
    * `&&` (AND) menggabungkan hasil `(mahasiswa || dosen)` dengan `!akunDiblokir`. Akses hanya diberikan jika **kedua** bagian tersebut `true`.
    * `!` (NOT) membalik nilai boolean. `!akunDiblokir` bernilai `true` ketika akun **tidak** diblokir (`akunDiblokir = false`).

* **Pertanyaan 2:** Mengapa pengguna dosen tetap dapat memperoleh akses ketika nilai mahasiswa = false?
  * **Jawab:** Karena kedua variabel dihubungkan dengan operator OR (`||`). Operator ini cukup membutuhkan satu operand yang bernilai `true`. Saat `mahasiswa = false` dan `dosen = true`, ekspresi `(false || true)` menghasilkan `true`. Selama akun tidak diblokir (`!akunDiblokir` = `true`), maka `true && true` = `true` dan akses diberikan (lihat Uji 2).

* **Pertanyaan 3:** Ubah operator `||` menjadi `&&`. Jalankan kembali program menggunakan data uji 1 dan 2. Apa yang terjadi dan mengapa?
  * **Jawab:** Kondisi menjadi `if ((mahasiswa && dosen) && !akunDiblokir)`. Hasilnya:

    | Uji | mahasiswa | dosen | akunDiblokir | Output setelah diubah |
    | :---: | :---: | :---: | :---: | :--- |
    | 1 | true | false | false | Akses WiFi ditolak |
    | 2 | false | true | false | Akses WiFi ditolak |

    Pada Uji 1, `true && false` = `false`. Pada Uji 2, `false && true` = `false`. Akibatnya kondisi `if` tidak terpenuhi dan program masuk ke `else`. Hal ini terjadi karena operator `&&` mensyaratkan pengguna **sekaligus** mahasiswa dan dosen, padahal umumnya pengguna hanya salah satunya. Dengan demikian mahasiswa saja atau dosen saja tidak akan pernah mendapat akses, dan logika program tidak sesuai dengan kasus.

* **Pertanyaan 4:** Pada ekspresi `mahasiswa || dosen`, kapan kondisi `dosen` tidak perlu dievaluasi? Jelaskan berdasarkan *short-circuit evaluation*.
  * **Jawab:** Kondisi `dosen` tidak perlu dievaluasi ketika `mahasiswa` bernilai `true`. Pada operator `||`, jika operand kiri sudah `true`, hasil keseluruhan pasti `true` apa pun nilai operand kanan. Java menerapkan *short-circuit evaluation*, yaitu berhenti mengevaluasi sisa ekspresi ketika hasilnya sudah dapat dipastikan. Operand kanan baru dievaluasi apabila `mahasiswa` bernilai `false`.

* **Pertanyaan 5:** Pada ekspresi `(mahasiswa || dosen) && !akunDiblokir`, kapan kondisi `!akunDiblokir` tidak perlu dievaluasi? Jelaskan.
  * **Jawab:** Kondisi `!akunDiblokir` tidak perlu dievaluasi ketika `(mahasiswa || dosen)` bernilai `false`, yaitu saat `mahasiswa = false` dan `dosen = false` (seperti Uji 4). Pada operator `&&`, jika operand kiri sudah `false`, hasil keseluruhan pasti `false` apa pun nilai operand kanan, sehingga Java langsung melewati evaluasi `!akunDiblokir` (*short-circuit*).

---

### 2.3 Percobaan 3: Nested IF dan Operator Logika untuk Menentukan Akses Laboratorium

Percobaan ini menggabungkan pemilihan bersarang dengan operator logika. Level pertama memeriksa mahasiswa aktif dan tidak sedang disanksi, sedangkan level kedua memeriksa kepemilikan izin dosen atau status asisten laboratorium.

#### 2.3.1 Kode Program Java
```java
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

#### 2.3.2 Hasil Running / Output
Contoh tampilan *output* (masukan `true`, `false`, `true`, `false`):

```text
Apakah mahasiswa berstatus aktif? (true/false): true
Apakah mahasiswa sedang disanksi? (true/false): false
Apakah mahasiswa punya izin dosen? (true/false): true
Apakah mahasiswa asisten lab? (true/false): false
Akses laboratorium diberikan
```

#### 2.3.3 Tabel Pengujian Parameter Output

| No | mahasiswaAktif | sedangDisanksi | punyaIzinDosen | asistenLab | Output yang Dihasilkan |
| :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | true | false | true | false | Akses laboratorium diberikan |
| 2 | true | false | false | true | Akses laboratorium diberikan |
| 3 | true | false | false | false | Akses ditolak: membutuhkan izin dosen atau status asisten lab |
| 4 | false | false | true | true | Akses ditolak: status mahasiswa tidak memenuhi syarat |
| 5 | true | true | true | true | Akses ditolak: status mahasiswa tidak memenuhi syarat |

Dari tabel di atas, ketiga kemungkinan keluaran program (akses diberikan, ditolak di level kedua, dan ditolak di level pertama) sudah pernah muncul.

#### 2.3.4 Jawaban Pertanyaan
* **Pertanyaan 1:** Mengapa pemeriksaan `punyaIzinDosen || asistenLab` ditempatkan di dalam IF pertama?
  * **Jawab:** Karena izin dosen atau status asisten lab hanya relevan apabila mahasiswa sudah memenuhi syarat dasar, yaitu aktif dan tidak sedang disanksi. Dengan menempatkannya di dalam IF pertama, pemeriksaan tersebut hanya dilakukan jika syarat level pertama terpenuhi. Mahasiswa yang tidak aktif atau sedang disanksi akan langsung ditolak walaupun memiliki izin dosen atau berstatus asisten lab.

* **Pertanyaan 2:** Jelaskan fungsi operator `&&`, `||`, dan `!` pada program tersebut.
  * **Jawab:**
    * `&&` pada `mahasiswaAktif && !sedangDisanksi` mensyaratkan mahasiswa aktif **dan** tidak sedang disanksi, keduanya harus terpenuhi.
    * `!` pada `!sedangDisanksi` membalik nilai `sedangDisanksi`, sehingga bernilai `true` apabila mahasiswa **tidak** sedang disanksi.
    * `||` pada `punyaIzinDosen || asistenLab` bernilai `true` apabila mahasiswa memiliki izin dosen **atau** berstatus asisten lab, cukup salah satu.

* **Pertanyaan 3:** Apakah syarat akses dapat ditulis menjadi satu kondisi: `mahasiswaAktif && !sedangDisanksi && (punyaIzinDosen || asistenLab)`? Jelaskan apakah keputusan akses akhirnya sama.
  * **Jawab:** Ya, bisa. Kondisi gabungan tersebut bernilai `true` hanya jika mahasiswa aktif, tidak disanksi, dan punya izin dosen atau asisten lab, yang persis sama dengan syarat pada Nested IF. Jadi **keputusan akhirnya (diberikan atau ditolak) sama**. Perbedaannya, dengan satu kondisi program hanya bisa menampilkan satu jenis pesan penolakan, sedangkan Nested IF dapat membedakan alasan penolakan.

* **Pertanyaan 4:** Apa keuntungan menggunakan Nested IF pada kasus ini dibandingkan hanya satu IF jika sistem perlu menampilkan alasan penolakan yang berbeda?
  * **Jawab:** Nested IF memungkinkan program membedakan **di tahap mana** mahasiswa gagal. Penolakan di level pertama berarti status mahasiswa tidak memenuhi syarat (tidak aktif atau disanksi), sedangkan penolakan di level kedua berarti mahasiswa belum punya izin dosen atau status asisten lab. Dengan satu IF, semua kegagalan jatuh ke satu `else` sehingga alasan penolakan tidak dapat dibedakan. Struktur bertingkat juga lebih mudah dibaca dan dikembangkan karena alurnya mengikuti urutan pemeriksaan.

* **Pertanyaan 5:** Buat satu kombinasi masukan yang menyebabkan akses ditolak pada level pertama dan satu kombinasi yang menyebabkan akses ditolak pada level kedua.
  * **Jawab:**

    | Level Penolakan | mahasiswaAktif | sedangDisanksi | punyaIzinDosen | asistenLab | Output |
    | :--- | :---: | :---: | :---: | :---: | :--- |
    | Level pertama | true | true | true | false | Akses ditolak: status mahasiswa tidak memenuhi syarat |
    | Level kedua | true | false | false | false | Akses ditolak: membutuhkan izin dosen atau status asisten lab |

---

## 3: TUGAS MANDIRI

Berikut adalah daftar tugas yang dikerjakan pada Jobsheet ini:

- [x] **Tugas 1:** Implementasi flowchart sistem diskon toko buku ke dalam program Java.
- [x] **Tugas 2:** Program seleksi calon asisten praktikum dengan pemilihan bersarang dan operator logika.

### 3.1 Implementasi Kode Tugas 1: Diskon Toko Buku

Program menghitung diskon pembelian buku berdasarkan jenis buku dan jumlah buku yang dibeli.

```java
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

**Tabel Pengujian Tugas 1:**

| No | Nama Buku | Jumlah | Diskon yang Didapat |
| :---: | :--- | :---: | :---: |
| 1 | Kamus | 2 | 10% |
| 2 | Kamus | 3 | 12% |
| 3 | Novel | 3 | 8% |
| 4 | Novel | 5 | 9% |
| 5 | Majalah | 4 | 5% |
| 6 | Majalah | 2 | 0% |

**Contoh Output:**

```text
Masukkan nama buku :
Kamus
jumlah buku yang dibeli :
3
---Toko Buku---
Buku yang dibeli : Kamus
Jumlah buku yang dibeli : 3
Diskon yang didapat : 12%
```

### 3.2 Implementasi Kode Tugas 2: Seleksi Calon Asisten Praktikum

Program menyeleksi calon asisten dalam tiga tahap: (1) berstatus aktif dan tidak terkena sanksi akademik, (2) nilai Dasar Pemrograman minimal 80 atau memiliki sertifikat pemrograman, (3) nilai wawancara minimal 75. Alasan kegagalan ditampilkan pada setiap tahap.

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

**Tabel Pengujian Tugas 2:**

| No | Aktif | Sanksi | Nilai Daspro | Sertifikat | Wawancara | Hasil |
| :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| 1 | true | false | 85 | false | 80 | Selamat! Mahasiswa lulus seleksi sebagai asisten praktikum |
| 2 | true | false | 70 | true | 75 | Selamat! Mahasiswa lulus seleksi sebagai asisten praktikum |
| 3 | true | false | 90 | false | 70 | Gagal pada tahap wawancara (nilai kurang dari 75) |
| 4 | true | false | 70 | false | - | Gagal pada tahap 2 (nilai kurang dari 80 dan tidak punya sertifikat) |
| 5 | true | true | - | - | - | Gagal: mahasiswa sedang menjalani sanksi akademik |
| 6 | false | false | - | - | - | Gagal: bukan mahasiswa aktif |

**Contoh Output (Pengujian 1):**

```text
---Seleksi Calon Asisten---
Apakah mahasiswa aktif? (true/false):
true
Apakah mahasiswa sedang terkena sanksi akademik? (true/false):
false
Mahasiswa aktif dan tidak sedang menjalankan sanksi
Mahasiswa lulus seleksi awal
Berapa nilai daspro mahasiswa?:
85
Apakah mahasiswa memiliki sertifikat Prohamming? (true/false);
false
Mahasiswa lulus seleksi tahap 2
Masukkan nilai wawancara :
80
Selamat! Mahasiswa lulus seleksi sebagai asisten praktikum
```

---

## 4: KESIMPULAN

Berdasarkan praktikum Jobsheet 6, dapat disimpulkan bahwa struktur pemilihan bersarang (*nested if*) sangat berguna untuk memeriksa syarat yang bertingkat, sehingga program dapat menampilkan alasan kegagalan yang berbeda pada setiap tahap pemeriksaan. Operator logika `&&`, `||`, dan `!` memungkinkan beberapa kondisi digabungkan dalam satu ekspresi: `&&` mensyaratkan seluruh kondisi benar, `||` cukup membutuhkan salah satu kondisi benar, dan `!` membalik nilai boolean. Selain itu, Java menerapkan *short-circuit evaluation* sehingga operand kanan tidak dievaluasi apabila hasil ekspresi sudah dapat dipastikan dari operand kiri. Penggabungan nested if dengan operator logika terbukti efektif dalam menyelesaikan studi kasus seperti pendaftaran ujian skripsi, akses WiFi, akses laboratorium, diskon toko buku, dan seleksi asisten praktikum.