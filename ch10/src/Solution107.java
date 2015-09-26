
public class Solution107 {
	public static void main(String[] args) {
		String myImplementation = "Since I've got 1GB memory, I could have 1 billion bit.\nIn this case, I'd like to run 4 iteration; the first iteration to seek if there is any miss number in the range of 0 to 1 billion; the second iteration (needed only if the first iteration can not find any) find miss number in the range from 1 billion to 2 billion; and so on.\n";
		myImplementation += "Follow Up:\n";
		myImplementation += "Similar solution, I would check 1G/10M = 100 iteration; the first iteration check the range from 0 to 10 million; the second iteration check the range from 10 million to 20 million; and so on.\n";
		System.out.println(myImplementation);
	}
}
