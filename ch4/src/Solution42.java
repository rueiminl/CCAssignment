import java.util.Arrays;

/**
 * Algorithm: recursive.
 */
public class Solution42 {
	public static class Tree {
		public int id;
		public Tree left;
		public Tree right;
		Tree(int id) {
			this.id = id;
		}
	}
	public static Tree createTree(int[] sortedUniqueArray) {
		if (sortedUniqueArray.length == 0)
			return null;
		int numLeft = sortedUniqueArray.length / 2;
		int numRight = sortedUniqueArray.length - 1 - numLeft;
		Tree tree = new Tree(sortedUniqueArray[numLeft]);
		tree.left = createTree(Arrays.copyOfRange(sortedUniqueArray, 0, numLeft));
		tree.right = createTree(Arrays.copyOfRange(sortedUniqueArray, numLeft + 1, sortedUniqueArray.length));
		return tree;
	}
	public static void main(String[] args) {
		int[] sortedUniqueArray = new int[]{1,2,3,4,5,6,7};
		Tree tree = createTree(sortedUniqueArray);
		System.out.println("   " + tree.id);
		System.out.println(" " + tree.left.id + "   " + tree.right.id);
		System.out.println(tree.left.left.id + " " + tree.left.right.id + " " + tree.right.left.id + " " + tree.right.right.id);
	}
}
