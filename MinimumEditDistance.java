import java.util.Scanner;

/**
* Implement Minimum Edit Distance using Dynamic Programming.
*
* @author Lucas Lima Vieira
*/

public class MinimumEditDistance {
	public static int editDistance(String str1, String str2) {
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			matrix[i][0] = i;
		}

		for (int j = 1; j <= str2.length(); j++) {
			matrix[0][j] = j;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					int tempMin = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
					matrix[i][j] = Math.min(tempMin, matrix[i][j - 1]) + 1; 
				}
			}
		}

		return matrix[str1.length()][str2.length()];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		System.out.println("Minimum Edit Distance: " + editDistance(str1, str2));
	}
}
