
public class Solution104 {
	public static class Listy {
		private int[] arr;
		private int size;
		public Listy(int[] arr, int size) {
			this.arr = arr;
			this.size = size;
		}
		public int get(int index) {
			if (index >= size)
				return -1;
			return arr[index];
		}
	}
	
	public static int sortedSearch(Listy lst, int value) {
		if (lst.get(0) == -1 || lst.get(0) > value)
			return -1;
		if (lst.get(0) == value)
			return 0;
		int lower = 0;
		int upper = 1;
		while (true) {
			int upperVal = lst.get(upper);
			if (upperVal == -1 || upperVal > value)
				break;
			if (upperVal == value)
				return upper;
			lower = upper;
			upper *= 2;
		}
		// assert(lst.get(lower) <= value < lst.get(upper) if not -1
		
		while (lower < upper - 1) {
			int mid = (lower + upper) / 2;
			int midVal = lst.get(mid);
			if (midVal == -1) {
				upper = mid; 
			}
		 	else if (midVal < value)
				lower = mid;
			else if (midVal > value)
				upper = mid;
			else
				return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		Listy lst = new Listy(new int[]{2,5,8,11}, 4);
		System.out.println("index of 1 in the Listy = " + sortedSearch(lst, 1));
		System.out.println("index of 2 in the Listy = " + sortedSearch(lst, 2));
		System.out.println("index of 5 in the Listy = " + sortedSearch(lst, 5));
		System.out.println("index of 8 in the Listy = " + sortedSearch(lst, 8));
		System.out.println("index of 11 in the Listy = " + sortedSearch(lst, 11));
		System.out.println("index of 12 in the Listy = " + sortedSearch(lst, 12));
	}
}
