
public class Solution53 {
	public static int getLength(int n, int bit) {
		int left = 0;
		for (int i = bit + 1; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				left++;
			} else {
				break;
			}
		}
		int right = 0;
		for (int i = bit - 1; i >= 0; i--) {
			if ((n & (1 << i)) != 0) {
				right++;
			} else {
				break;
			}
		}
		return left + right + 1;
	}
	public static int flipBitToWin(int n) {
		int maxBits = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) == 0) {
				int bits = getLength(n, i);
				if (bits > maxBits)
					maxBits = bits;
			}
		}
		if (maxBits == 0) {
			// all 1s
			return 32;
		}
		return maxBits;
	}
	public static void main(String[] args) {
		int input = 1775;
		System.out.println("The output of flipBitToWin(" + input + ") = " + flipBitToWin(input));
	}
}
