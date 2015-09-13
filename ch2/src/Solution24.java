
public class Solution24 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	
	/**
	 * To rearrange the list so that all nodes with smaller value than x put in the front of the list
	 * Algorithm: iterate the whole list, store smaller nodes and other nodes in separated place.
	 *   After that, merge them.
	 * Complexity: O(N) to iterate the whole list.
	 */
	public static SinglyLinkedList partition(SinglyLinkedList head, int x) {
		SinglyLinkedList smallerHead = new SinglyLinkedList(0);
		SinglyLinkedList smallerTail = smallerHead;
		SinglyLinkedList biggerOrEqualHead = new SinglyLinkedList(0);
		SinglyLinkedList biggerOrEqualTail = biggerOrEqualHead;

		SinglyLinkedList node = head;
		while (node != null) {
			if (node.value < x) {
				smallerTail.next = node;
				smallerTail = smallerTail.next;
			}
			else {
				biggerOrEqualTail.next = node;
				biggerOrEqualTail = biggerOrEqualTail.next;
			}
			node = node.next;
		}
		
		biggerOrEqualTail.next = null;
		smallerTail.next = biggerOrEqualHead.next;
		return smallerHead.next;
	}

	public static void print(SinglyLinkedList head) {
		if (head == null)
			return;
		System.out.print(head.value);
		SinglyLinkedList node = head.next;
		while (node != null) {
			System.out.print(" -> ");
			System.out.print(node.value);
			node = node.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList node = new SinglyLinkedList(3);
		SinglyLinkedList head = node;
		node.next = new SinglyLinkedList(5);
		node = node.next;
		node.next = new SinglyLinkedList(8);
		node = node.next;
		node.next = new SinglyLinkedList(5);
		node = node.next;
		node.next = new SinglyLinkedList(10);
		node = node.next;
		node.next = new SinglyLinkedList(2);
		node = node.next;
		node.next = new SinglyLinkedList(1);
		
		System.out.println("Before:");
		print(head);
		System.out.println("After:");
		head = partition(head, 5);
		print(head);
	}
}
