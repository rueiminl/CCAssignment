
public class Solution61 {
	public static void main(String[] args) {
		StringBuffer mySolution = new StringBuffer();
		mySolution.append("I will get 1 pill from bottle 1, 2 pills from bottle 2, ...\n");
		mySolution.append("In this way, I would get 1+2+..+20 = 210 pills, so the weight should be 210 grams if all pills are the same weight.\n");
		mySolution.append("Therefore, if the weight is, for example, 211.3 grams, then I could know that the pills in bottle 13 is weighted 1.1 grams, since the total difference of weight is 1.3 grams.");
		System.out.println(mySolution.toString());
	}
}
