import java.util.Stack;

public class Solution35 {
	/**
	 * Assumption: type Integer
	 * Algorithm: quick sort
	 */
	public static void sortStack(Stack<Integer> stack) {
		if (stack.empty()) // down
			return;
		int anchor = stack.peek();
		stack.pop();
		Stack<Integer> smaller = new Stack<Integer>(); 
		Stack<Integer> bigger = new Stack<Integer>();
		while (!stack.empty()) {
			int value = stack.peek();
			stack.pop();
			if (value < anchor)
				smaller.push(value);
			else
				bigger.push(value);
		}
		sortStack(smaller);
		sortStack(bigger);
		Stack<Integer> buffer = new Stack<Integer>();
		while (!smaller.empty()) {
			buffer.push(smaller.peek());
			smaller.pop();
		}
		while (!buffer.empty()) {
			stack.push(buffer.peek());
			buffer.pop();
		}
		stack.push(anchor);
		while (!bigger.empty()) {
			buffer.push(bigger.peek());
			bigger.pop();
		}
		while (!buffer.empty()) {
			stack.push(buffer.peek());
			buffer.pop();
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(6);
		stack.push(1);
		stack.push(4);
		stack.push(8);
		stack.push(5);
		stack.push(2);
		stack.push(7);
		sortStack(stack);
		System.out.print("pop stack (i.e. reverse order): ");
		while (!stack.empty()) {
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
	}
}
