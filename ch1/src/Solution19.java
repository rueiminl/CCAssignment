
public class Solution19 {
	private static boolean isSubstring(String word, String another) {
		return another.contains(word);
	}
	/**
	 * Check if s1 is the rotation of s2
	 * Algorithm: check if s1 a sub string of (s2 + s2)
	 * Complexity: depend on the implementation of isSubstring.
	 * (The average complexity should be O(N) where N is the length of s2)   
	 */
	public static boolean stringRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return isSubstring(s1, s2+s2);
	}
	
	public static void main(String[] args) {
		if (stringRotation("waterbottle", "erbottlewat")) {
			System.out.println("\"waterbottle\" is a rotation of \"erbottlewat\"");
		}
		else {
			System.out.println("Error...");
		}
	}
}
