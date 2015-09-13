import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution14 {
	public static boolean palindromePermutation(String str) {
		/**
		 * assumption: str contains alphabet and space only (i.e. [a-zA-Z ])
		 * algorithm: count frequency of each alphabet;
		 *   if 2 or more alphabet are odd, then it's impossible to have a palindrome permutation.
		 * complexity: O(N)
		 */
		// check if all chars are pair; note: str should contain letters only
		boolean [] single = new boolean [26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				ch += (-'A' + 'a');
			if (ch >= 'a' && ch <= 'z') {
				int id = ch - 'a';
				single[id] = !single[id];
			}
			else if (ch == ' ')
				continue; // skip
			else
				return false; // unknown char (neither letter nor space)
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (single[i])
				count++;
		}
		return count <= 1;
	}
	public static void main(String[] args) {
		String[] strs = {"", "a", "abcba", "aAbBcCd", "aaaaBBbbCcCcddDD", "_", "1", "aaabbb"};
		for (String str : strs) {
			if (palindromePermutation(str)) {
				System.out.println("\"" + str + "\" is a permutation of a palindrome");
			}
			else {
				System.out.println("\"" + str + "\" is not a permutation of a palindrome");
			}
		}
		// expectation: True, True, True, True, True, False (not alphabet), False (not alphabet), False (no permutation could be a palindrome)
	}
}
