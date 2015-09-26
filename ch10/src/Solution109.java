
public class Solution109 {
	public static boolean sortedMatrixSearch(int[][] matrix, int value) {
		int rows = matrix.length;
		if (rows == 0)
			return false;
		int cols = matrix[0].length;
		int row = 0;
		int col = cols - 1;
		while (row < rows && col >= 0) {
			if (matrix[row][col] < value) {
				// impossible in this row
				row++;
			}
			else if (matrix[row][col] > value) {
				// impossible in this col
				col--;
			}
			else // if (matrix[row][col] == value)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = new int [][]{
			{1, 5, 10, 20},
			{3, 6, 15, 21},
			{7, 8, 16, 22},
			{8,20, 25, 26}
		};
		for (int i = 0; i <= 27; i++)
			System.out.println(i + " in matrix? " + sortedMatrixSearch(matrix, i));
	}
}
