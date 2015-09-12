public class Solution28 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	public static SinglyLinkedList loopDetection(SinglyLinkedList head) {
		SinglyLinkedList slow = head;
		SinglyLinkedList fast = head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
			if (slow == fast)
				break;
		}
		if (fast == null)
			return null;
		
		// assume slow runs n-steps, and fast runs 2n-steps.
		// when slow and a new slow node start from head runs another n-steps, they will meet at the meeting point again.
		// which means they will meet at the beginning of the loop (less than or equal to n-steps)
		SinglyLinkedList node = head;
		while (node != slow) {
			node = node.next;
			slow = slow.next;
		}
		return node;
	}
}
