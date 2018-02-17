/**
* Calculates the Fibonacci using Dynamic Programming.
*
* @author Lucas Lima Vieira
*/

public class Fibonacci {
	public static int fib(int n) {
		int[] array = new int[n + 1];
		array[0] = 0;
		array[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}

		return array[n];		
	}

	public static void main(String args[]) {
		// Output: 5
		System.out.println(fib(5));
		
		// Output: 75025
		System.out.println(fib(25));
	}
}
