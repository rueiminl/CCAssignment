import java.util.Stack;

public class Solution35 {
	/**
	 * Assumption: type Integer
	 * Algorithm: move one value from stack to the buffer, and make sure the buff is sorted anytime.
	 *   afterwards, put back to the original stack.
	 * Complexity: O(N^2)
	 */
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> buff = new Stack<Integer>();
		while (!stack.empty()) {
			int value = stack.pop();
			// assume buff is sorted (top is smallest),
			// make sure all the values in the buff is bigger than value
			while (!buff.empty() && buff.peek() < value) {
				stack.push(buff.pop());
			}
			buff.push(value);
		}
		while (!buff.empty())
			stack.push(buff.pop());
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
