import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class Solution13 {
	public static int URLify(char [] input, int validLength) {
		/**
		 * assumption: finalLength <= input.length (given by the question) 
		 * algorithm: iterate the string from the end, replace space ' ' with "%20"
		 * complexity: O(N) (one iteration)
		 */
		int spaceCount = 0;
		for (int i = 0; i < validLength; i++)
			if (input[i] == ' ')
				spaceCount++;
		int finalLength = validLength + spaceCount * 2;
		int w = finalLength - 1;
		for (int r = validLength - 1; r >= 0; r--) {
			if (input[r] != ' ') {
				input[w--] = input[r];
			}
			else {
				input[w--] = '0';
				input[w--] = '2';
				input[w--] = '%';
			}
		}
		return finalLength;
	}
	public static void main(String[] args) {
		String str1 = "Mr John Smith";
		char [] char1 = str1.toCharArray();
		char [] str1Input = new char [str1.length() + 2 * 2];
		System.arraycopy(char1, 0, str1Input, 0, str1.length());
		URLify(str1Input, str1.length());
		if (Arrays.equals(str1Input, "Mr%20John%20Smith".toCharArray())) {
			System.out.println("original str: \"" + str1 + "\"; URLified str: \"" + String.valueOf(str1Input) + "\"");
		}
		else {
			System.out.println("Error!");
		}
		
		char [] char2 = "   xxxxxx".toCharArray();
		Solution13.URLify(char2, 3);
		if (Arrays.equals(char2, "%20%20%20".toCharArray())) {
			System.out.println("original str: \"   \"; URLified str: \"" + String.valueOf(char2) + "\"");
		}
		else {
			System.out.println("Error!");
		}
	}
}
