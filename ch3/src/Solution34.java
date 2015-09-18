import java.util.Queue;
import java.util.Stack;

public class Solution34 {
	/**
	 * Use two stacks to implement a queue.
	 * Assumption: type Integer
	 *   won't remove if empty
	 * Algorithm: a input stack and a output stack.
	 *   dump all values in input stack to the output stack when pop and the output stack is empty.
	 */
	public static class MyQueue {
		Stack<Integer> input = new Stack<Integer>();
		Stack<Integer> output = new Stack<Integer>();
		public void add(int value) {
			input.push(value);
		}
		public void remove() {
			checkOutput();
			output.pop();
		}
		public int peek() {
			checkOutput();
			return output.peek();
		}
		private void checkOutput() {
			if (output.empty()) {
				while (!input.empty()) {
					int value = input.peek();
					input.pop();
					output.push(value);
				}
			}			
		}
	}
	public static void main(String[] args) {
		Solution34.MyQueue queue = new Solution34.MyQueue();
		queue.add(1);
		queue.add(2);
		System.out.println("peek(): " + queue.peek() + "(should  be 1)");
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.remove();
		System.out.println("peek(): " + queue.peek() + "(should  be 2)");
		queue.remove();
		System.out.println("peek(): " + queue.peek() + "(should  be 3)");
		queue.remove();
		System.out.println("peek(): " + queue.peek() + "(should  be 4)");
		queue.remove();
		System.out.println("peek(): " + queue.peek() + "(should  be 5)");
		queue.remove();
		// queue should be empty
	}
}
