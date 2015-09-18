import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution47 {
	public static class Dependency {
		public int first;
		public int second;
		public Dependency(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	public static List<Integer> buildOrder(List<Integer> projects, List<Dependency> dependencies) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, HashSet<Integer>> before = new HashMap<Integer, HashSet<Integer>>();
		Map<Integer, HashSet<Integer>> after = new HashMap<Integer, HashSet<Integer>>();
		for (Dependency dependency : dependencies) {
			if (!after.containsKey(dependency.second)) {
				after.put(dependency.second, new HashSet<Integer>());
			}
			after.get(dependency.second).add(dependency.first);
			if (!before.containsKey(dependency.first)) {
				before.put(dependency.first, new HashSet<Integer>());
			}
			before.get(dependency.first).add(dependency.second);
		}
		List<Integer> free = new ArrayList<Integer>();
		// get all project whose dependencies is empty
		for (Integer project : projects) {
			if (!before.containsKey(project)) {
				free.add(project);
			}
		}
		while (!free.isEmpty()) {
			Integer project = free.get(0);
			free.remove(0);
			// finish the project
			result.add(project);
			if (after.containsKey(project)) {
				HashSet<Integer> relatedProjects= after.get(project);
				for (Integer relatedProject : relatedProjects) {
					if (before.containsKey(relatedProject)) {
						HashSet<Integer> dependenciesInRelatedProject = before.get(relatedProject); 
						dependenciesInRelatedProject.remove(project);
						if (dependenciesInRelatedProject.isEmpty()) {
							free.add(relatedProject);
							before.remove(dependenciesInRelatedProject);
						}
					}
				}
			}
		}
		if (result.size() == projects.size())
			return result;
		else
			return null;
	}
	public static void main(String[] args) {
		List<Integer> projects = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++)
			projects.add(i);
		List<Dependency> dependencies = new ArrayList<Dependency>();
		dependencies.add(new Dependency(4,1));
		dependencies.add(new Dependency(2,5));
		dependencies.add(new Dependency(4,2));
		dependencies.add(new Dependency(1,5));
		dependencies.add(new Dependency(3,4));
		List<Integer> order = buildOrder(projects, dependencies);
		if (order != null) {
			for (Integer project : order) {
				System.out.print(project + " ");
			}
			System.out.println("");
		}
		
		dependencies.add(new Dependency(5,6));
		dependencies.add(new Dependency(6,5));
		order = buildOrder(projects, dependencies);
		System.out.println("should be no solution: " + order);
		
	}
}
