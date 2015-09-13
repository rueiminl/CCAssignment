
public class Solution22 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	
	/**
	 * Assumption: A list of Integer
	 * Algorithm: find the length of the list, then minus k to get the index.
	 * Complexity: O(N) to iterate the whole list.
	 */
	public static SinglyLinkedList returnKthToLast(SinglyLinkedList head, int k) {
		if (k < 0 || head == null)
			return null;
		SinglyLinkedList node = head;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		if (k > len - 1)
			return null;
		node = head;
		int i = 0;
		while (i < len - 1 - k) {
			node = node.next;
			i++;
		}
		return node;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList head1 = new SinglyLinkedList(1);
		head1.next =  new SinglyLinkedList(2);
		head1.next.next =  new SinglyLinkedList(3);
		head1.next.next.next =  new SinglyLinkedList(4);
		System.out.println("the list: 1 -> 2 -> 3 -> 4");
		for (int k = 0; k < 4; k++) {
			System.out.println("the " + k + "-th node to the last is " + returnKthToLast(head1, k).value);
		}
	}
}
