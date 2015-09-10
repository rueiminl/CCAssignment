
public class Solution18 {
	public static void zeroMatrix(int [][] matrix) {
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
}
