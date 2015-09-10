import static org.junit.Assert.*;

import org.junit.Test;

public class Solution19Test {

	@Test
	public void test() {
		assertTrue(Solution19.stringRotation("", ""));
		assertTrue(Solution19.stringRotation("waterbottle", "erbottlewat"));
		assertTrue(Solution19.stringRotation("aaaaab", "abaaaa"));
		assertTrue(Solution19.stringRotation("a", "a"));
		assertFalse(Solution19.stringRotation("", "a"));
		assertFalse(Solution19.stringRotation("a", ""));
		assertFalse(Solution19.stringRotation("abcd", "abdc"));
	}

}
