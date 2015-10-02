
public class Solution51 {
	public static int insertion(int M, int N, int i, int j) {
		int result = N;
		for (int n = i; n <= j; n++) {
			int bit = (1 << n);
			if (M % 2 == 0) {
				// clear bit
				result &= ~bit;
			} else {
				// set bit
				result |= bit;
			}
			M /= 2;
		}
		return result;
	}
	public static void main(String[] args) {
		int N = 1 << 10;
		int M = 19; // 10011
		int i = 2;
		int j = 6;
		System.out.println("N=" + N + ";M=" + M + "; i=" + i + "; j=" + j + "; insertion(N,M,i,j)=" + insertion(M,N,i,j));
	}
}
