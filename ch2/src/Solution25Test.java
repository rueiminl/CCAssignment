import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Solution25Test {

	@Test
	public void test() {
		LinkedList<Integer> n1 = new LinkedList<Integer>();
		n1.add(1);
		LinkedList<Integer> sum1 = Solution25.sumLists(n1, null); // null is not valid
		assertEquals(sum1, null);

		LinkedList<Integer> n2 = new LinkedList<Integer>();
		LinkedList<Integer> sum2 = Solution25.sumLists(n1, n2);
		assertEquals(sum2, n1); // 1 + 0 = 1
		
		LinkedList<Integer> n3 = new LinkedList<Integer>();
		n3.add(-3);
		LinkedList<Integer> sum3 = Solution25.sumLists(n1, n3);
		assertEquals(sum3, null); // n3 is not valid (digit out of range)
		
		LinkedList<Integer> n4 = new LinkedList<Integer>();
		n4.add(10);
		LinkedList<Integer> sum4 = Solution25.sumLists(n1, n4);
		assertEquals(sum4, null); // n4 is not valid (digit out of range)
		
		LinkedList<Integer> n5 = new LinkedList<Integer>();
		n5.add(0);
		LinkedList<Integer> sum5 = Solution25.sumLists(n1, n5);
		assertTrue(sum5.equals(n1)); // n1 + 0 = n1
		
		LinkedList<Integer> n6 = new LinkedList<Integer>();
		n6.add(9);
		n6.add(9);
		n6.add(9);
		LinkedList<Integer> sum6 = Solution25.sumLists(n1, n6);
		LinkedList<Integer> ans6 = new LinkedList<Integer>();
		ans6.add(0);
		ans6.add(0);
		ans6.add(0);
		ans6.add(1);
		assertTrue(sum6.equals(ans6)); // 1 + 999 = 1000

		LinkedList<Integer> n7 = new LinkedList<Integer>();
		n7.add(0);
		n7.add(0);
		n7.add(0);
		LinkedList<Integer> sum7 = Solution25.sumLists(n1, n7);
		assertTrue(sum7.equals(n1)); // 1 + 000 = 1
	}

}
