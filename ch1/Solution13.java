
public class Solution13 {
	public static int urlify(char [] input, int validLength) {
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
}
