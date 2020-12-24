package december17Graph;

import java.util.HashSet;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		boolean[][] graph = new boolean[6][6];
		graph[0][1] = true;
		graph[0][3] = true;
		graph[1][2] = true;
		graph[2][3] = true;
		graph[5][2] = true;
		graph[4][3] = true;
		topological(graph);
	}

	public static void topological(boolean[][] graph) {
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			if (visited.contains(i) == false) {
				topological(graph, i, visited, stack);
			}
		}

		while (stack.size() > 0) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void topological(boolean[][] graph, int source, HashSet<Integer> visited, Stack<Integer> stack) {
		visited.add(source);
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[source][j] == true) {
				if (visited.contains(j) == false) {
					topological(graph, j, visited, stack);
				}
			}
		}
		stack.add(source);
	}

}
