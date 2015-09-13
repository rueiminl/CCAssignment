import java.util.Iterator;
import java.util.LinkedList;

public class Solution25 {
	/**
	 * Add two number (presented as LinkedList) and return the sum.
	 * Algorithm: addition by carry.
	 * Complexity: O(N) where N = maximum length of n1 or n2.
	 * @param n1 a LinkedList stands for the first number
	 * @param n2 a LinkedList stands for the second number
	 * @return a new LinkedList stands for the sum
	 */
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
	
	/**
	 * Help function of the follow up question.
	 * To reverse a LinkedList so that the number in follow up question could be transfer into the number in original question.
	 * Space Complexity: O(N) due to additional space for the result.
	 * Note: it's possible to take O(1) if we reverse in place.
	 * In that case, we should take care of the case of n1 == n2 (i.e. sumList2(n, n)).
	 * Therefore, I choose to take additional space to simplified. 
	 * @param head the targeted list
	 * @return new list that is the reverse of the list
	 */
	public static LinkedList<Integer> reverse(LinkedList<Integer> head) {
		if (head == null)
			return null;
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (Integer i : head)
			result.addFirst(i);
		return result;
	}
	
	/**
	 * Follow Up. The head of LinkedList stands for the significant digit. eg. 1->2->3 stands for the number 123.
	 * Algorithm: take advantage of original solution, just manipulate the number by reversing them.
	 * Complexity: O(N) since no operation (including reverse) is bigger than O(N).
	 * @param n1 a LinkedList stands for the first number
	 * @param n2 a LinkedList stands for the second number
	 * @return the sum of n1 and n2 presented as a LinkedList
	 */
	public static LinkedList<Integer> sumLists2(LinkedList<Integer> n1, LinkedList<Integer> n2) {
		return reverse(sumLists(reverse(n1), reverse(n2)));
	}
	
	public static void print(LinkedList<Integer> head) {
		Iterator<Integer> iter = head.iterator();
		if (iter.hasNext())
			System.out.print(iter.next());
		while (iter.hasNext()) {
			System.out.print(" -> ");
			System.out.print(iter.next());
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> n617 = new LinkedList<Integer>();
		n617.add(7);
		n617.add(1);
		n617.add(6);

		LinkedList<Integer> n295 = new LinkedList<Integer>();
		n295.add(5);
		n295.add(9);
		n295.add(2);

		System.out.println("Input:");
		print(n617);
		print(n295);
		System.out.println("Output:");
		print(sumLists(n617, n295));
		
		System.out.println("FOLLOW UP");
		LinkedList<Integer> n617r = reverse(n617);
		LinkedList<Integer> n295r = reverse(n295);
		System.out.println("Input:");
		print(n617r);
		print(n295r);
		System.out.println("Output:");
		print(sumLists2(n617r, n295r));
	}
}
