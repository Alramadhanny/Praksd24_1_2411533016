package Pekan4;
import java.util.LinkedList;
import java.util.Queue;

public class ContohQueue2 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		// TAMBAH ELEMEN (0, 1, 2, 3, 4, 5) KE ANTRIAN
		for (int i = 0; i < 6; i++)
			q.add(i);
		// menampilkan isi antrian.
		System.out.println("Elemen Antrian " + q);
		// UNTUK MENGHAPUS KEPALA ANTRIAN
		int hapus = q.remove();
		System.out.println("Hapus elemen = " + hapus);
		System.out.println(q);
		// untuk melihat antrian terdepan
		int depan = q.peek();
		System.out.println("Kepala Antrian = " + depan);
		
		int banyak = q.size();
		System.out.println("Size Antrian = " + banyak);
	}
}
