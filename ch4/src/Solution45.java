
public class Solution45 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}		
	
	// Assumption: nodes in the tree has unique value
	public static boolean validateBST(Tree tree) {
		// all left nodes' value < tree.value < all right nodes' value
		if (tree == null)
			return true;
		if (tree.left != null) {
			if (!validateBST(tree.left))
				return false;
			int test = max(tree.left);
			if (max(tree.left) >= tree.val)
				return false;
		}
		if (tree.right != null) {
			if (!validateBST(tree.right))
				return false;
			if (min(tree.right) <= tree.val)
				return false;
		}
		return true;
	}
	
	public static int min(Tree tree) {
		int result = tree.val;
		if (tree.left != null) {
			int minLeft = min(tree.left);
			if (minLeft < result)
				result = minLeft;
		}
		if (tree.right != null) {
			int minRight = min(tree.right);
			if (minRight < result)
				result = minRight;
		}
		return result;
	}
	
	public static int max(Tree tree) {
		int result = tree.val;
		if (tree.left != null) {
			int maxLeft = max(tree.left);
			if (maxLeft > result)
				result = maxLeft;
		}
		if (tree.right != null) {
			int maxRight = max(tree.right);
			if (maxRight > result)
				result = maxRight;
		}
		return result;
	}
		
	public static void main(String[] args) {
		System.out.println("Should be true:");
		Tree root = null;
		System.out.println(validateBST(root));
		root = new Tree(10);
		System.out.println(validateBST(root));
		root.left = new Tree(5);
		System.out.println(validateBST(root));
		root.right = new Tree(15);
		System.out.println(validateBST(root));
		root.left.right = new Tree(8);
		System.out.println(validateBST(root));
		root.right.left = new Tree(11);
		System.out.println(validateBST(root));
		
		System.out.println("Should be false:");
		root.right.right = new Tree(14);
		System.out.println(validateBST(root)); // 15 > 14
		root.right.right = new Tree(20); // fix it
		System.out.println("Should be true:");
		System.out.println(validateBST(root));
	}
}
