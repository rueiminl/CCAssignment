
public class Solution103 {
	
	/** 
	 * Assumption: No duplicated data in the given rotated array
	 */
	public static int searchInRotatedArray(int[] array, int value) {
		int lower = 0;
		int upper = array.length - 1;
		if (array[upper] == value)
			return upper + 1;
		boolean rotation = (array[lower] > array[upper]);
		while (lower < upper - 1) {
			int mid = (lower + upper) / 2;
			if (!rotation) {
				if (value < array[mid])
					upper = mid;
				else
					lower = mid;
			}
			else {
				if (array[mid] > array[lower]) {
					if (value >= array[lower] && value < array[mid]) {
						rotation = false;
						upper = mid;
					}
					else {
						lower = mid;
					}
				}
				else {
					if (value >= array[mid] && value < array[upper]) {
						rotation = false;
						lower = mid;
					}
					else
						upper = mid;
				}
			}
		}
		if (array[lower] == value)
			return lower + 1;
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {15, 16, 19, 20, 25, 1, 3, 5, 7, 10, 14};
		System.out.println("The position of 5 is at index " + searchInRotatedArray(array, 5));
	}
}
