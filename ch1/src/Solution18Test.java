import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Solution18Test {

	@Test
	public void test() {
		int[][] matrix1 = new int[0][0];
		int[][] zeroMatrix1 = new int[0][0];
		Solution18.zeroMatrix(matrix1);
		assertTrue(Arrays.deepEquals(matrix1, zeroMatrix1));
		
		int[][] matrix2 = new int[][] {
			{1},
		};
		int[][] zeroMatrix2 = new int[][] {
			{1},
		};
		Solution18.zeroMatrix(matrix2);
		assertTrue(Arrays.deepEquals(matrix2, zeroMatrix2));
		
		int[][] matrix3 = new int[][] {
			{0},
		};
		int[][] zeroMatrix3 = new int[][] {
			{0},
		};
		Solution18.zeroMatrix(matrix3);
		assertTrue(Arrays.deepEquals(matrix3, zeroMatrix3));

		int[][] matrix4 = new int[][] {
			{0, 1},
			{2, 3}
		};
		int[][] zeroMatrix4 = new int[][] {
			{0, 0},
			{0, 3}
		};
		Solution18.zeroMatrix(matrix4);
		assertTrue(Arrays.deepEquals(matrix4, zeroMatrix4));

		int[][] matrix5 = new int[][] {
			{1, 2, 3},
			{4, 0, 6},
			{7, 8, 0}
		};
		int[][] zeroMatrix5 = new int[][] {
			{1, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		Solution18.zeroMatrix(matrix5);
		assertTrue(Arrays.deepEquals(matrix5, zeroMatrix5));
	}

}
