
public class Solution64 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append("If an ant decide to walk either clockwise or counter-clockwise, "
				+ "the only possible way that they don't collide is 1/2 * 1/2.\n"
				+ "Therefore, the probability of collision is 1 - 1/4 = 0.75.\n"
				+ "Similarly, the probability of collision for n-vertex polygon would be 1 - (0.5)^(n-1)."
		);
		System.out.println(mySolution.toString());
	}
}
