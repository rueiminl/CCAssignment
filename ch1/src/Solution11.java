public class Solution11 {
	public static boolean isUnique(String str) {
		/* 
		 * assumption: the string contains ASCII characters only
		 * assumption: str != null
		 * 
		 * algorithm: check if any duplicated char by a boolean array 'exist'
		 * 
		 * complexity: memory O(1), time O(n) where n = str.length()
		 * 
		 * Without the assumption (i.e. there are infinite different characters),
		 * one might use brute force algorithm to check every pair of characters in the string
		 * so that time complexity is O(n^2)
		 * 
		 */
		boolean exist[] = new boolean [256];
		for (int i = 0; i < str.length(); i++) {
			if (exist[str.charAt(i)])
				return false;
			exist[str.charAt(i)] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		/* 
		 * "" and "abcABC123 !@#" should be unique;
		 * while "aa" and "abcABC123 !@#a" should be not unique. ('a' is duplicated)
		 */
		String[] strs = {"", "abcABC123 !@#", "aa", "abcABC123 !@#a"};
		for (String str : strs) {
			if (isUnique(str)) {
				System.out.println("\"" + str + "\" is unique");
			}
			else {
				System.out.println("\"" + str + "\" is not unique");
			}
		}
	}
}
