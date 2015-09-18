import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution49 {
	public static class Tree {
		public int val;
		public Tree left;
		public Tree right;
		Tree(int val) {
			this.val = val;
		}
	}
	private static void help(List<Tree> candidates, List<Integer> result, List<List<Integer>> results) {
		if (candidates.isEmpty()) {
			results.add(new ArrayList<Integer>(result));
			return;
		}
		Iterator<Tree> iter = new ArrayList<Tree>(candidates).iterator();
		while (iter.hasNext()) {
			Tree tree = iter.next();
			candidates.remove(tree);
			if (tree.left != null)
				candidates.add(tree.left);
			if (tree.right != null)
				candidates.add(tree.right);
			result.add(tree.val);
			help(candidates, result, results);
			result.remove(result.size() - 1);
			if (tree.right != null)
				candidates.remove(tree.right);			
			if (tree.left != null)
				candidates.remove(tree.left);
			candidates.add(tree);
		}
	}
	public static List<List<Integer>> BSTSequences(Tree tree) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		List<Tree> candidates = new ArrayList<Tree>();
		candidates.add(tree);
		help(candidates, result, results);
		return results;
	}
	public static void main(String[] args) {
		Tree tree = new Tree(2);
		tree.left = new Tree(1);
		tree.right = new Tree(3);
		List<List<Integer>> results = BSTSequences(tree);
		for (List<Integer> result : results) {
			for (Integer val : result) {
				System.out.print(val + " ");
			}
			System.out.println("");
		}
	}
}
