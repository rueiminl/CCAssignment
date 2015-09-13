import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class Solution21 {
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
	public static void main(String[] args) {
		
	}
}
