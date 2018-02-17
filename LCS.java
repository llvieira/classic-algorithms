import java.util.Scanner;

/**
* Calculate LSC using Dynamic Programming.
*
* @author Lucas Lima Vieira
*/

public class LCS {
	/**
	* Str1: abcdaf
	* Str2: zbcdf
	* ------------
	* Result: bcd
	*/
	public static int longestCommonSubstring(String str1, String str2) {
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		int max = 0;

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];

					if (max < matrix[i][j]) {
						max = matrix[i][j];					
					}
				}
			}
		}

		return max;
	}

	/**
	* Str1: abcdaf
	* Str2: zbcdf
	* ------------
	* Result: bcdf
	*/
	public static int longestCommonSubsequence(String str1, String str2) {
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);		
				}
			}
		}

		return matrix[str1.length()][str2.length()];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		System.out.println("Length Longest Common Substring: " + longestCommonSubstring(str1, str2));
		System.out.println("Length Longest Common Subsequence: " + longestCommonSubsequence(str1, str2));			
	}
}

