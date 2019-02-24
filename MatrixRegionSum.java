public class MatrixRegionSum {

	// precompute the sum of every rectangle with top left coordinate as (0, 0)
	// this method take O(MN)
	public int[][] precomputeSum(int[][] matrix) {
		int[][] sum = new int[matrix.length][matrix[0].length];
		sum[0][0] = matrix[0][0];

		// sum up matrix first line
		for (int i = 1; i < matrix[0].length; i++) {
			sum[0][i] = sum[0][i - 1] + matrix[0][i];
		}

		// sum up matrix first column
		for (int i = 1; i < matrix.length; i++) {
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		}

		// sum up the remaining cells
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i][j] - sum[i - 1][j - 1];
			}
		}

		return sum;
	}

	// this method take O(1), thanks dynamic programming
	public int matrixRegionSum(int[][] matrix, Coord A, Coord D, int[][] sum) {
		int OA = 0, OB = 0, OC = 0;

		if (A.x > 0 && A.y > 0) {
			OA = sum[A.x - 1][A.y - 1];
		}

		if (A.x > 0) {
			OB = sum[A.x - 1][D.y];
		}

		if (A.y > 0) {
			OC = sum[D.x][A.y - 1];
		}		
		
		int OD = sum[D.x][D.y];

		return OD - OC - OB + OA;
	}

	public static void main(String[] args) {
		MatrixRegionSum max = new MatrixRegionSum();

		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 1, 2, 3}};

		int[][] sum = max.precomputeSum(matrix);
		int result = max.matrixRegionSum(matrix, new Coord(1, 2), new Coord(2, 3), sum);
		
		System.out.println(result);
	}
}

class Coord {
	int x, y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
