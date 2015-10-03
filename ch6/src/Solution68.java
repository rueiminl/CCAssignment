
public class Solution68 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append(""
			+ "If I drop the first egg from K-th floor, if it's broken, I couldn't affort another failure, so I must test one floor by one floor, which takes K turns in the worst case.\n"
			+ "On the other hand, if it's not broken, then I can remove K situtaion in 1 turn.\n"
			+ "Therefore, I could narrow down the candidates to K possible situation in 100/K steps.\n"
			+ "The worst case would be 100/K + (K-1).\n"
			+ "K   test\n"
			+ "1   100\n"
			+ "2   50+1 = 51\n"
			+ "3   33+2 = 35\n"
			+ "4   25+3 = 28\n"
			+ "...\n"
			+ "7   14+6 = 20\n"
			+ "8   12+7 = 19\n"
			+ "9   11+8 = 19\n"
			+ "10  10+9 = 19\n"
			+ "11  9+10 = 19\n"
			+ "12  8+11 = 19\n"
			+ "13  7+12 = 19\n"
			+ "14  7+13 = 20\n"
			+ "...etc\n"
			+ "So the minimum test would be 19 time!\n"
		);
		System.out.println(mySolution.toString());
	}	
}
