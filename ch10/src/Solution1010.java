import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution1010 {
	TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>(); 
	public void track(int x) {
		if (!count.containsKey(x))
			count.put(x, 0);
		count.put(x, count.get(x) + 1);
	}
	public int getRankOfNumber(int x) {
		int rank = 0;
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			if (entry.getKey() < x)
				rank += entry.getValue();
			else {
				if (entry.getKey() == x)
					rank += entry.getValue() - 1;
				break;
			}
		}
		return rank;
	}
	public static void main(String[] args) {
		Solution1010 stream = new Solution1010();
		stream.track(5);
		stream.track(1);
		stream.track(4);
		stream.track(4);
		stream.track(5);
		stream.track(9);
		stream.track(7);
		stream.track(13);
		stream.track(3);
		int[] test = {1,3,4};
		for (int i = 0; i < test.length; i++)
			System.out.println("rank of " + test[i] + " = " + stream.getRankOfNumber(test[i]));
	}
}
