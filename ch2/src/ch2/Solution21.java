package ch2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
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
}
