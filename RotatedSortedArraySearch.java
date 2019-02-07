public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        int pivot = findPivot(a, 0, a.size() - 1);
        
        if (pivot == -1) {
            return binarySearch(a, b, 0, a.size() - 1);
        }
        
        if (b == a.get(pivot)) {
            return pivot;
        }
        
        if (b < a.get(0)) {
            return binarySearch(a, b, pivot + 1, a.size() - 1);
        }
        
        return binarySearch(a, b, 0, pivot);
    }
    
    private int findPivot(final List<Integer> a, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int middle = left + (right - left) / 2;
        
        if (middle < right && a.get(middle) > a.get(middle + 1)) {
            return middle;
        } else if (middle > left && a.get(middle) <  a.get(middle - 1)) {
            return middle - 1;
        } else if (a.get(left) >= a.get(middle)) {
            return findPivot(a, left, middle - 1);
        } else {
            return findPivot(a, middle + 1, right);
        }
    }
    
    private int binarySearch(final List<Integer> a, int b, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int middle = left + (right - left) / 2;
        
        if (b == a.get(middle)) {
            return middle;
        } else if (b < a.get(middle)) {
            return binarySearch(a, b, left, middle - 1);
        } else {
            return binarySearch(a, b, middle + 1, right);
        }
    }
}

