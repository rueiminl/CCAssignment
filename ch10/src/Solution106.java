
public class Solution106 {
	public static void main(String[] args) {
		String myImplementation = "I would use merge sort to divide and conquer the sorting problem by taking advantage of file streaming.\nFor example, in first step, I could group 1000 lines as a file; in second step, I could merge two files into a 2000 lines file; in third step, I could merge two file into a 4000 lines; and so on.\nSince file streaming allows you to read sequential data, and write (append) sequential data, merge sort would do the trick!\nThat is, I could avoid the issue of insufficient RAM!";
		System.out.println(myImplementation);
	}
}
