
/**
 * @author jgopalap
 * Singly linked list implementation.  Gotchas are adding element to empty list, adding at head, adding to the end of list
 * ensuring the previous and current nodes are tracked and updated within loop.
 */
public class LinkedList {
	private Node head;
	
	private class Node {
		public int data;
		public Node next;
	}
	
	public LinkedList() {
		head = null;
	}
	
	public void reverse() {
		Node prev = null;
		Node h1 = head;
		Node h2 = head.next;
		
		while(h1 != null) {
			h1.next = prev;
			prev = h1;
			h1 = h2;
			if(h2 != null) {
				h2 = h2.next;
			}
		}
		
		head = prev;
	}
	
	public void sortedAdd(LinkedList list) {
		
		if(list.head == null) {
			return;
		}
		
		if(head == null) {
			head = list.head;
			list.head = null;
			return;
		}
		
		while((list.head != null) && (list.head.data < head.data)) {
			Node n = list.head;
			list.head = n.next;
			n.next = head;
			head = n;
		}
		
		Node listN = list.head;
		Node n = head;
		Node prev = n;
		
		while ((n != null) && (listN != null)) {
			if(n.data > listN.data) {
				prev.next = list.head;
				listN = listN.next;
				prev.next.next=n;
			}
			prev = n;
			n = n.next;
		}
		
		if(listN !=null) {
			prev.next = listN;
		}
		list.head = null;
	}
	
	public void add(int val) {
		Node n = new Node();
		n.data = val;
		n.next = null;
		
		if(head == null) {
			head = n;
			return;
		} 
		
		if(head.data > val) {
			n.next = head;
			head = n;
			return;
		}
		
		Node node = head;
		Node prev = null;
		while(node != null) {
			if(node.data > val) {
				n.next = node;
				prev.next = n;
				return;
			}
			prev = node;
			node = node.next;
		}
		prev.next = n;
	}
	
	public void delete(int val) {
		if(head == null) {
			return;
		}
		
		if(head.data == val && head.next == null) {
			head = null;
			return;
		}
		
		Node n = head;
		Node prev = head;
		while(n!=null) {
			if(n.data == val) {
				prev.next = n.next;
				n.next = null;
			}
			prev = n;
			n = n.next;
		}
	}
	
	public boolean contains(int val) {
		Node n = head;
		while(n!=null) {
			if(n.data == val) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	public void print() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		
		System.out.println();
	}
	
	public static void main (String[] args){
		int a[] = {5,4,8,1,3,6,34,8723,9,5,3,238,98,374,93,34,6,90,23};
		LinkedList list = new LinkedList();
		for(int i=0; i<a.length; i++) {
			list.add(a[i]);
		}
		list.print();
		list.delete(238);
		System.out.println(list.contains(238));
		
		int b[] = {0};
		LinkedList listB = new LinkedList();
		listB.add(b[0]);
		
		list.sortedAdd(listB);
		list.print();
		
		list.reverse();
		list.print();
	}
}
