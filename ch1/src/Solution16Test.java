import static org.junit.Assert.*;

import org.junit.Test;

public class Solution16Test {

	@Test
	public void test() {
		assertEquals(Solution16.stringCompression(""), "");
		assertEquals(Solution16.stringCompression("a"), "a");
		assertEquals(Solution16.stringCompression("aa"), "aa");
		assertEquals(Solution16.stringCompression("aaa"), "a3");
		assertEquals(Solution16.stringCompression("aaaaaaaaaa"), "a10");
		assertEquals(Solution16.stringCompression("aaaaaaaaaabBBB"), "a10b1B3");
	}

}
