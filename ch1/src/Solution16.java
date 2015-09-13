public class Solution16 {
	/**
	 * Assumption: only uppercase and lowercase letters (given by the question)
	 * Algorithm: iterate the string and count the frequency of each continuous character
	 * Complexity: O(N) where N is the length of the string
	 */
	public static String stringCompression(String str) {
		if (str.isEmpty())
			return "";
		StringBuilder result = new StringBuilder();
		char ch = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
			else {
				result.append(ch);
				result.append(count);
				ch = str.charAt(i);
				count = 1;
			}
		}
		result.append(ch);
		result.append(count);
		if (result.length() >= str.length())
			return str;
		else
			return result.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = {"", "a", "aa", "aaa", "aaaaaaaaaa", "aaaaaaaaaabBBB"};
		for (String str : strs) {
			String comp = stringCompression(str);
			System.out.println("\"" + str + "\" is compressed to \"" + comp + "\"");
		}
		// expectation: "aa" -> "a2" which is the same length with original string, so return "aa"
	}
}
