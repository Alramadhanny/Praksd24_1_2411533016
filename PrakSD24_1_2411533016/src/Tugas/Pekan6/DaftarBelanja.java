package Tugas.Pekan6;

public class DaftarBelanja {
    Node head, tail;

    public DaftarBelanja() {
        head = tail = null;
    }

    void tambahItem(String nama, int kuantitas, String kategori) {
        ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
        Node baru = new Node(item);

        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        System.out.println("Item berhasil ditambahkan!");
    }

    void hapusItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Item berhasil dihapus.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }

    void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }
        System.out.println("--- Daftar Belanja ---");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
            current = current.next;
        }
    }

    void tampilkanPerKategori(String kategori) {
        boolean ditemukan = false;
        Node current = head;
        System.out.println("--- Item dalam kategori '" + kategori + "' ---");
        while (current != null) {
            if (current.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.println("- " + current.data.nama + " (" + current.data.kuantitas + ")");
                ditemukan = true;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori ini.");
        }
    }

    void cariItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                System.out.println("Item ditemukan: " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }
}
