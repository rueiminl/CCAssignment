import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class Solution21 {
	/**
	 * Algorithm: store all existed node in a set
	 * Complexity: O(N) to iterate all the nodes in the list (insert and check a hash set cost O(1))
	 * Space Complexity: O(N) (happens if all nodes have different value) 
	 */
	public static void removeDups(LinkedList<Integer> head) {
		Iterator<Integer> it = head.iterator();
		Set<Integer> exist = new HashSet<Integer>();
		while (it.hasNext()) {
			Integer i = it.next();
			if (exist.contains(i))
				it.remove();
			else
				exist.add(i);
		}
	}
	
	/**
	 * Follow Up: without additional data structure.
	 * Algorithm: two iteration to check all pairs of nodes in the link. remove second one if duplicated.
	 * Complexity: O(N^2)
	 * Space Complexity: O(1)
	 */
	public static void removeDups2(LinkedList<Integer> head) {
		// follow up: without additional memory
		for (int index = 0; index < head.size(); index++) {
			ListIterator<Integer> iter = head.listIterator(index);
			Integer i = iter.next();
			while (iter.hasNext()) {
				Integer i2 = iter.next();
				if (i == i2)
					iter.remove();
			}
		}
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
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(5);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		list1.add(7);
		list1.add(6);
		@SuppressWarnings("unchecked")
		LinkedList<Integer> list2 = (LinkedList<Integer>) list1.clone();
		
		System.out.println("Before:");
		print(list1);

		removeDups(list1);
		System.out.println("After:");
		print(list1);

		System.out.println("FOLLOW UP");
		System.out.println("Before:");
		print(list2);

		removeDups2(list2);
		System.out.println("After:");
		print(list2);
	}
}
