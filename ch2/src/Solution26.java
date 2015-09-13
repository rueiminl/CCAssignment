import java.util.Iterator;
import java.util.LinkedList;

public class Solution26 {
	/**
	 * Assumption: input is a linked list of Character.
	 * To check if a linked list is a palindrome.
	 * Algorithm: store the first half list into a stack, then compare them with the second half list.
	 * Space Complexity: O(N) due to the stack to store the first half list.
	 * Note: if it's double linked list, we can achieve space complexity as O(1) easily.
	 */
	public static boolean palindrome(LinkedList<Character> head) {
		int half = head.size() / 2;
		boolean odd = (head.size() % 2) == 1;
		Iterator<Character> iter = head.iterator();
		Character[] stack = new Character[half];
		for (int i = 0; i < half; i++) {
			stack[i] = iter.next();			
		}
		if (odd)
			iter.next(); // skip the middle one
		for (int i = half - 1; i >= 0; i--) {
			if (stack[i] != iter.next())
				return false;
		}
		return true;
	}
	
	public static void print(LinkedList<Character> head) {
		Iterator<Character> iter = head.iterator();
		if (iter.hasNext())
			System.out.print(iter.next());
		while (iter.hasNext()) {
			System.out.print(" -> ");
			System.out.print(iter.next());
		}
	}
	
	public static void test(LinkedList<Character> head) {
		print(head);
		if (palindrome(head))
			System.out.println(" is a palindrome.");
		else
			System.out.println(" is not a palindrome.");
	}

	public static void main(String[] args) {
		LinkedList<Character> head = new LinkedList<Character>();
		test(head);
		head.add('a');
		test(head);
		head.add('b');
		test(head);
		head.add('b');
		test(head);
		head.add('a');
		test(head);
		head.add('C');
		head.add('a');
		head.add('b');
		head.add('b');
		head.add('a');
		test(head);
	}
}
