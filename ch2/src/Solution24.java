public class Solution24 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
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
}
