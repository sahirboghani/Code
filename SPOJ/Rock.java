import java.util.Scanner;

class Rock {

	static int[] test;
	static int[][] DP;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		while(n-- > 0) {
			int a = sc.nextInt();
			test = new int[a];
			String temp = sc.next();
			for(int i = 0; i < a; ++i)
				test[i] = temp.charAt(i) - '0';

			DP = new int[a][a];
			for(int i = 0; i < a; ++i)
				for(int j = 0; j < a; ++j)
					DP[i][j] = -1;

			System.out.println(solve(0, a-1));
		}
	}

	public static int solve(int i, int j) {
		if(DP[i][j] != -1)
			return DP[i][j];
		if(i == j) {
			DP[i][j] = test[i];
			return DP[i][j];
		}
		if(moreSugar(i, j)) {
			DP[i][j] = j - i + 1;
			return DP[i][j];	
		}

		for(int x = i; x < j; ++x) {
			DP[i][j] = Math.max(DP[i][j], solve(i,x) + solve(x+1, j));
		}

		return DP[i][j];
	}

	public static boolean moreSugar(int i, int j) {
		int count = 0;
		for(; i <= j; ++i)
			if(test[i] == 1)
				++count;
			else 
				--count;
		return count > 0;
	}
}