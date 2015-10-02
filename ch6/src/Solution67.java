
public class Solution67 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "Since the probability of boy birth and girl birth are equal, it would definitely the same ratio in the end.\n"
		);
		System.out.println(mySolution.toString());
		
		// experiments
		int family = 10000;
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < family; i++) {
			while (true) {
				if (Math.random() < 0.5) {
					boys++;
				}
				else {
					girls++;
					break;
				}
			}
		}
		System.out.println("boys: " + boys + "; girls: " + girls + "; ratio of girls/boys = " + (double)girls / boys);
	}
}
