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
}
