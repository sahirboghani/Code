import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();	// capacity
		int N = sc.nextInt();	// number of items

		int weight[] = new int[N];
		int value[] = new int[N];

		for(int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		int capacity[] = new int[C+1];
		Arrays.fill(capacity, 0);

		for(int i = 0; i < N; i++) {
			for(int j = C; j >= 0; j--) {
				if(j >= weight[i]) {	// does this item fit in this sack
					capacity[j] = capacity[j] >= (capacity[j-weight[i]] + value[i]) ? capacity[j] : (capacity[j-weight[i]] + value[i]); 
				}
			}
		}

		System.out.print(capacity[C]);
	}
}