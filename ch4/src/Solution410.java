
public class Solution410 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}	
	public static boolean checkSubtree(Tree big, Tree small) {
		if (small == null)
			return true;
		if (big == null)
			return false;
		if (big.val == small.val) {
			if (checkSame(big, small))
				return true;
		}
		return checkSubtree(big.left, small) || checkSubtree(big.right, small);
	}
	private static boolean checkSame(Tree t1, Tree t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return t1.val == t2.val && checkSame(t1.left, t2.left) && checkSame(t1.right, t2.right);
	}
	public static void main(String[] args) {
		Tree big = new Tree(1);
		big.left = new Tree(2);
		big.right = new Tree(3);
		big.right.left = new Tree(4);
		big.right.right = new Tree(5);
		Tree small = new Tree(3);
		small.left = new Tree(4);
		small.right = new Tree(5);
		System.out.println("the small tree should be in the big tree: " + checkSubtree(big, small));
	}
}
