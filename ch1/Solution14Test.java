import static org.junit.Assert.*;

import org.junit.Test;

public class Solution14Test {

	@Test
	public void test() {
		assertTrue(Solution14.palindromePermutation(""));
		assertTrue(Solution14.palindromePermutation("a"));
		assertTrue(Solution14.palindromePermutation("abcba"));
		assertTrue(Solution14.palindromePermutation("aAbBcCd"));
		assertTrue(Solution14.palindromePermutation("aaaaBBbbCcCcddDD"));
		assertFalse(Solution14.palindromePermutation("_"));
		assertFalse(Solution14.palindromePermutation("!"));
		assertFalse(Solution14.palindromePermutation("1"));
		assertFalse(Solution14.palindromePermutation("aaabbb"));
	}

}
