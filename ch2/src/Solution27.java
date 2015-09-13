import java.util.Stack;

public class Solution27 {
	public static class SinglyLinkedList {
		public SinglyLinkedList(int value) {
			this.value = value;
			next = null;
		}
		public int value;
		public SinglyLinkedList next;
	}
	
	/**
	 * To find the intersection node of the two lists.
	 * Assumption: list1 and list2 are not circular. (If they are, there will be a infinite loop in my implementation.)
	 * Algorithm: put the two lists into two stacks; check the intersection by popping the stack.
	 *   (If there is a intersection, then the tail of the two lists must be identical.)
	 * Space Complexity: O(N) for the stacks.
	 * @param list1 the first list.
	 * @param list2 the second list.
	 * @return null if no intersection; a node if it's the first intersected node between the two lists.
	 */
	public static SinglyLinkedList intersection(SinglyLinkedList list1, SinglyLinkedList list2) {
		Stack<SinglyLinkedList> stack1 = new Stack<SinglyLinkedList>();
		SinglyLinkedList node = list1;
		while (node != null) {
			stack1.add(node);
			node = node.next;
		}

		Stack<SinglyLinkedList> stack2 = new Stack<SinglyLinkedList>();
		node = list2;
		while (node != null) {
			stack2.add(node);
			node = node.next;
		}
		
		SinglyLinkedList result = null;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek() == stack2.peek()) {
				result = stack1.peek();
				stack1.pop();
				stack2.pop();
			}
			else
				break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList node1 = new SinglyLinkedList(1);
		SinglyLinkedList node2 = new SinglyLinkedList(2);
		SinglyLinkedList node3 = new SinglyLinkedList(3); 
		SinglyLinkedList node4 = new SinglyLinkedList(4);
		SinglyLinkedList node5 = new SinglyLinkedList(5);
		
		// 1->2--+->4->5
		//    3--+
		SinglyLinkedList list1 = node1;
		node1.next = node2;
		node2.next = node4;
		node4.next = node5;
		SinglyLinkedList list2 = node3;
		node3.next = node4;
		
		System.out.println("List1: 1 -> 2 -+-> 4 -> 5");
		System.out.println("List2:      3 -+");
		SinglyLinkedList result = intersection(list1, list2);
		System.out.println("The intersection is " + result.value);
	}
}
