
public class Solution15 {
	/**
	 * Complexity: O(N) to iterate the string to count the difference
	 */
	public static boolean oneAway(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1)
			return false;
		if (str1.length() == str2.length()) {
			// replace or exactly the same
			int diffCount = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					diffCount++;
					if (diffCount > 1)
						return false;
				}
			}
		}
		else if (str1.length() > str2.length()) {
			// delete
			int i = 0;
			int j = 0;
			while (i < str1.length() && j < str2.length()) {
				if (str1.charAt(i) == str2.charAt(j)) {
					i++;
					j++;
					continue;
				}
				else {
					i++; // delete one
					if (i - j > 1)
						return false;
				}
			}
		}
		else { // (str1.length() < str2.length())
			// insert
			return oneAway(str2, str1);
		}
		return true;
	}
	public static void main(String[] args) {
		String[] strs1 = {"pale", "pales", "pale", "pale"};
		String[] strs2 = {"ple",  "pale",  "bale", "bake"};
		for (int i = 0; i < strs1.length; i++) {
			System.out.println(strs1[i] + ", " + strs2[i] + " -> " + oneAway(strs1[i], strs2[i]));
		}
	}
}
