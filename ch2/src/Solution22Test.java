import static org.junit.Assert.*;

import org.junit.Test;

public class Solution22Test {

	@Test
	public void test() {
		Solution22.SinglyLinkedList head1 = new Solution22.SinglyLinkedList(1);
		head1.next =  new Solution22.SinglyLinkedList(2);
		head1.next.next =  new Solution22.SinglyLinkedList(3);
		head1.next.next.next =  new Solution22.SinglyLinkedList(4);
		assertEquals(Solution22.returnKthToLast(null, 0), null);
		assertEquals(Solution22.returnKthToLast(null, 1), null);
		assertEquals(Solution22.returnKthToLast(head1, 0).value, 4);
		assertEquals(Solution22.returnKthToLast(head1, 1).value, 3);
		assertEquals(Solution22.returnKthToLast(head1, 2).value, 2);
		assertEquals(Solution22.returnKthToLast(head1, 3).value, 1);
		assertEquals(Solution22.returnKthToLast(head1, 4), null);
	}
}
