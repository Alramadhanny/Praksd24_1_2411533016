package Pekan6;

public class NodeDLL {
	// mendefinisakan kelas node
	int data; // data
	NodeDLL next; // pointer ke next node
	NodeDLL prev; // pointer ke previous node
	
	// kontsruktor
	public NodeDLL(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
