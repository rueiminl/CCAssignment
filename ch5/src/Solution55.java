
public class Solution55 {
	public static void main(String[] args) {
		String debugger = "It tests if n has at most 1 bit that has value 1.\n";
		debugger += "The reason is that the only way that n & (n-1) == 0 is 00...0|1|00...0 & 00...0|0|11...1\n";
		debugger += "(in addition to the case n == 0)\n";
		System.out.print(debugger);
	}
}
