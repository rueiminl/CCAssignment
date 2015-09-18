
public class Solution48 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}
	/**
	 * Assumption: given the root.
	 * Assumption: tree1 and tree2 must be the descendants of root
	 */
	public static Tree findCommonAncestor(Tree root, Tree tree1, Tree tree2) {
		if (ancestor(root.left, tree1) && ancestor(root.left, tree2))
			return findCommonAncestor(root.left, tree1, tree2);
		if (ancestor(root.right, tree1) && ancestor(root.right, tree2))
			return findCommonAncestor(root.right, tree1, tree2);
		return root;
	}
	
	private static boolean ancestor(Tree a, Tree d) {
		if (a == null)
			return false;
		if (a == d)
			return true;
		if (ancestor(a.left, d))
			return true;
		if (ancestor(a.right, d))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Tree root = new Tree(1);
		Tree left = root.left = new Tree(2); 
		Tree right = root.right = new Tree(3); 
		Tree leftleft = root.left.left = new Tree(4); 
		Tree leftright = root.left.right = new Tree(5); 
		Tree rightleft = root.right.left = new Tree(6); 
		Tree rightright = root.right.right = new Tree(7);
		System.out.println("Should be root (1):");
		System.out.println("commonAncestor(root,root) = " + findCommonAncestor(root, root, root).val);
		System.out.println("commonAncestor(root,left) = " + findCommonAncestor(root, root, left).val);
		System.out.println("commonAncestor(root,left.left) = " + findCommonAncestor(root, root, leftleft).val);
		System.out.println("commonAncestor(left,right) = " + findCommonAncestor(root, left, right).val);
		System.out.println("commonAncestor(left.left,right.right) = " + findCommonAncestor(root, leftleft, rightright).val);
		System.out.println("Should be left (2):");
		System.out.println("commonAncestor(left.left,left.right) = " + findCommonAncestor(root, leftleft, leftright).val);
	}
}
