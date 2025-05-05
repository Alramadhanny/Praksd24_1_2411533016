package Pekan2;
import java.util.ArrayList;
import java.util.Scanner;

public class Tugas {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Parkiran parkiran = new Parkiran();
		int pilihan;
		
		do {
			System.out.println("\n=== Menu Parkiran Mobil ===");
			System.out.println("1. Tambah mobil ke Parkiran");
			System.out.println("2. Keluarkan mobil dari Parkiran");
			System.out.println("3. Tampilkan isi Parkiran");
			System.out.println("4. Cari mobil di Parkiran");
			System.out.println("5. Keluar");
			System.out.print("Pilih Opsi: ");
			pilihan = input.nextInt();
			input.nextLine();
			
			switch (pilihan) {
				case 1:
					System.out.print("Masukkan plat nomor: ");
					String platMasuk = input.nextLine();
					parkiran.tambahMobil(platMasuk);
					break;
				case 2:
					System.out.print("Masukkan plat nomor yang akan keluar: ");
					String platKeluar = input.nextLine();
					parkiran.keluarkanMobil(platKeluar);
					break;
				case 3:
					parkiran.tampilkanParkiran();
					break;
				case 4:
					System.out.print("Masukkan plat nomor yang dicari: ");
					String platCari = input.nextLine();
					parkiran.cariMobil(platCari);
					break;
				case 5:
					System.out.println("Terima kasih telah menggunakan program.");
					break;
				default:
					System.out.println("Opsi tidak valid. Coba lagi.");	
			}
		} while (pilihan != 5);
		
		input.close();
	}
}

class Mobil {
	private String platNomor;
	
	public Mobil(String platNomor) {
		this.platNomor = platNomor;
	}
	
	public String getPlatNomor() {
		return platNomor;
	}
}

class Parkiran {
	private ArrayList<Mobil> daftarMobil;
	
	public Parkiran() {
		daftarMobil = new ArrayList<>();
		tambahMobil("BA1111AA");
	    tambahMobil("BA2222BB");
	    tambahMobil("BA3333CC");
	    tambahMobil("BA4444DD");
	    tambahMobil("BA5555EE");
	    tambahMobil("BA6666FF");
	    tambahMobil("BA7777GG");
	}
	
	public void tambahMobil(String platNomor) {
		daftarMobil.add(new Mobil(platNomor));
		System.out.println("Mobil dengan plat " + platNomor + " berhasil ditambahkan.");
	}
	
	public void keluarkanMobil(String platNomor) {
		for (int i = 0; i < daftarMobil.size(); i++) {
			if (daftarMobil.get(i).getPlatNomor().equalsIgnoreCase(platNomor)) {
				daftarMobil.remove(i);
				System.out.println("Mobil dengan plat " + platNomor + " berhasil dikeluarkan.");
				return;
			}
		}
		System.out.println("Mobil dengan plat " + platNomor + " tidak ditemukan.");
	}

	public void tampilkanParkiran() {
		if (daftarMobil.isEmpty()) {
			System.out.println("Parkiran kosong.");
		} else {
			System.out.println("Daftar mobil di parkiran:");
			for (Mobil m : daftarMobil) {
				System.out.println("- " + m.getPlatNomor());
			}
		}
	}
	
	public void cariMobil(String platNomor) {
		for (Mobil m : daftarMobil) {
			if (m.getPlatNomor().equalsIgnoreCase(platNomor)) {
				System.out.println("Mobil dengan plat " + platNomor + " ditemukan di parkiran.");
				return;
			}
		}
		System.out.println("Mobil dengan plat " + platNomor + " tidak ada di parkiran.");
	}
}	