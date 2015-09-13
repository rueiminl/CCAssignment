import static org.junit.Assert.*;

import org.junit.Test;

public class Solution15Test {

	@Test
	public void test() {
		assertTrue(Solution15.oneAway("", ""));
		assertTrue(Solution15.oneAway("", "a"));
		assertTrue(Solution15.oneAway("a", ""));
		assertTrue(Solution15.oneAway("123", "123"));
		assertTrue(Solution15.oneAway("12a3", "123"));
		assertTrue(Solution15.oneAway("123", "1a23"));
		assertTrue(Solution15.oneAway("aaaba", "aaaaa"));
		assertTrue(Solution15.oneAway("aaaaba", "aaaaa"));
		assertFalse(Solution15.oneAway("aa", ""));
		assertFalse(Solution15.oneAway("abcdef", "abbcdeef"));
	}

}
