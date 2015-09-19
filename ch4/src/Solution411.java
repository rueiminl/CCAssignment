import java.util.Random;

/**
 * Assumption: unique value; non-balanced
 * Delete: no rotation. just move deleted node's left to the right's leftmost position.
 * getRandomNode: maintain count for each node.
 * Complexity of getRandomNode: average O(logN) (generate logN random number); worst O(N) (due to non-balance)
 */
public class Solution411 {
	public static class Tree {
		private int val;
		private Tree left;
		private Tree right;
		private Tree parent;
		private int count = 1;
		public Tree(int val) {
			this.val = val;
		}
		public void insert(int value) {
			count++;
			if (value < this.val) {
				if (left == null) {
					left = new Tree(value);
					left.parent = this;
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new Tree(value);
					right.parent = this;
				} else {
					right.insert(value);
				}
			}
		}
		public Tree delete(int value) {
			Tree node = find(value);
			if (node == null)
				return this;
			Tree ancestor = node;
			while (ancestor != null) {
				ancestor.count--;
				ancestor = ancestor.parent;
			}
			if (node.left == null && node.right == null) {
				if (node.parent == null)
					return null; // delete this
				else {
					if (node.parent.left == node)
						node.parent.left = null;
					else
						node.parent.right = null;
					return this;
				}
			}
			if (node.left == null || node.right == null) {
				Tree onlyChild = node.left;
				if (onlyChild == null)
					onlyChild = node.right;
				if (node.parent == null)
					return onlyChild;
				else {
					if (node.parent.left == node)
						node.parent.left = onlyChild;
					else
						node.parent.right = onlyChild;
					return this;
				}
			}
			Tree leftmost = node.right;
			leftmost.count += node.left.count;
			while (leftmost.left != null) {
				leftmost = leftmost.left;
				leftmost.count += node.left.count;
			}
			leftmost.left = node.left;
			if (node.parent == null)
				return node.right;
			else {
				if (node.parent.left == node) {
					node.parent.left = node.right;
				} else {
					node.parent.right = node.right;
				}
				return node.right;
			}
		}
		public Tree find(int value) {
			if (val == value)
				return this;
			Tree result = null;
			if (left != null)
				result = left.find(value);
			if (result == null && right != null)
				result = right.find(value);
			return result;
		}
		public Tree getRandomNode() {
			Random rand = new Random();
			int r = rand.nextInt(count);
			if (r == 0) {
				return this;
			} else if (left != null && r - 1 < left.count) {
				return left.getRandomNode();
			} else {
				return right.getRandomNode();
			}
		}
	}
	
	public static void main(String[] args) {
		//      6
		//  2    7
		// 1  4
		//   3 5
		Tree root = new Tree(6);
		root.insert(2);
		root.insert(7);
		root.insert(1);
		root.insert(4);
		root.insert(3);
		root.insert(5);
		int[] count = new int[7];
		for (int i = 0; i < 7000; i++) {
			count[root.getRandomNode().val - 1]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println("count[" + (i+1) + "] = " + count[i]);
		}

		System.out.println("delete 6:");
		root = root.delete(6);
		for (int i = 0; i < count.length; i++)
			count[i] = 0;
		for (int i = 0; i < 7000; i++) {
			count[root.getRandomNode().val - 1]++;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.println("count[" + (i+1) + "] = " + count[i]);
		}
	}
}
