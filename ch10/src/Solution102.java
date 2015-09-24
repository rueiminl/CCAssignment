import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Solution102 {
	/**
	 * Algorithm: sort the string, then group them
	 * Side effect: would remove duplicated string since I use HashSet. Use Vector if you don't want the side effect
	 */
	public static void groupAnagrams(Vector<String> strs) {
		HashMap<String, HashSet<String>> buf = new HashMap<String, HashSet<String>>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String sorted = String.valueOf(ch);
			if (!buf.containsKey(sorted))
				buf.put(sorted, new HashSet<String>());
			buf.get(sorted).add(str);
		}
		strs.clear();
		for (HashSet<String> group : buf.values()) {
			for (String str : group) {
				strs.addElement(str);
			}
		}
	}
	public static void main(String[] args) {
		Vector<String> strs = new Vector<String>();
		strs.addElement("aabbcc");
		strs.addElement("abc");
		strs.addElement("abcabc");
		strs.addElement("cba");
		strs.addElement("ccbbaa");
		strs.addElement("b");
		groupAnagrams(strs);
		for (String str : strs) {
			System.out.println(str);
		}
	}
}
