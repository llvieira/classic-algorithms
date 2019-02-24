public class BinaryPalindrome {

	public boolean isPalindrome(int n) {
		return n == reverseBits(n);
	}

	public int reverseBits(int n) {
		int reverse = 0;

		while (n > 0) {
			reverse <<= 1;

			if ((n & 1) == 1) {
				reverse ^= 1;
			}

			n >>= 1;
		}

		return reverse;
	}

	public static void main(String[] args) {
		BinaryPalindrome p = new BinaryPalindrome();
		System.out.println(p.isPalindrome(1)); // true
		System.out.println(p.isPalindrome(2)); // false
		System.out.println(p.isPalindrome(3)); // true
		System.out.println(p.isPalindrome(4)); // false
		System.out.println(p.isPalindrome(5)); // true
		System.out.println(p.isPalindrome(51)); // true
		System.out.println(p.isPalindrome(13)); // false
		System.out.println(p.isPalindrome(17)); // true
	}
}
