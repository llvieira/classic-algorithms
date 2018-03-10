/**
* Prim's MST algorithm using adjacency matrix.
*
* @author Lucas Lima Vieira
*/

public class MST {

	public static int minKey(int key[], boolean visited[], int V) {
        	int min = Integer.MAX_VALUE, min_index = -1;
 
		for (int v = 0; v < V; v++) {
			if (visited[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
 
		return min_index;
	}

	public static int[][] prim(int graph[][], int V) {
		int edges[][] = new int[V - 1][2];
		
		int key[] = new int[V];

		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		key[0] = 0;

		for (int i = 0; i < V; i++) {
			int index = minKey(key, visited, V);

			visited[index] = true;

			for (int j = 0; j < V; j++) {
				if (graph[index][j] != 0 && visited[j] == false && graph[index][j] < key[j]) {
					edges[j - 1][0] = index;
					edges[j - 1][1] = j;
					key[j] = graph[index][j];
				}
			}
		}

		return edges;
	}

	public static void main (String[] args) {
		MST t = new MST();
		int graph[][] = new int[][] {{0, 7, 0, 5, 0, 0, 0},
		                             {7, 0, 8, 9, 7, 0, 0},
		                             {0, 8, 0, 0, 5, 0, 0},
		                             {5, 9, 0, 0, 15, 6, 0},
		                             {0, 7, 5, 15, 0, 8, 9},
		                             {0, 0, 0, 6, 8, 0, 11},
		                             {0, 0, 0, 0, 9, 11, 0},
		                            };

		// https://www.urionlinejudge.com.br/judge/en/problems/view/1152
	 
		int edges[][] = t.prim(graph, 7);

		for (int i = 0; i < 6; i++) {
			System.out.println(edges[i][0] + " - " + edges[i][1]);
		}
    	}
}

