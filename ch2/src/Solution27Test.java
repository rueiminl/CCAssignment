import static org.junit.Assert.*;

import org.junit.Test;

public class Solution27Test {

	@Test
	public void test() {
		Solution27.SinglyLinkedList list1 = null;
		Solution27.SinglyLinkedList list2 = null;
		Solution27.SinglyLinkedList intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, null);
		
		Solution27.SinglyLinkedList node1 = new Solution27.SinglyLinkedList(1);
		list1 = node1;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, null);
		
		list2 = node1;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, node1);
		
		Solution27.SinglyLinkedList node2 = new Solution27.SinglyLinkedList(2);
		node1.next = node2;
		list2 = node2;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, node2); // (1) -> (2)
		
		Solution27.SinglyLinkedList node3 = new Solution27.SinglyLinkedList(3);
		node2.next = node3;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, node2); // (1) -> (2) -> 3
		
		list1 = node3;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, node3); // 1 -> (2) -> (3)

		Solution27.SinglyLinkedList node4 = new Solution27.SinglyLinkedList(4);
		list1 = node4;
		intersection = Solution27.intersection(list1, list2);
		assertEquals(intersection, null);
	}

}
