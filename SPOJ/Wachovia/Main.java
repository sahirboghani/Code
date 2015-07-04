import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// Number of instances
		
		for(int i = 0; i < N; i++) {

			int K = sc.nextInt(); // max weight of truck
			int M = sc.nextInt(); // number of bags in the bank

			int weight[] = new int[M];
			int value[] = new int[M];

			for(int j = 0; j < M; j++) {
				weight[j] = sc.nextInt();
				value[j] = sc.nextInt();
			}

			int capacity[] = new int[K+1];
			Arrays.fill(capacity, 0);

			for(int x = 0; x < M; x++) {	// for each item
				for(int y = K; y >= 0; y--) {	// for each knapsack cap
					if(y >= weight[x]) {	// does this item even fit
						capacity[y] = capacity[y] >= (capacity[y-weight[x]] + value[x]) ? capacity[y] : (capacity[y-weight[x]] + value[x]);
					}
				}
			}

			System.out.println("Hey stupid robber, you can get " + capacity[K] + ".");
		}
	}
}