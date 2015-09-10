
public class Solution19 {
	private static boolean isSubstring(String word, String another) {
		return another.contains(word);
	}
	public static boolean stringRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return isSubstring(s1, s2+s2);
	}
}
