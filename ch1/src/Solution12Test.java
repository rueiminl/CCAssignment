import static org.junit.Assert.*;

import org.junit.Test;

public class Solution12Test {

	@Test
	public void test() {
		assertTrue(Solution12.checkPermutation("", ""));
		assertTrue(Solution12.checkPermutation("abc", "cba"));
		assertTrue(Solution12.checkPermutation("abc ABC 123!@#", "ABCabc321  #@!"));
		assertFalse(Solution12.checkPermutation("aaaaa", "aaaab"));
		assertFalse(Solution12.checkPermutation("a", "A"));
	}

}
