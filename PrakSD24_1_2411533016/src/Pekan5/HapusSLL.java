package Pekan5;

public class HapusSLL {
	    // Fungsi untuk menghapus head
	    public static NodeSLL deleteHead(NodeSLL head) {
	        if (head == null)
	            return null;
	        return head.next;
	    }

	    // Fungsi menghapus node terakhir
	    public static NodeSLL removeLastNode(NodeSLL head) {
	        if (head == null || head.next == null)
	            return null;

	        NodeSLL secondLast = head;
	        while (secondLast.next.next != null) {
	            secondLast = secondLast.next;
	        }

	        secondLast.next = null;
	        return head;
	    }

	    // Fungsi menghapus node di posisi tertentu (index mulai dari 0)
	    public static NodeSLL deleteNode(NodeSLL head, int position) {
	        if (head == null)
	            return null;

	        if (position == 0) {
	            return head.next;
	        }

	        NodeSLL temp = head;
	        for (int i = 0; i < position - 1; i++) {
	            if (temp == null || temp.next == null) {
	                System.out.println("Posisi tidak valid!");
	                return head;
	            }
	            temp = temp.next;
	        }

	        if (temp.next == null) {
	            System.out.println("Posisi tidak valid!");
	            return head;
	        }

	        temp.next = temp.next.next;
	        return head;
	    }

	    // Fungsi mencetak isi Linked List
	    public static void printList(NodeSLL head) {
	        NodeSLL curr = head;
	        while (curr != null) {
	            System.out.print(curr.data + " --> ");
	            curr = curr.next;
	        }
	        System.out.println("null");
	    }

	    // Main method
	    public static void main(String[] args) {
	        // Buat Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
	        NodeSLL head = new NodeSLL(1);
	        head.next = new NodeSLL(2);
	        head.next.next = new NodeSLL(3);
	        head.next.next.next = new NodeSLL(4);
	        head.next.next.next.next = new NodeSLL(5);
	        head.next.next.next.next.next = new NodeSLL(6);

	        System.out.println("List awal:");
	        printList(head);

	        // Hapus head
	        head = deleteHead(head);
	        System.out.println("Setelah head dihapus:");
	        printList(head);

	        // Hapus node terakhir
	        head = removeLastNode(head);
	        System.out.println("Setelah node terakhir dihapus:");
	        printList(head);

	        // Hapus node di posisi ke-2 (index 0-based)
	        int posisi = 2;
	        head = deleteNode(head, posisi);
	        System.out.println("Setelah node di posisi " + posisi + " dihapus:");
	        printList(head);
	    }
	}
