import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Solution43 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}
	private static void help(Tree root, int level, Vector<List<Integer>> result) {
		if (root == null)
			return;
		while (result.size() <= level)
			result.addElement(new ArrayList<Integer>());
		result.get(level).add(root.val);
		help(root.left, level + 1, result);
		help(root.right, level + 1, result);
	}
	public static Vector<List<Integer>> listOfDepths(Tree root) {
		Vector<List<Integer>> result = new Vector<List<Integer>>();
		help(root, 0, result);
		return result;
	}
	public static void main(String[] args) {
		Tree root = new Tree(1);
		root.left = new Tree(2); root.right = new Tree(3);
		root.left.right = new Tree(4); root.right.left = new Tree(5); root.right.right = new Tree(6);
		root.left.right.left = new Tree(7); root.right.left.right = new Tree(8); root.right.right.left = new Tree(9); root.right.right.right = new Tree(10); 
		Vector<List<Integer>> result = listOfDepths(root);
		for (List<Integer> depth : result) {
			for (Integer value : depth) {
				System.out.print(value + " ");
			}
			System.out.println("");
		}
	}
}
