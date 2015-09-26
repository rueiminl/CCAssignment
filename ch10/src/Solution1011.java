import java.util.Arrays;

public class Solution1011 {
	public static int[] peaksAndValleys(int[] input) {
		int[] output = Arrays.copyOf(input, input.length);
		Arrays.sort(output);
		int[] part1 = Arrays.copyOf(output,  output.length / 2);
		int[] part2 = Arrays.copyOfRange(output, output.length / 2, output.length);
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < part1.length || j < part2.length) {
			if (j < part2.length)
				output[k++] = part2[j++];
			if (i < part1.length)
				output[k++] = part1[i++];
		}
		return output;
	}
	public static void main(String[] args) {
		int[] input = {5,3,1,2,3};
		int[] output = peaksAndValleys(input);
		for (int i = 0; i < output.length; i++)
			System.out.print(output[i] + " ");
		System.out.println("");
	}
}
