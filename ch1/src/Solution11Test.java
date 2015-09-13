import static org.junit.Assert.*;

import org.junit.Test;

public class Solution11Test {

	@Test
	public void test() {
		assertTrue(Solution11.isUnique(""));
		assertTrue(Solution11.isUnique("abcABC123 !@#"));
		assertTrue(!Solution11.isUnique("aa"));
		assertTrue(!Solution11.isUnique("abcABC123 !@#a"));
	}

}
