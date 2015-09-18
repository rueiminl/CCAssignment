
public class Solution44 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}	
	public static int height(Tree tree) {
		if (tree == null)
			return 0;
		return 1 + Math.max(height(tree.left), height(tree.right));
	}
	public static boolean checkBalance(Tree tree) {
		if (tree == null)
			return true;
		return Math.abs(height(tree.left) - height(tree.right)) <= 1 && checkBalance(tree.left) && checkBalance(tree.right);
	}
	public static void main(String[] args) {
		System.out.println("Should be true:");
		Tree root = null;
		System.out.println(checkBalance(root));
		root = new Tree(1);
		System.out.println(checkBalance(root));
		root.left = new Tree(2);
		System.out.println(checkBalance(root));
		root.right = new Tree(3);
		System.out.println(checkBalance(root));
		root.left.right = new Tree(4);
		System.out.println(checkBalance(root));
		root.right.left = new Tree(5);
		System.out.println(checkBalance(root));
		
		System.out.println("Should be false:");
		root.left.right.right = new Tree(6);
		System.out.println(checkBalance(root));
	}
}
