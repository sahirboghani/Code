import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		while(N != -1) {

			int[] a = new int[N];
			int sum = 0;
			for(int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
				sum += a[i];
			}

			if(sum % N != 0) {
				System.out.println("-1");
			}
			else {
				int numMoves = 0;
				int magicNumber = sum/N;
				Arrays.sort(a);

				if(a[0] == a[N-1]) 
					System.out.println(0);
				else {
					int r = N-1;
					while(a[r]>magicNumber)
						r--;
					while(r>=0) {
						numMoves += magicNumber-a[r--];
					}
					System.out.println(numMoves);
				}
			}
			N = sc.nextInt();
		}
	}
}