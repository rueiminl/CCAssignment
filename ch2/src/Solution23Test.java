import static org.junit.Assert.*;

import org.junit.Test;

public class Solution23Test {

	@Test
	public void test() {
		Solution23.SinglyLinkedList head1 = new Solution23.SinglyLinkedList(1);
		head1.next =  new Solution23.SinglyLinkedList(2);
		head1.next.next =  new Solution23.SinglyLinkedList(3);
		head1.next.next.next =  new Solution23.SinglyLinkedList(4);

		Solution23.deleteMiddleNode(head1);
		assertEquals(head1.value, 2);
		assertEquals(head1.next.value, 3);
		assertEquals(head1.next.next.value, 4);
		assertEquals(head1.next.next.next, null);

		Solution23.deleteMiddleNode(head1.next);
		assertEquals(head1.value, 2);
		assertEquals(head1.next.value, 4);
		assertEquals(head1.next.next, null);

		Solution23.deleteMiddleNode(head1.next);
		assertEquals(head1.value, 2);
		assertEquals(head1.next.value, Solution23.NOT_A_VALUE);
		head1.next.next = null;

		Solution23.deleteMiddleNode(null);
	}

}
