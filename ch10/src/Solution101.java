
public class Solution101 {
	/**
	 * Algorithm: compare the ends of two arrays, and put larger number in the end
	 * Complexity: O(N)
	 */
	public static void sortedMerge(int[] A, int lenA, int B[]) {
		int rA = lenA - 1;
		int rB = B.length - 1;
		int w = lenA + B.length - 1;
		while (rA >= 0 || rB >= 0) {
			if (rA < 0)
				A[w--] = B[rB--];
			else if (rB < 0)
				A[w--] = A[rA--];
			else if (A[rA] > B[rB])
				A[w--] = A[rA--];
			else 
				A[w--] = B[rB--];				
		}
	}
	public static void main(String[] args) {
		int[] A = new int[]{1,3,5,7,9,0,0,0,0,0};
		int[] B = new int[]{2,4,6,8,10};
		sortedMerge(A, 5, B);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}
}
