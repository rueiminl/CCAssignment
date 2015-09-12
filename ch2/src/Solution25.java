import java.util.Iterator;
import java.util.LinkedList;

public class Solution25 {
	public static LinkedList<Integer> sumLists(LinkedList<Integer> n1, LinkedList<Integer> n2) {
		if (n1 == null || n2 == null)
			return null;

		LinkedList<Integer> result = new LinkedList<Integer>();
		Iterator<Integer> iter1 = n1.iterator();
		Iterator<Integer> iter2 = n2.iterator();
		int carry = 0;
		while (iter1.hasNext() || iter2.hasNext() || carry != 0) {
			int digit = 0;
			digit += carry;
			if (iter1.hasNext()) {
				Integer digit1 = iter1.next();
				if (digit1 < 0 || digit1 >= 10)
					return null;
				digit += digit1;
			}
			if (iter2.hasNext()) {
				Integer digit2 = iter2.next();
				if (digit2 < 0 || digit2 >= 10)
					return null;
				digit += digit2;
			}
			carry = digit / 10;
			result.add(digit % 10);
		}
		// trim the zero
		while (!result.isEmpty() && result.getLast() == 0) {
			result.removeLast();
		}
		if (result.isEmpty())
			result.add(0);
		return result;
	}
	public static LinkedList<Integer> reverse(LinkedList<Integer> head) {
		if (head == null)
			return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (Integer i : head)
			result.addFirst(i);
		return result;
	}
	public static LinkedList<Integer> sumLists2(LinkedList<Integer> n1, LinkedList<Integer> n2) {
		return reverse(sumLists(reverse(n1), reverse(n2)));
	}
}
