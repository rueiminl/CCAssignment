
public class Solution57 {
	public static int pairwiseSwap(int n) {
		int odd = n & 0x55555555;
		int even = n & 0xaaaaaaaa;
		return (even >> 1) + (odd << 1);
	}
	public static void main(String[] args) {
		int[] testCase = {1, 2, 5, 10, 21, 42};
		for (int i = 0; i < testCase.length; i++) {
			System.out.println("the pairwise swap of " + testCase[i] + " is " + pairwiseSwap(testCase[i]));;
		}
	}
}
