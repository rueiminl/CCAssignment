
public class Solution105 {
	public static int sparseSearch(String[] strs, String target) {
		if (strs.length == 0)
			return -1;
		int cmp = target.compareTo(strs[0]);
		if (cmp < 0)
			return -1;
		if (cmp == 0)
			return 0;
		int lower = 0;
		int upper = strs.length - 1;
		while (lower < upper - 1) {
			int mid = (lower + upper) / 2;
			int nonempty = mid;
			while (nonempty < upper && strs[nonempty].equals("")) {
				nonempty++;
			}
			if (nonempty == upper) {
				upper = mid;
			}
			else {
				cmp = strs[nonempty].compareTo(target);
				if (cmp > 0) {
					upper = mid;
				}
				else if (cmp < 0) {
					lower = nonempty;
				}
				else if (cmp == 0)
					return nonempty;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String target = "ball";
		System.out.println("Output = " + sparseSearch(strs, target));
	}
}
