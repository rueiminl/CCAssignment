
public class Solution610 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "We can treat each test strip as a bit, so there are 10 bits to identify 1000 bottles, which is possible in one pass.\n"
			+ "For example, we drop the soda from bottle 1 to 0-th test strip since 1 could be represented as 0000000001\n"
			+ "Another example, we drop the soda from bottle 1000 to 3, 5,6,7,8,9-th test strip since 1000 could be represented as 0b1111101000\n"
			+ "In this way, after 7 days when the result is shown, we could identify which bottle is poisoned immediately.\n"
		);
		System.out.println(mySolution.toString());
	}
}
