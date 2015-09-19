
/**
 * Algorithm: for each node, result += #paths which sums up to the target and ends at the node
 * Complexity: O(NlogN) (for each node = N; count #path = logN) 
 */
public class Solution412 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		public Tree parent;
		public Tree(int val) {
			this.val = val;
		}
		public Tree createLeft(int val) {
			left = new Tree(val);
			left.parent = this;
			return left;
		}
		public Tree createRight(int val) {
			right = new Tree(val);
			right.parent = this;
			return right;
		}
	}
	private static int endAt(Tree end, int target) {
		if (end == null)
			return 0;
		int result = 0;
		int sum = 0;
		Tree node = end;
		while (node != null) {
			sum += node.val;
			if (sum == target)
				result++;
			node = node.parent;
		}
		return result + endAt(end.left, target - end.val) + endAt(end.right, target - end.val);
	}

	public static int pathsWithSum(Tree root, int target) {
		return endAt(root, target);
	}
	public static void main(String[] args) {
		//     10
		// -10    9
		// 0 1 -19 
		Tree root = new Tree(10);
		Tree left = root.createLeft(-10);
		Tree right = root.createRight(9);
		Tree leftleft = left.createLeft(0);
		Tree leftright = left.createRight(1);
		Tree rightleft = right.createLeft(-19);
		int num = pathsWithSum(root, 0);
		System.out.println("pathsWithSum = " + num + " (should be 4 (1:10 -10, 2: 10 -10 0, 3: 10 9 -19, 4: 0))");
	}
}
