
public class Solution46 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		public Tree parent;
		Tree(int val) {
			this.val = val;
		}
		Tree createLeft(int val) {
			left = new Tree(val);
			left.parent = this;
			return left;
		}
		Tree createRight(int val) {
			right = new Tree(val);
			right.parent = this;
			return right;
		}
	}
	public static Tree successor(Tree node) {
		if (node == null)
			return null;
		if (node.left != null) {
			Tree rightmost = node.left;
			while (rightmost.right != null)
				rightmost = rightmost.right;
			return rightmost;
		}
		if (node.parent.right == node)
			return node.parent;
		Tree rightmost = node;
		while (rightmost.parent != null && rightmost.parent.left == rightmost)
			rightmost = rightmost.parent;
		if (rightmost.parent == null)
			return null;
		return rightmost.parent;
	}
	public static void main(String[] args) {
		//    4
		//  2   6
		// 1 3 5 7
		Tree tree = new Tree(4);
		Tree left = tree.createLeft(2);
		Tree right = tree.createRight(6);
		Tree leftleft = left.createLeft(1);
		Tree leftright = left.createRight(3);
		Tree rightleft = right.createLeft(5);
		Tree rightright = right.createRight(7);
		Tree node = rightright;
		while (node != null) {
			System.out.print(node.val + " ");
			node = successor(node);
		}
		System.out.println("");
	}
}
