import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

/**
* Implement Depth-First Search.
*
* @author Lucas Lima Vieira
*/

public class DFS {
	public static void dfs(Graph graph) {
		for (Vertix vertix : graph.getVertices()) {
			if (vertix.visited == false) {
				dfsUtil(vertix);
			}
		}
	}

	public static void dfsUtil(Vertix vertix) {
		vertix.visited = true;
		System.out.print(vertix.value + " ");

		for (Vertix adj : vertix.adj) {
			if (adj.visited == false) {
				dfsUtil(adj);
			}
		}
	}

	public static void main(String args[]) {
		Graph graph1 = new Graph();

		Vertix v1 = new Vertix(1);
		Vertix v2 = new Vertix(2);
		Vertix v3 = new Vertix(3);
		Vertix v4 = new Vertix(4);
		Vertix v5 = new Vertix(5);

		graph1.addVertix(v1);
		graph1.addVertix(v2);
		graph1.addVertix(v3);
		graph1.addVertix(v4);

		graph1.addEdge(v1, v2);
		graph1.addEdge(v1, v3);
		graph1.addEdge(v1, v4);
		graph1.addEdge(v3, v5);

		// Output: 1, 2, 3, 5, 4
		dfs(graph1);
		System.out.println();

		Graph graph2 = new Graph();

		v1 = new Vertix(1);
		v2 = new Vertix(2);
		v3 = new Vertix(3);
		v4 = new Vertix(4);
		v5 = new Vertix(5);

		graph2.addVertix(v1);
		graph2.addVertix(v2);
		graph2.addVertix(v3);
		graph2.addVertix(v4);

		graph2.addEdge(v1, v3);
		graph2.addEdge(v3, v5);
		graph2.addEdge(v1, v4);
		graph2.addEdge(v4, v2);

		// Output: 1, 3, 5, 4, 2
		dfs(graph2);
		System.out.println();
	}
}

class Graph {
	HashMap<Integer, Vertix> graph;

	Graph() {
		graph = new HashMap<>();
	}

	void addVertix(Vertix vertix) {
		graph.put(vertix.value, vertix);
	}

	void addEdge(Vertix v1, Vertix v2) {
		Vertix v = graph.get(v1.value);
		v.adj.add(v2);
	}

	Collection<Vertix> getVertices() {
		return graph.values();
	}		
}

class Vertix {
	Integer value;
	boolean visited = false;
	ArrayList<Vertix> adj;

	Vertix(Integer value) {
		this.value = value;
		this.adj = new ArrayList<>();
	}	
}
