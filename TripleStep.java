import java.math.BigInteger; 

public class TripleStep {

	public BigInteger tripleStep(int n) {
		BigInteger[] arr = new BigInteger[n + 1];

		return tripleStep(n, arr);
	}

	public BigInteger tripleStep(int n, BigInteger[] arr) {
		if (n < 0) {
			return BigInteger.valueOf(0);
		} else if (n == 0) {
			return BigInteger.valueOf(1);
		}

		if (arr[n] == null) {
			arr[n] = tripleStep(n - 1, arr).add(tripleStep(n - 2, arr)).add(tripleStep(n - 3, arr));
		}

		return arr[n];
	}

	public static void main(String[] args) {
		TripleStep tripleStep = new TripleStep();
		System.out.println(tripleStep.tripleStep(Integer.parseInt(args[0])));
	}
}