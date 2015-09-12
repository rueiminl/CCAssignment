import static org.junit.Assert.*;

import org.junit.Test;

public class Solution24Test {

	@Test
	public void test() {
		Solution24.SinglyLinkedList head1 = null;
		Solution24.SinglyLinkedList partition1 = Solution24.partition(head1, 1);
		assertEquals(partition1, null);
		
		Solution24.SinglyLinkedList head2 =	new Solution24.SinglyLinkedList(1); 
		Solution24.SinglyLinkedList partition2 = Solution24.partition(head2, 1);
		assertEquals(partition2.value, 1);
		assertEquals(partition2.next, null);
		
		Solution24.SinglyLinkedList head3 =	new Solution24.SinglyLinkedList(3);
		head3.next = new Solution24.SinglyLinkedList(1);
		head3.next.next = new Solution24.SinglyLinkedList(2);
		head3.next.next.next = new Solution24.SinglyLinkedList(1);
		head3.next.next.next.next = new Solution24.SinglyLinkedList(3);
		head3.next.next.next.next.next = new Solution24.SinglyLinkedList(2);
		Solution24.SinglyLinkedList partition3 = Solution24.partition(head3, 2);
		assertEquals(partition3.value, 1);
		assertEquals(partition3.next.value, 1);
		assertEquals(partition3.next.next.value, 3);
		assertEquals(partition3.next.next.next.value, 2);
		assertEquals(partition3.next.next.next.next.value, 3);
		assertEquals(partition3.next.next.next.next.next.value, 2);
		assertEquals(partition3.next.next.next.next.next.next, null);
	}

}
