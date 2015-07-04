import java.util.Scanner;
import java.io.*;

class google {
	public static void main(String args[]) throws IOException {

		File file = new File("A-large.in");
		Scanner sc = new Scanner(file);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));

		int N = sc.nextInt();

		for(int i = 0; i < N; ++i) {
			int n = sc.nextInt();
			String val = sc.next();
			int[] vals = new int[n+1];
			for(int j = 0; j < n; ++j) {
				vals[j] = val.charAt(j)-48;
			}

			int have = vals[0];
			int need = 0;
			for(int j = 1; j <= n; ++j) {
				if(have < j && vals[j] != 0) {
					need += j-have;
					have += need;
				}
				have += vals[j];
			}
			out.println("Case #" + (i+1) + ": " + need);
		}
		out.close();
	}
}