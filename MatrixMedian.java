import java.util.ArrayList;

public class MatrixMedian {
	public int upperBound(ArrayList<Integer> a, int b) {
        return upperBound(a, b, 0, a.size() - 1);
    }
    
    private int upperBound(ArrayList<Integer> a, int b, int start, int end) {
        if (start > end) {
            return start;
        }

        int midIndex = start + (end  - start) / 2;
        int middle = a.get(midIndex);
        
        if (midIndex < a.size() - 1 && b == middle && middle < a.get(midIndex + 1)) {
            return midIndex + 1;
        } else if (b < middle) {
            return upperBound(a, b, start, midIndex - 1);
        } else {
            return upperBound(a, b, midIndex + 1, end);
        }
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int min = A.get(0).get(0);
        int max = A.get(0).get(0);

        for (int i = 0; i < n; i++) {
            // get min
            if (A.get(i).get(0) < min) {
                min = A.get(i).get(0);
            }

            // get max
            if (A.get(i).get(m - 1) > max) {
                max = A.get(i).get(m - 1);
            }
        }

        int desired = (m * n + 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            // TODO: better name? what place means? check for another solutions
            int place = 0;

            for (int i = 0; i < n; i++) {
                // upper_bound
                place += upperBound(A.get(i), mid);
            }

            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		ArrayList<Integer> a = new ArrayList<>();

		a.add(1);
		a.add(3);
		a.add(5);
		a.add(5);
		a.add(10);
		a.add(10);
		// a.add(10);



		System.out.println(s.upperBound(a, 5));
	}
}

