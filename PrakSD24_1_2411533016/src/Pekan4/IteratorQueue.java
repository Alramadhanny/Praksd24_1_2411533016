package Pekan4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class IteratorQueue {
    public static void main(String[] args) {
    	
        Queue<String> q = new LinkedList<>();
        q.add("Praktikum");
        q.add("Struktur");
        q.add("Data");
        q.add("Dan");
        q.add("Algoritma");

        Iterator<String> iterator = q.iterator();
        
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}