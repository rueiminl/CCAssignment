import java.util.Arrays;

public class Solution12 {
	public static boolean checkPermutation(String str1, String str2) {
		char [] chars1 = str1.toCharArray();
		char [] chars2 = str2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
}
