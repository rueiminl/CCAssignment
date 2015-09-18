import java.util.Stack;
import java.util.Vector;

public class Solution33 {
	/**
	 * Stack of plates.
	 * Assumption: type Integer.
	 *   maxSize >= 1
	 */
	public static class SetOfStacks {
		private int maxSize;
		Vector<Stack<Integer>> stacks = new Vector<Stack<Integer>>(); 
		public SetOfStacks(int maxSize) {
			this.maxSize = maxSize;
		}
		public void push(int value) {
			if (stacks.isEmpty())
				stacks.addElement(new Stack<Integer>());
			Stack<Integer> lastStack = stacks.lastElement();
			if (lastStack.size() >= maxSize) {
				stacks.addElement(new Stack<Integer>());		
				lastStack = stacks.lastElement();
			}
			lastStack.push(value);
		}
		public void pop() {
			Stack<Integer> lastStack = stacks.lastElement();
			lastStack.pop();
			if (lastStack.isEmpty()) {
				stacks.remove(stacks.size() - 1);
			}
		}
		public int top() {
			Stack<Integer> lastStack = stacks.lastElement();
			return lastStack.peek();
		}
		public boolean isEmpty() {
			return stacks.isEmpty();
		}
		// follow up
		public void popAt(int index) {
			Stack<Integer> stack = stacks.get(index);
			stack.pop();
			/**
			 * To be complete, we deal with the case that middle stack might be empty.
			 * i.e. some patch up code in pop() and here is needed. 
			 */
		}
	}
	public static void main(String[] args) {
		Solution33.SetOfStacks stacks = new Solution33.SetOfStacks(2);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		System.out.print("pop from the stacks: ");
		while (!stacks.isEmpty()) {
			System.out.print(stacks.top() + " ");
			stacks.pop();
		}
	}
}
