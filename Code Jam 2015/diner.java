import java.util.Scanner;
import java.io.*;

class diner {
	public static void main(String args[]) throws IOException {


		File file = new File("B-small-attempt1.in");
		Scanner sc = new Scanner(file);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt1.out")));

		int N = sc.nextInt();

		for(int i = 0; i < N; ++i) {

			int n = sc.nextInt();
			int[] p = new int[n];
			
			int sMs = 0;
			boolean two = false;
			int max = 0;

			for(int j = 0; j < n; ++j) {
				p[j] = sc.nextInt();
				if(p[j] > max)
					max = p[j];
				if(p[j] > 2) {
					sMs += (p[j]-1)/2;
					two = true;
				}
				else if(p[j] %2 == 0) {
					two = true;
				}
			}
			int r = two ? 2+sMs : 1+sMs;
			r = r > max ? max : r;
			out.println("Case #" + (i+1) + ": " + r);

		}
		out.close();
	}
}