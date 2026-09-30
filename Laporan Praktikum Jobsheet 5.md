# JOBSHEET 4 - PEMILIHAN 1

**Identitas Mahasiswa:**
* **Nama:** Syauqi Khosyi Damar Agandi
* **NIM:** 264107020033
* **Kelas / No. Presensi:** TI-1D / 28

---

## 1: TUJUAN PRAKTIKUM

Berikut adalah tujuan pelaksanaan praktikum pada bab ini:

1. Mahasiswa mampu menyelesaikan permasalahan/studi kasus menggunakan sintaks pemilihan sederhana.
2. Mahasiswa mampu menerapkan sintaks pemilihan sederhana ke dalam program Java.

---

## 2: HASIL PERCOBAAN & ANALISIS

### 2.1 Percobaan 1: Penerapan IF dan IF-ELSE untuk Mencetak KRS

Percobaan ini membuat program untuk memeriksa status pelunasan UKT mahasiswa. Apabila UKT sudah lunas, sistem akan menampilkan pesan verifikasi dan izin untuk mencetak KRS. Apabila belum lunas, sistem akan menampilkan pesan penolakan registrasi.

#### 2.1.1 Kode Program Java

```java
// PemilihanIf28.java
import java.util.Scanner;

public class PemilihanIf28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Apakah UKT sudah lunas? (true/false): ");
        boolean uktLunas = sc.nextBoolean();

        if (uktLunas) {
            System.out.println("Pembayaran UKT terverifikasi");
            System.out.println("Silakan cetak KRS dan minta tanda tangan DPA");
        } else {
            System.out.println("Registrasi ditolak. Silakan lunasi UKT terlebih dahulu");
        }
    }
}
```

#### 2.1.2 Hasil Running / Screenshot Output

Contoh tampilan output dengan input `true`:
```
--- Cetak KRS SIAKAD ---
Apakah UKT sudah lunas? (true/false): true
Pembayaran UKT terverifikasi
Silakan cetak KRS dan minta tanda tangan DPA
```

Contoh tampilan output dengan input `false`:
```
--- Cetak KRS SIAKAD ---
Apakah UKT sudah lunas? (true/false): false
Registrasi ditolak. Silakan lunasi UKT terlebih dahulu
```

#### 2.1.3 Jawaban Pertanyaan / Pertanyaan Refleksi

* **Pertanyaan 1:** Nilai apa yang harus dimasukkan agar kedua baris di dalam blok IF ikut tercetak? Jelaskan mengapa hanya nilai tersebut yang diterima!
  * **Jawab:** Nilai yang harus dimasukkan adalah `true`, karena variabel `uktLunas` bertipe boolean yang hanya mengenal dua nilai, yaitu `true` dan `false`.

* **Pertanyaan 2:** Jalankan program, lalu masukkan `false`. Baris mana saja yang tercetak dan baris mana yang tidak? Jelaskan alur eksekusinya ketika kondisi IF bernilai false!
  * **Jawab:** Ketika dimasukkan `false`, hanya baris judul dan pertanyaan awal yang tercetak. Dua baris di dalam blok IF tidak ikut tercetak karena kondisinya bernilai salah, sehingga program melewati blok IF dan langsung lanjut ke baris setelahnya (blok else).

* **Pertanyaan 3:** Jalankan program, lalu masukkan `TRUE` (huruf kapital) dan `ya`. Apa yang terjadi pada masing-masing input? Jika program berhenti dengan error, jelaskan penyebabnya!
  * **Jawab:** Input `TRUE` (kapital) tetap berjalan normal karena `nextBoolean()` tidak membedakan huruf besar-kecil. Sedangkan input `ya` menyebabkan program berhenti dengan error `InputMismatchException`, karena kata tersebut bukan representasi boolean yang valid di Java.

* **Pertanyaan 4:** Modifikasi program dengan menambahkan struktur ELSE, lalu tunjukkan hasil run untuk input `true` dan `false`!
  * **Jawab:** Struktur ELSE ditambahkan berisi pesan "Registrasi ditolak. Silakan lunasi UKT terlebih dahulu" (sudah tercermin pada kode program di atas). Jika input `true`, muncul pesan verifikasi UKT; jika `false`, muncul pesan penolakan registrasi.

---

### 2.2 Percobaan 2: SWITCH-CASE untuk Mencetak KRS

Percobaan ini membuat program untuk menampilkan KRS sesuai semester mahasiswa saat ini menggunakan struktur pemilihan switch-case.

#### 2.2.1 Kode Program Java

