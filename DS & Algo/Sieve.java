import java.util.Arrays;

class Sieve {

	static int capacity = 1_000_000;
	static boolean[] primes = new boolean[capacity];

	public static void main(String args[]) {
		fillSieve();

		// few test cases
		System.out.println(isPrime(0));
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(16));
		System.out.println(isPrime(101));
	}
	public static void fillSieve() {

		// everything is a prime at first
		Arrays.fill(primes, true);

		// 0 and 1 are not prime
		primes[0] = primes[1] = false;

		for(int i = 2; i < primes.length; i++) {

			// if this is a prime number
			if(primes[i]) {

				// all of the primes numbers multiples are not prime
				for(int j = 2; i*j < primes.length; j++)
					primes[i*j] = false;
			}
		}
	}

	public static boolean isPrime(int n) {
		return primes[n];
	}
}
