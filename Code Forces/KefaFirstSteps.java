import java.util.Scanner;

public class KefaFirstSteps {
	public static void main(String args[]) {


		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int ans = 1;

		int curr = 1;

		long runner = sc.nextLong();

		long temp = runner;

		--N;
		while(N-- != 0) {
			runner = sc.nextLong();
			if(runner >= temp)
				++curr;
			else {
				ans = Math.max(ans, curr);
				curr = 1;
			}
			temp = runner;
		}
		ans = Math.max(ans, curr);
		System.out.println(ans);
	}
}