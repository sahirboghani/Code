import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

class sumfour {

	static long[] ab;
	static long[] cd;

	public static void main(String args[]) throws IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(in.readLine());
		int i, j, k, N, answer = 0;	

		Map<Long, Long> map = new HashMap<Long, Long>();
		
		N = Integer.parseInt(token.nextToken());
	
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
	
		for(i = 0; i != N; ++i) {
				token = new StringTokenizer(in.readLine());
				a[i] = Integer.parseInt(token.nextToken());
				b[i] = Integer.parseInt(token.nextToken());
				c[i] = Integer.parseInt(token.nextToken());
				d[i] = Integer.parseInt(token.nextToken());
		}

/*		System.out.println("-------------------------------");
		for(int e = 0; e != N; ++e) {
			for(int f = 0; f != N; ++f) {
				for(int g = 0; g != N; ++g) {
					for(int h = 0; h != N; ++h) {
						if((a[e] + b[f] + c[g] + d[h]) == 0)
							System.out.println(a[e] + " " + b[f] + " " + c[g] + " " + d[h]);
					}
				}
			}
		}
		
		System.out.println("-------------------------------");
*/
		ab = new long[N*N];
		cd = new long[N*N];
	
		k = 0;	

		for(i = 0; i != N; ++i) {
			for(j = 0; j != N; ++j) {
				ab[k] = a[i] + b[j];
				cd[k++] = c[i] + d[j];
//				System.out.println("ab: " + ab[k-1]);
//				System.out.println("cd: " + cd[k-1] + "\n");
			}
		}

		// Arrays.sort(ab);
		Arrays.sort(cd);

//		System.out.println();
//		for(i = 0; i != N*N; ++i)
//		System.out.println(ab[i] + " " + cd[i]);
//		System.out.println();

		answer = 0;

		long compliment, hits;

		long limit = N*N;

		for(i = 0; i != limit; ++i) {
			// if you're in map, retrieve it
			if(map.containsKey(ab[i])) {
				answer += map.get(ab[i]);
				continue;
			}



			// else find what the compliment is
			compliment = 0 - ab[i];

//			if(compliment == 2)
//				System.out.println("Here " + ab[i]);

			hits = 0;
			
			// find it's index with binary search
			int index = bs(compliment);

//			if(compliment == 2)
//				System.out.println("Here " + index);

			if(index != -1)
				hits = numHits(index);

			answer += hits;
			map.put(ab[i], hits);
		}

		System.out.println(answer);

//		for(long l: map.keySet())
//			System.out.println(l + ": " + map.get(l));		
	}


	// binary search through cd for the compliment
	static int bs(long val) {
		return bs(val, 0, cd.length-1);
	}

	static int bs(long val, int left, int right) {
		if(left > right)
			return -1;

		int mid = left + (right-left)/2;
		
		if(cd[mid] > val)
			return bs(val, left, mid-1);
		if(cd[mid] < val)
			return bs(val, mid+1, right);
		return mid;
	}

	static int numHits(int index) {
		
		int hits = 1;
		long val = cd[index];
		int i = index-1;
		int limit = -1;
		
		while(i != limit && cd[i--] == val)
			++hits;

		i = index + 1;
		limit = cd.length;

		while(i != limit && cd[i++] == val)
			++hits;

		return hits;
	}
}
