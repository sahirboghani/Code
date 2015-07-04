import java.util.Scanner;
import java.util.Arrays;

class Stamps {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int borrow, friends, i, scenario = 1;
		int[] stamps;

		while(N-- > 0) {
			borrow = sc.nextInt();
			friends = sc.nextInt();

			stamps = new int[friends];

			for(i = 0; i < friends; ++i)
				stamps[i] = sc.nextInt();


			System.out.println("Scenario #" + (scenario++) + ": " );

			Arrays.sort(stamps);

			for(i = friends-1; i != -1; --i) {
				borrow -= stamps[i];
				if(borrow <= 0) {
					System.out.println(friends-i);
					break;
				}
			}

			if(borrow > 0)
				System.out.println("impossible");
			if(N != 0)
				System.out.println();

		}
	}
}