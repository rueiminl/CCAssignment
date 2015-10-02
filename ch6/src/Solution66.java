
public class Solution66 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "If there is only one blue-eye person, then he will leave immediately (day 1).\n"
			+ "If two, then at day 2, the blue-eye people would find that no one left at day 1, then they will realize that they are blue-eyes.\n"
			+ "Similarly, three blue-eyes would leave at day 3, ..., N blue-eyes would leave at day N\n"
		);
		System.out.println(mySolution.toString());
	}
}