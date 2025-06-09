package Pekan7;

public class TugasSorting {

	
    public static void bubbleSort(char[] data, int batas) {
        for (int i = 0; i < batas - 1; i++) {
            for (int j = 0; j < batas - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    char temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
   
        char[] huruf = {
            'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q',
            'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g',
            'f', 'e', 'd', 'c', 'b', 'a'
        };
  
        bubbleSort(huruf, 16);
        for (int i = 0; i < huruf.length; i++) {
            System.out.print(huruf[i]);
            if (i != huruf.length - 1) {
                System.out.print(" - ");
            }
        }
    }
}