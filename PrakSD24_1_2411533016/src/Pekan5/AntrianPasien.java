package Pekan5;

import java.util.Scanner;

public class AntrianPasien {
    static class Node {
        int noAntrian;
        String nama;
        String keluhan;
        Node next;

        Node(int noAntrian, String nama, String keluhan) {
            this.noAntrian = noAntrian;
            this.nama = nama;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    private Node head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node baru = new Node(noAntrian, nama, keluhan);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        System.out.println("\nData pasien berhasil ditambahkan!");
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("--- Daftar Antrian Pasien ---");
        int i = 1;
        Node current = head;
        while (current != null) {
            System.out.println(i + ". [" + current.noAntrian + "] " + current.nama + " - " + current.keluhan);
            current = current.next;
            i++;
        }
    }

    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }
        System.out.println("Pasien dengan nama " + head.nama + " telah dilayani (dihapus dari antrian).");
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void cariPasien(String nama) {
        Node current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan:");
                System.out.println("Nomor Antrian: " + current.noAntrian);
                System.out.println("Nama: " + current.nama);
                System.out.println("Keluhan: " + current.keluhan);
                ditemukan = true;
                break;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    public int hitungPasien() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPasien antrian = new AntrianPasien();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN PASIEN KLINIK ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = sc.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    antrian.hapusPasienPertama();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari = sc.nextLine();
                    antrian.cariPasien(cari);
                    break;
                case 5:
                    System.out.println("Jumlah pasien saat ini: " + antrian.hitungPasien());
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem antrian.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        sc.close();
    }
}