```java
// PemilihanSwitch28.java
import java.util.Scanner;

public class PemilihanSwitch28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Masukkan semester saat ini: ");
        int semester = sc.nextInt();

        switch (semester) {
            case 1:
                System.out.println("KRS Semester 1 ditampilkan");
                break;
            case 2:
                System.out.println("KRS Semester 2 ditampilkan");
                break;
            case 3:
                System.out.println("KRS Semester 3 ditampilkan");
                break;
            case 4:
                System.out.println("KRS Semester 4 ditampilkan");
                break;
            case 5:
                System.out.println("KRS Semester 5 ditampilkan");
                break;
            case 6:
                System.out.println("KRS Semester 6 ditampilkan");
                break;
            case 7:
                System.out.println("KRS Semester 7 ditampilkan");
                break;
            case 8:
                System.out.println("KRS Semester 8 ditampilkan");
                break;
            default:
                System.out.println("Semester tidak valid");
        }
    }
}
```

#### 2.2.2 Hasil Running / Screenshot Output

```
--- Cetak KRS SIAKAD ---
Masukkan semester saat ini: 5
KRS Semester 5 ditampilkan
```

#### 2.2.3 Tabel Pengujian Parameter Output

| No | Input Parameter | Output yang Dihasilkan | Status Eksekusi |
| :---: | :--- | :--- | :---: |
| 1 | `1` | "KRS Semester 1 ditampilkan" | Valid |
| 2 | `5` | "KRS Semester 5 ditampilkan" | Valid |
| 3 | `8` | "KRS Semester 8 ditampilkan" | Valid |
| 4 | `10` | "Semester tidak valid" | Invalid |
| 5 | `0` | "Semester tidak valid" | Invalid |

#### 2.2.4 Jawaban Pertanyaan / Pertanyaan Refleksi

* **Pertanyaan 1:** Hapus perintah `break;` pada case 5, lalu compile dan jalankan kembali program dengan masukan 5. Tuliskan keluaran yang muncul, lalu jelaskan apa fungsi break!
  * **Jawab:** Keluaran yang muncul adalah "KRS Semester 5 ditampilkan" dan "KRS Semester 6 ditampilkan". Fungsi `break` adalah menghentikan eksekusi switch setelah case yang cocok dijalankan; tanpa `break`, eksekusi akan lanjut (fall-through) ke case berikutnya.

* **Pertanyaan 2:** Jalankan program dengan masukan 10, lalu dengan masukan 0. Apa keluaran yang muncul? Jelaskan peran default!
  * **Jawab:** Input 10 maupun 0 sama-sama menghasilkan "Semester tidak valid", karena keduanya tidak cocok dengan case manapun sehingga masuk ke `default`. Peran `default` adalah menangani nilai yang tidak sesuai case manapun. Jika dihapus, program tetap berjalan tanpa error, tetapi tidak menampilkan keluaran apapun untuk input yang tidak valid.

* **Pertanyaan 3:** Ganti tipe data variabel semester menjadi double, lalu compile programnya. Apakah berhasil? Sebutkan tipe data yang boleh digunakan pada switch!
  * **Jawab:** Program gagal dikompilasi dengan pesan error kurang lebih *"incompatible types: possible lossy conversion from double to int"*, karena switch tidak mengizinkan tipe data pecahan. Tipe data yang diperbolehkan sebagai ekspresi switch adalah `byte`, `short`, `char`, `int` (beserta wrapper class-nya), `enum`, dan `String`.

* **Pertanyaan 4:** Buat file `PemilihanIfElse28.java`. Ubah program SWITCH-CASE ke bentuk IF - ELSE IF - ELSE dengan keluaran yang sama persis!
  * **Jawab:** Kode hasil konversi adalah sebagai berikut. Menurut saya, switch-case lebih mudah dibaca untuk kasus ini, karena lebih ringkas dan tidak perlu mengulang kondisi `semester ==` di setiap pengecekan seperti pada if-else-if.

```java
// PemilihanIfElse28.java
import java.util.Scanner;

public class PemilihanIfElse28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Masukkan semester saat ini: ");
        int semester = sc.nextInt();

        if (semester == 1) {
            System.out.println("KRS Semester 1 ditampilkan");
        } else if (semester == 2) {
            System.out.println("KRS Semester 2 ditampilkan");
        } else if (semester == 3) {
            System.out.println("KRS Semester 3 ditampilkan");
        } else if (semester == 4) {
            System.out.println("KRS Semester 4 ditampilkan");
        } else if (semester == 5) {
            System.out.println("KRS Semester 5 ditampilkan");
        } else if (semester == 6) {
            System.out.println("KRS Semester 6 ditampilkan");
        } else if (semester == 7) {
            System.out.println("KRS Semester 7 ditampilkan");
        } else if (semester == 8) {
            System.out.println("KRS Semester 8 ditampilkan");
        } else {
            System.out.println("Semester tidak valid");
        }
    }
}
```

