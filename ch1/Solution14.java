
public class Solution14 {
	public static boolean palindromePermutation(String str) {
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
}
