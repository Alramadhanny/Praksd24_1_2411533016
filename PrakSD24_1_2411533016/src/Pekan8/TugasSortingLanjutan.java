package Pekan8;

// Nama: Abdullah Al Ramadhani
// NIM: 2411533016

import java.util.*;

public class TugasSortingLanjutan {
    
    // Fungsi untuk menghasilkan deret bilangan prima dari 1 sampai 50
    public static List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            boolean isPrime = true;
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }
        return primes;
    }

    // Fungsi utama Merge Sort dengan tampilan setiap proses merge
    public static void mergeSort(int[] arr, int left, int right, int step) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid, step);
            mergeSort(arr, mid + 1, right, step);

            merge(arr, left, mid, right, step);
        }
    }

    // Fungsi merge dengan tampilan array setelah merge
    public static void merge(int[] arr, int left, int mid, int right, int stepCounter) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];

        // Tampilkan langkah setelah merge
        System.out.println("Langkah " + (++stepCounter) + ": " + Arrays.toString(arr));
        stepCount = stepCounter; // update global step
    }

    static int stepCount = 0;

    public static void main(String[] args) {
        List<Integer> primesList = generatePrimes(50);
        int[] primes = primesList.stream().mapToInt(i -> i).toArray();

        System.out.println("Deret awal: " + Arrays.toString(primes));
        System.out.println("Algoritma: Merge Sort");
        
        mergeSort(primes, 0, primes.length - 1, stepCount);

        System.out.println("Hasil: " + Arrays.toString(primes));
    }
}
