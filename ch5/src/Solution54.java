
public class Solution54 {
	public static int nextSmall(int n) throws Exception {
		// algorithm: find the first 0 from least bit, then swap it to the first 1 from the position to left
		for (int i = 0; i < 32; i++) {
			if ((n & (1<<i)) == 0) {
				for (int j = i+1; j < 32; j++) {
					if ((n & (1<<j)) != 0) {
						// set bit i
						n |= (1<<i);
						// clear bit j
						n &= ~(1<<j);
						return n;
					}					
				}
				throw new Exception("no next small number");
			}
		}
		throw new Exception("no next small number");
	}
	public static int nextLarge(int n) throws Exception {
		// algorithm: find the first 1 from least bit, then swap it to the first 0 from the position to left
		// then move all 1 bits to rightmost beyond that position
		for (int i = 0; i < 32; i++) {
			if ((n & (1<<i)) != 0) {
				for (int j = i+1; j < 32; j++) {
					if ((n & (1<<j)) == 0) {
						// clear bit i
						n &= ~(1<<i);
						// set bit j
						n |= (1<<j);
						int w = 0;
						for (int r = 0; r < j; r++) {
							if ((n & (1<<r)) != 0) {
								// clear bit r
								n &= ~(1<<r);
								// set bit w
								n |= (1<<w);
								w++;
							}
						}
						return n;
					}					
				}
				throw new Exception("no next large number");
			}
		}
		throw new Exception("no next large number");
	}
	public static void main(String[] args) throws Exception {
		int[] testCase = {2, 5, 6, 14};
		for (int i = 0; i < testCase.length; i++) {
			System.out.println("the next small number of " + testCase[i] + " is " + nextSmall(testCase[i]));
			System.out.println("the next large number of " + testCase[i] + " is " + nextLarge(testCase[i]));
		}
	}
}
