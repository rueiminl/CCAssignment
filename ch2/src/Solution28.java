
public class Solution28 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	
	/**
	 * Assumption: input is a list of Integer.
	 * To find the beginning of the loop in a linked list.
	 * Algorithm: Use a slow pointer and a fast pointer. If there is a loop, they will meet somewhere in the loop.
	 *   The tricky part is to find where the beginning of the loop is.
	 *   The idea is illustrated (commented) below.
	 * Complexity: O(N) for iterating the list.
	 * @param head the target list.
	 * @return null if no loop; otherwise, a node in the beginning of the loop.
	 */
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
	
	public static void main(String[] args) {
		SinglyLinkedList node1 = new SinglyLinkedList(1);
		SinglyLinkedList node2 = new SinglyLinkedList(2);
		SinglyLinkedList node3 = new SinglyLinkedList(3);
		SinglyLinkedList node4 = new SinglyLinkedList(4);
		SinglyLinkedList node5 = new SinglyLinkedList(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		SinglyLinkedList head = node1;
		
		System.out.println("Input:");
		System.out.println("1->2->3->4->5");
		System.out.println("      ^-----+");
		SinglyLinkedList result = loopDetection(head);
		System.out.println("Output:" + result.value);
	}
}
