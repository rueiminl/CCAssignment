import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class Solution17 {
	/**
	 * Assumption: clockwise rotation
	 * Assumption: matrix is a square (N x N)
	 * Algorithm: rotate all points in the right-top region (including the centered vertical line)
	 * Complexity: O(N^2)
	 */
	public static void rotateMatrix(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < (N + 1) / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N-j-1][i];
				matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
				matrix[N-i-1][N-j-1] = matrix[j][N-i-1];
				matrix[j][N-i-1] = temp;
			}
		}
	}
	
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		int [][] matrix = new int [3][3];
		for (int i = 0; i < 9; i++)
			matrix[i/3][i%3] = i + 1;
		System.out.println("before:");
		print(matrix);
		
		rotateMatrix(matrix);
		System.out.println("after:");
		print(matrix);
	}
}
