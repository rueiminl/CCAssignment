import static org.junit.Assert.*;

import org.junit.Test;

public class Solution28Test {

	@Test
	public void test() {
		assertEquals(Solution28.loopDetection(null), null);
		
		Solution28.SinglyLinkedList node1 = new Solution28.SinglyLinkedList(1);
		assertEquals(Solution28.loopDetection(node1), null);
		
		node1.next = node1;
		assertEquals(Solution28.loopDetection(node1), node1);
		
		Solution28.SinglyLinkedList node2 = new Solution28.SinglyLinkedList(2);
		node1.next = node2;
		assertEquals(Solution28.loopDetection(node1), null);
		
		node2.next = node1;
		assertEquals(Solution28.loopDetection(node1), node1);
		assertEquals(Solution28.loopDetection(node2), node2);
		
		node2.next = node2;
		assertEquals(Solution28.loopDetection(node1), node2);
		assertEquals(Solution28.loopDetection(node2), node2);
		
		Solution28.SinglyLinkedList node3 = new Solution28.SinglyLinkedList(3);
		node2.next = node3;
		node3.next = node2;
		assertEquals(Solution28.loopDetection(node1), node2);		
	}

}
