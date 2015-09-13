
public class Solution11 {
	public static boolean isUnique(String str) {
		boolean exist[] = new boolean [256];
		for (int i = 0; i < str.length(); i++) {
			if (exist[str.charAt(i)])
				return false;
			exist[str.charAt(i)] = true;
		}
		return true;
	}
}
