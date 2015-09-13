import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class Solution12 {
	public static boolean checkPermutation(String str1, String str2) {
		/**
		 * algorithm: sort and compare these two string
		 * complexity: O(NlogN) (due to the sort operation)
		 */
		char [] chars1 = str1.toCharArray();
		char [] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
	public static void main(String[] args) {
		String[] str1 = {"", "abc", "abc ABC 123!@#", "aaaaa", "a"};
		String[] str2 = {"", "cba", "ABCabc321  #@!", "aaaab", "A"};
		for (int i = 0; i < str1.length; i++) {
			if (checkPermutation(str1[i], str2[i])) {
				System.out.println("\"" + str1[i] + "\" is a permutation of \"" + str2[i] + "\"");
			}
			else {
				System.out.println("\"" + str1[i] + "\" is NOT a permutation of \"" + str2[i] + "\"");				
			}
		}
		// expection result: True, True, True, False ('a' is not equal to 'b'), False ('a' is not equal to 'A')
	}
}
