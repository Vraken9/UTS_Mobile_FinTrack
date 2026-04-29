# FinTrack - Aplikasi Pencatat Keuangan Mobile (Projek UAS)

## Identitas Kelompok / Mahasiswa
- Nama: [Kosongkan untuk diisi user]
- NIM: [Kosongkan untuk diisi user]
- Mata Kuliah: Pemrograman Mobile
- Program Studi: Teknik Informatika

## Deskripsi Aplikasi
FinTrack adalah aplikasi mobile native berbasis Android yang dirancang untuk membantu mahasiswa mengelola arus kas (pemasukan dan pengeluaran) secara efisien. Aplikasi ini dibangun dengan arsitektur MVC dan antarmuka "Clean UI" minimalis untuk memberikan pengalaman pengguna yang elegan dan ringan.

## Fitur Utama (CRUD & Analitik)
1. **Pencatatan Dinamis:** Mendukung pencatatan Pemasukan, Pengeluaran, dan Transfer.
2. **Manajemen Transaksi (CRUD):** Pengguna dapat Menambah, Membaca, Mengubah (Edit), dan Menghapus (Delete) riwayat transaksi.
3. **Analitik Visual:** Menyajikan visualisasi data pengeluaran mingguan dan bulanan menggunakan Bar Chart interaktif (MPAndroidChart).
4. **Kategori Dinamis:** Pengguna dapat menambahkan kategori baru atau metode pembayaran secara kustom (disimpan via SharedPreferences).
5. **Split Bill (Patungan):** Kalkulator otomatis untuk membagi tagihan pengeluaran bersama teman.

## Teknologi & Library yang Digunakan
- **Bahasa Pemrograman:** Java
- **Database Lokal:** Room Database (SQLite) dengan eksekusi Background Thread (ExecutorService)
- **Arsitektur:** MVC (Model-View-Controller) / Fragment Navigation
- **UI Components:** Material Design, BottomNavigationView
- **Visualisasi Data:** MPAndroidChart (PhilJay)
