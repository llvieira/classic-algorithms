import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

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
		System.out.println(vertix.value);

		for (Vertix adj : vertix.adj) {
			if (adj.visited == false) {
				dfsUtil(adj);
			}
		}
	}

	public static void main(String args[]) {
		Graph graph = new Graph();

		Vertix v1 = new Vertix(1);
		Vertix v2 = new Vertix(2);
		Vertix v3 = new Vertix(3);
		Vertix v4 = new Vertix(4);
		Vertix v5 = new Vertix(5);

		graph.addVertix(v1);
		graph.addVertix(v2);
		graph.addVertix(v3);
		graph.addVertix(v4);

		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v1, v4);
		graph.addEdge(v3, v5);

		dfs(graph);
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
