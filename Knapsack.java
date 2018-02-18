/**
* Implements Knapsack problem using Dynamic Programming.
*
* @author Lucas Lima Vieira
*/

public class Knapsack {

	public static int knapsack(int[][] items, int W) {
		int[][] matrix = new int[items.length + 1][W + 1];

		for (int i = 1; i <= items.length; i++) {
			for (int j = 1; j <= W; j++) {
				int weigth = items[i - 1][0];

				if (j < weigth) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					int value = items[i - 1][1];
					matrix[i][j] = Math.max(matrix[i - 1][j], value + matrix[i - 1][j - weigth]);
				}
			}
		}

		return matrix[items.length][W];
	}
	
	public static void main(String args[]) {
		// {weigth, value}	
		int[][] items = {{2, 12}, {1, 10}, {3, 20}, {2, 15}};
		int W = 5;

		// Output: 37
		System.out.println(knapsack(items, W));		
	}
}
