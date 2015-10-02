
public class Solution65 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "First I'll fill up the 5-quart jug, then pull the water in the jug into the 3-quart jug.\n"
			+ "Now I've got 2-quart water in the 5-quart jug.\n"
			+ "Then I empty the 3-quart jug, then pull the 2-quart water into the 3-quart jug.\n"
			+ "Now I fill up the 5-quart jug again, then I pull the water from 5-quart jug into the 3-quart jug.\n"
			+ "Since there is 2-quart water in the the 3-quart jug, only 1 quart water would be pulled out from the 5-quart jug.\n"
			+ "In this case, there will be 4-quart water left in the 5-quart jug, which is what we want.\n"
		);
		System.out.println(mySolution.toString());
	}
}
