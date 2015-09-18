import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution41 {
	public static class DirectedGraph {
		private int id;
		private List<DirectedGraph> nexts = new ArrayList<DirectedGraph>();
		public DirectedGraph(int id) {
			this.id = id;
		}
		public void addNext(DirectedGraph next) {
			nexts.add(next);
		}
	}
	/**
	 * Complexity: O(V)
	 */
	public static boolean routeBetweenNodes(DirectedGraph src, DirectedGraph dst) {
		if (src == dst)
			return true;
		HashSet<DirectedGraph> pendings = new HashSet<DirectedGraph>();
		HashSet<DirectedGraph> done = new HashSet<DirectedGraph>();
		pendings.add(src);
		while (!pendings.isEmpty()) {
			DirectedGraph node = pendings.iterator().next();
			pendings.remove(node);
			done.add(node);
			for (DirectedGraph next : node.nexts) {
				if (next == dst)
					return true;
				if (done.contains(next))
					continue;
				if (pendings.contains(next))
					continue;
				pendings.add(next);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// 1->2<->3
		//    +->4
		DirectedGraph n1 = new DirectedGraph(1);
		DirectedGraph n2 = new DirectedGraph(2);
		DirectedGraph n3 = new DirectedGraph(3);
		DirectedGraph n4 = new DirectedGraph(4);
		n1.addNext(n2);
		n2.addNext(n3);
		n2.addNext(n4);
		n3.addNext(n2);
		
		System.out.println("Should be true:");
		System.out.println("hasRoute(n1,n2) = " + routeBetweenNodes(n1, n2));
		System.out.println("hasRoute(n1,n3) = " + routeBetweenNodes(n1, n3));
		System.out.println("hasRoute(n1,n4) = " + routeBetweenNodes(n1, n4));
		System.out.println("hasRoute(n2,n3) = " + routeBetweenNodes(n2, n3));
		System.out.println("hasRoute(n2,n4) = " + routeBetweenNodes(n2, n4));
		System.out.println("hasRoute(n3,n2) = " + routeBetweenNodes(n3, n2));
		System.out.println("hasRoute(n3,n4) = " + routeBetweenNodes(n3, n4));
		System.out.println("Should be false:");
		System.out.println("hasRoute(n4,n2) = " + routeBetweenNodes(n4, n2));
		System.out.println("hasRoute(n4,n1) = " + routeBetweenNodes(n4, n1));
		System.out.println("hasRoute(n3,n1) = " + routeBetweenNodes(n3, n1));
	}
}
