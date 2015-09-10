import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Solution17Test {

	@Test
	public void test() {
		int [][] matrix1 = new int [0][0];
		int [][] rotateMatrix1 = new int [0][0];
		Solution17.rotateMatrix(matrix1);
		assertTrue(Arrays.deepEquals(matrix1, rotateMatrix1));

		int [][] matrix2 = new int [1][1];
		matrix2[0][0] = 123;
		int [][] rotateMatrix2 = new int [1][1];
		rotateMatrix2[0][0] = 123;
		Solution17.rotateMatrix(matrix2);
		assertTrue(Arrays.deepEquals(matrix2, rotateMatrix2));

		int [][] matrix3 = new int [2][2];
		int [][] rotateMatrix3 = new int [2][2];
		matrix3[0][0] = rotateMatrix3[0][1] = 1;
		matrix3[0][1] = rotateMatrix3[1][1] = 2;
		matrix3[1][1] = rotateMatrix3[1][0] = 3;
		matrix3[1][0] = rotateMatrix3[0][0] = 4;
		Solution17.rotateMatrix(matrix3);
		assertTrue(Arrays.deepEquals(matrix3, rotateMatrix3));
		
		int [][] matrix4 = new int [3][3];
		int [][] rotateMatrix4 = new int [3][3];
		matrix4[0][0] = rotateMatrix4[0][2] = 1;
		matrix4[0][2] = rotateMatrix4[2][2] = 2;
		matrix4[2][2] = rotateMatrix4[2][0] = 3;
		matrix4[2][0] = rotateMatrix4[0][0] = 4;

		matrix4[0][1] = rotateMatrix4[1][2] = 5;
		matrix4[1][2] = rotateMatrix4[2][1] = 6;
		matrix4[2][1] = rotateMatrix4[1][0] = 7;
		matrix4[1][0] = rotateMatrix4[0][1] = 8;
		
		matrix4[1][1] = rotateMatrix4[1][1] = 9;
		Solution17.rotateMatrix(matrix4);
		assertTrue(Arrays.deepEquals(matrix4, rotateMatrix4));
	}

}
