public class LargestContinuosSum {

	public int sum(int[] a) {
		int maxSum = a[0];
		int currentSum = a[0];

		// O(n)
		for (int i = 1; i < a.length; i++) {
			currentSum = Math.max(currentSum + a[i], a[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		LargestContinuosSum l = new LargestContinuosSum();
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};		
		System.out.println(l.sum(a)); // 7
	}
}
