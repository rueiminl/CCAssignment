
public class Solution22 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	public static SinglyLinkedList ReturnKthToLast(SinglyLinkedList head, int k) {
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
}
