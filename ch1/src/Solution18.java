
public class Solution18 {
	/**
	 * Algorithm: scan the matrix to maintain information of which row and which column needs to be set to zeros
	 * Complexity: O(N*M) where N is the number of rows and M is the number of columns in the matrix. 
	 */
	public static void zeroMatrix(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return;
		int col = matrix[0].length;
		boolean[] zeroRow = new boolean[row];
		boolean[] zeroCol = new boolean[col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			if (zeroRow[i]) {
				for (int j = 0; j < col; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < col; j++) {
			if (zeroCol[j]) {
				for (int i = 0; i < row; i++) {
					matrix[i][j] = 0;
				}
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
		matrix[1][1] = matrix[2][2] = 0;
		System.out.println("before:");
		print(matrix);
		
		zeroMatrix(matrix);
		System.out.println("after:");
		print(matrix);		
	}
}
