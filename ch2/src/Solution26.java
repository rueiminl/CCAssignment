import java.util.Iterator;
import java.util.LinkedList;

public class Solution26 {
	public static boolean palindrome(LinkedList<Character> head) {
		int half = head.size() / 2;
		boolean odd = (head.size() % 2) == 1;
		Iterator<Character> iter = head.iterator();
		Character[] stack = new Character[half];
		for (int i = 0; i < half; i++) {
			stack[i] = iter.next();			
		}
		if (odd)
			iter.next();
		for (int i = half - 1; i >= 0; i--) {
			if (stack[i] != iter.next())
				return false;
		}
		return true;
	}
}
