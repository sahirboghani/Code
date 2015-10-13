import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;
import java.math.BigInteger;

class Christmas {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int size = 1_000_004;

		long[] ans = new long[size];
		ans[1] = 1;
		ans[2] = 4;
		for(int i = 3; i != size-1; ++i)
			ans[i] = ans[i-1] + ((long)(i+1))*i/2;	

		int n;

		while(true) {

			n = sc.nextInt();
			if(n == 0) 
				break;
			System.out.println(ans[n]);
		}
	}
}
	