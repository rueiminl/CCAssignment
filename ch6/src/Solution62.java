
public class Solution62 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append("I would win in Game 1 with probability p; I would win in Game 2 with probability C(3,2)*p*p*(1-p) + p^3.\n");
		mySolution.append("Game 1's odd minus Game 2's odd = 2*p^3 - 3*p^2 + p = p(2p-1)(p-1).\n");
		mySolution.append("Therefore, in the range of 0<p<0.5, I should choose Game 1; while in the range of 0.5 < p < 1, I should choose Game 2.\n");
		mySolution.append("If p == 0, I'd never win; if p == 1, I'd always win; if p == 0.5, both games have the same odd for me.\n");
		System.out.println(mySolution.toString());
	}
}
