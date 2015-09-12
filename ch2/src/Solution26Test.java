import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Solution26Test {

	@Test
	public void test() {
		LinkedList<Character> list1 = new LinkedList<Character>();
		assertTrue(Solution26.palindrome(list1));
		
		list1.add('a');
		assertTrue(Solution26.palindrome(list1));
		
		list1.add('b');
		assertFalse(Solution26.palindrome(list1));
		
		list1.add('b');
		assertFalse(Solution26.palindrome(list1));

		list1.add('a');
		assertTrue(Solution26.palindrome(list1));

		list1.add('C');
		assertFalse(Solution26.palindrome(list1));
		
		list1.add('a');
		list1.add('b');
		list1.add('b');
		list1.add('a');
		assertTrue(Solution26.palindrome(list1));
	}

}
