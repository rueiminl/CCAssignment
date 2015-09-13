import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Solution13Test {

	@Test
	public void test() {
		String str1 = "Mr John Smith";
		char [] char1 = str1.toCharArray();
		char [] str1Input = new char [str1.length() + 2 * 2];
		System.arraycopy(char1, 0, str1Input, 0, str1.length());
		Solution13.urlify(str1Input, str1.length());
		assertTrue(Arrays.equals(str1Input, "Mr%20John%20Smith".toCharArray()));
		
		char [] char2 = "   xxxxxx".toCharArray();
		Solution13.urlify(char2, 3);
		assertTrue(Arrays.equals(char2, "%20%20%20".toCharArray()));	
	}

}
