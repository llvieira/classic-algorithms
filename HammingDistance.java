public class HammingDistance {

	// a     = 101011
	// b     = 000010
	// ---------------
	// a ^ b = 101001
	
	// get last bit using: & 1
	// increment the distance if the last bit is 1
	// shift to right >> 1 to get the next bit

	public int getDistance(int a, int b) {
		int distance = 0;
		int differentBits = a ^ b;

		while (differentBits > 0) {
			distance += differentBits & 1;

			differentBits >>= 1;
		}

		return distance;
	}

	public static void main(String[] args) {
		System.out.println(new HammingDistance().getDistance(
			Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}