package Tugas.Pekan6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaftarBelanja daftar = new DaftarBelanja();
        int pilihan;

        do {
            System.out.println("\n=== MENU DAFTAR BELANJA ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Tampilkan Item Berdasarkan Kategori");
            System.out.println("5. Cari Item");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan kuantitas: ");
                    int kuantitas = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan kategori: ");
                    String kategori = sc.nextLine();
                    daftar.tambahItem(nama, kuantitas, kategori);
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String namaHapus = sc.nextLine();
                    daftar.hapusItem(namaHapus);
                    break;
                case 3:
                    daftar.tampilkanSemuaItem();
                    break;
                case 4:
                    System.out.print("Masukkan kategori: ");
                    String kategoriTampil = sc.nextLine();
                    daftar.tampilkanPerKategori(kategoriTampil);
                    break;
                case 5:
                    System.out.print("Masukkan nama item: ");
                    String namaCari = sc.nextLine();
                    daftar.cariItem(namaCari);
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
        sc.close();
    }
}
