
public class Solution56 {
	public static int conversion(int A, int B) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			if (A % 2 != B % 2)
				result++;
			A /= 2;
			B /= 2;
		}
		return result;
	}
	public static void main(String[] args) {
		int A = 29;
		int B = 15;
		System.out.println("input: " + A + ", " + B);
		System.out.println("output: " + conversion(A, B));
	}
}
