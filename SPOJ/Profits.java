import java.util.Scanner;

class Profits {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N;
	
		int[] dp;

		while(true) {
	
			N = sc.nextInt();
	
			if(N == 0)
				break;

			dp = new int[N];
			int temp;

			dp[0] = sc.nextInt();

			for(int i = 1; i != N; ++i) {
				
				temp = sc.nextInt();
				
				dp[i] = temp > temp+dp[i-1] ? temp : temp+dp[i-1]; 				
			}
			
			int ans = dp[0];
			
			for(int i = 0; i != N; ++i) {
	
				if(dp[i] > ans)
					ans = dp[i];		

			}			

			System.out.println(ans);
		}

	}
}
