
public class Solution69 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "The 1, 4, 9, 16, 25, 36, 49, 64, 81, 100th door would be open!\n"
			+ "The reason is that the i-th door is open if and only if its number of factors is odd.\n"
			+ "For example, the number 12 = 2*2*3 = 2^2 * 3^1, so the number of factors would be (2+1)*(1+1) = 6,\n"
			+ "which is even so it's closed in the end;\n"
			+ "the number 100 = 2^2 * 5^2, so it's number of factors would be (2+1)*(2+1) which is odd, that's why it's open in the end.\n"
		);
		System.out.println(mySolution.toString());
	}
}
