public class BinarySearch {

	public int binarySearch(int[] arr, int k) {
		int index = 0;
		int exp = 0;

		try {
			while (arr[index] < k) {
				index = (int) Math.pow(2, exp);
				exp++;
			}
			
			if (arr[index] == k) {
				return index;
			}
		} catch (Exception e) {}

		return binarySearch(arr, k, (index / 2) + 1, index - 1);
	}


	public int binarySearch(int[] arr, int k, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;

		try {
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] < k) {
				return binarySearch(arr, k, mid + 1, right);
			} else {
				return binarySearch(arr, k, left, mid - 1);
			}
		} catch (Exception e) {
			return binarySearch(arr, k, left, mid - 1);
		}
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		System.out.println(b.binarySearch(arr, 200));
	}
}
