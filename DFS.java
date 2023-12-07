import java.util.LinkedList;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		Graph graph = new Graph(7);

		graph.addEdge(0, 1);

		graph.dfs(0);
	}

}

class Graph {
	private int vertices;
	private LinkedList<Integer>[] list;

	public Graph(int vertices) {
		this.vertices = vertices;
		list = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			list[i] = new LinkedList<>();
		}

	}

	public void addEdge(int v, int w) {
		list[v].add(w);
	}

	public void dfs(int start) {
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();

		visited[start] = true;
		stack.push(start);

		while (!stack.isEmpty()) {
			int curr = stack.pop();

			for (int neighbor : list[curr]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					stack.push(neighbor);
				}
			}

		}

	}

}
