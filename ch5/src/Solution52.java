

public class Solution52 {
	public static String binaryToString(double b) {
		if (b == 0)
			return "0";
		StringBuffer result = new StringBuffer();
		double v = 1.0;
		for (int i = 0; i < 32; i++) {
			if (b == 0)
				break;
			v /= 2;
			if (b >= v) {
				result.append("1");
				b -= v;
			}
			else {
				result.append("0");
			}
		}
		if (b != 0)
			return "ERROR";
		return result.toString();
	}
	public static void main(String[] args) {
		double[] testCase = new double[]{0.0, 0.25, 0.5, 0.75, 0.875, 0.9375, 1.0};
		for (int i = 0; i < testCase.length; i++) {
			System.out.println("the value " + testCase[i] + " = " + binaryToString(testCase[i]));
		}
	}
}