---

## 3: TUGAS MANDIRI

Berikut adalah daftar tugas yang dikerjakan pada Jobsheet ini:

- [x] **Tugas 1:** Mengubah struktur `if-else` pada PemilihanIf28.java menjadi *Ternary Operator*.
- [x] **Tugas 2:** Membuat program berdasarkan *Flowchart* penentuan validasi SKS.
- [x] **Tugas 3:** Mengimplementasikan studi kasus sistem parkir & mesin antrean akademik.

### 3.1 Implementasi Kode Tugas 1 — Tugas1Pemilihan28.java

```java
import java.util.Scanner;

public class Tugas1Pemilihan28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Cetak KRS SIAKAD ---");
        System.out.print("Apakah UKT sudah lunas? (true/false): ");
        boolean uktLunas = sc.nextBoolean();

        String pesan = uktLunas
                ? "Pembayaran UKT terverifikasi\nSilakan cetak KRS dan minta tanda tangan DPA"
                : "Registrasi ditolak. Silakan lunasi UKT terlebih dahulu";

        System.out.println(pesan);
    }
}
```

*Catatan:* Ternary operator lebih baik digunakan untuk keputusan sederhana yang hanya memilih satu dari dua nilai untuk disimpan ke variabel, sehingga kode lebih ringkas. Sebaiknya dihindari jika logikanya kompleks atau melibatkan banyak instruksi, karena dapat menurunkan keterbacaan kode.

### 3.2 Implementasi Kode Tugas 2 — Tugas2Pemilihan28.java

```java
import java.util.Scanner;

public class Tugas2Pemilihan28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah SKS: ");
        int jumlahSks = sc.nextInt();

        if (jumlahSks > 24) {
            System.out.println("Melebihi batas");
        } else {
            System.out.println("KRS valid");
        }
    }
}
```

### 3.3 Implementasi Kode Tugas 3 — Sistem Parkir & Mesin Antrean

**a. TugasParkir28.java** (struktur IF-ELSE)

```java
import java.util.Scanner;

public class TugasParkir28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan lama parkir (jam): ");
        int lamaParkir = sc.nextInt();

        int tarifDasar = 2000;
        int tarifTambahan = 1000;
        int totalBiaya;

        if (lamaParkir <= 2) {
            totalBiaya = tarifDasar;
        } else {
            int jamLebih = lamaParkir - 2;
            totalBiaya = tarifDasar + (jamLebih * tarifTambahan);
        }

        System.out.println("Lama parkir: " + lamaParkir + " jam");
        System.out.println("Total biaya parkir: Rp. " + totalBiaya);
    }
}
```

**b. TugasAntrean28.java** (struktur SWITCH-CASE)

```java
import java.util.Scanner;

public class TugasAntrean28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kode layanan: ");
        int kodeLayanan = sc.nextInt();

        switch (kodeLayanan) {
            case 1:
                System.out.println("Layanan: Legalisir Ijazah");
                System.out.println("Silakan menuju Loket A");
                break;
            case 2:
                System.out.println("Layanan: Surat Keterangan Aktif Kuliah");
                System.out.println("Silakan menuju Loket B");
                break;
            case 3:
                System.out.println("Layanan: Pembayaran UKT");
                System.out.println("Silakan menuju Loket C");
                break;
            case 4:
                System.out.println("Layanan: Pengajuan Cuti Akademik");
                System.out.println("Silakan menuju Loket D");
                break;
            default:
                System.out.println("Kode layanan tidak tersedia");
        }
    }
}
```

---

## 4: KESIMPULAN

Berdasarkan praktikum yang telah dilakukan, dapat disimpulkan bahwa struktur pemilihan (IF, IF-ELSE, dan SWITCH-CASE) sangat penting digunakan untuk mengatur alur jalannya program (*flow control*) berdasarkan kondisi atau pilihan yang ditentukan oleh pengguna. IF-ELSE lebih fleksibel untuk kondisi berbasis rentang nilai atau boolean, sedangkan SWITCH-CASE lebih rapi digunakan untuk kondisi dengan nilai diskret yang jumlahnya banyak. Selain itu, Ternary Operator dapat digunakan sebagai bentuk penyederhanaan IF-ELSE untuk kasus keputusan dua nilai yang sederhana.
