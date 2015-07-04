import java.util.Scanner;
import java.util.*;

class Main {

	static HashMap<Integer, Long> vals = new HashMap<Integer, Long>();

	public static void main(String args[]) {

		vals.put(0,(long)0);
		vals.put(1,(long)1);
		vals.put(2,(long)2);
		vals.put(3,(long)3);
		vals.put(4,(long)4);

		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
				long N = sc.nextLong();
				System.out.println(run(N));
		}
	}
	public static long run(long n) {
		if(vals.containsKey((int)n))
			return vals.get((int)n);

		long halfValue = run(n/2);
		long thirdValue = run(n/3);
		long fourthValue = run(n/4);

		long intermediate = halfValue + thirdValue + fourthValue;
		if(n > intermediate) {
			vals.put((int)n,n);
			return n;
		}
		else {
			vals.put((int)n, intermediate);
			return intermediate;
		}
		/*
		else {
			long maxHalf = run(halfValue);
			long maxThird = run(thirdValue);
			long maxFourth = run(fourthValue);

			long result = maxHalf + maxThird + maxFourth;
			if(result > n) {
				vals.put((int)n, result);
				return result;
			}
			else {
				vals.put((int)n, n);
				return n;
			}
		}*/
	}
}

/*
				long max[] = new long[N+1];
				if(N < 12) {
					System.out.println(N);
					continue;
				}for(int i = 0; i < 12; i++) {
					max[i] = i;
				}
				for(int i = 12; i <= N; i++) {
					max[i] = i >= (max[i/2]+max[i/3]+max[i/4]) ? i : (max[i/2]+max[i/3]+max[i/4]);
				}
				System.out.println(max[N]);
*/