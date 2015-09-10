
public class Solution16 {
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
}
