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
}
