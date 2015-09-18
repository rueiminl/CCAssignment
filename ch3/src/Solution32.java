import java.util.Stack;

public class Solution32 {
	/**
	 * Assumption: type Integer
	 * Algorithm: if push a minumum value, push into the mins;
	 *   if pop a minumum value, pop it by the way.
	 */
	public static class StackMin {
		private Stack<Integer> values = new Stack<Integer>();
		private Stack<Integer> mins = new Stack<Integer>();
		public void push(int value) {
			values.push(value);
			if (mins.empty() || value <= mins.peek())
				mins.push(value);
		}
		public void pop() {
			if (top() == min())
				mins.pop();
			values.pop();
		}
		public int top() {
			return values.peek();
		}
		public int min() {
			return mins.peek();
		}
		public boolean empty() {
			return values.empty();
		}
		public int size() {
			return values.size();
		}
	}
	public static void main(String[] args) {
		Solution32.StackMin s = new Solution32.StackMin();
		
		s.push(10);
		System.out.println("push 10: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.push(15);
		System.out.println("push 15: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());		
		s.push(5);
		System.out.println("push 5: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.push(10);
		System.out.println("push 10: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.pop();
		System.out.println("pop: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.pop();
		System.out.println("pop: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.pop();
		System.out.println("pop: s.top() = " + s.top() + "; s.min() = " + s.min() + "; s.size() = " + s.size());
		s.pop();
		System.out.println("pop: s.size() = " + s.size());
	}
}
