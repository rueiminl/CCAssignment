import java.util.Iterator;
import java.util.LinkedList;

public class Solution23 {
	public static final int NOT_A_VALUE = -1;
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	
	/**
	 * Note: Given a node in a singly linked list, it's impossible to retrieve the previous node.
	 * Therefore, the only solution is to move the value to simulate the deletion.
	 * Note: if the given node is in the tail, it could be a problem.
	 * To address this problem, use a specific value to indicate that.
	 * Assumption: a list of positive Integer.
	 * Assumption: a given node is in the middle (i.e. not in the tail)
	 * Algorithm: iterate the nodes after the given node, move their value to the previous node.
	 * Complexity: O(N)
	 */
	public static void deleteMiddleNode(SinglyLinkedList node) {
		if (node == null)
			return;
		while (node.next != null) {
			node.value = node.next.value;
			if (node.next.next == null) {
				node.next = null;
				return;
			}
			node = node.next;
		}
		node.value = NOT_A_VALUE;
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
		SinglyLinkedList head1 = new SinglyLinkedList(1);
		head1.next =  new SinglyLinkedList(2);
		head1.next.next =  new SinglyLinkedList(3);
		head1.next.next.next =  new SinglyLinkedList(4);
		System.out.println("Original List:");
		print(head1);

		System.out.println("Remove the first node:");
		deleteMiddleNode(head1);
		print(head1);

		System.out.println("Remove the second node:");
		deleteMiddleNode(head1.next);
		print(head1);
	}
}
