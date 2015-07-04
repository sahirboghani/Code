import java.util.Scanner;
import java.io.*;

class omino {
	public static void main(String args[]) throws IOException {

		File file = new File("D-small-attempt2.in");
		Scanner sc = new Scanner(file);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D-small-attempt2.out")));

		int N = sc.nextInt();

		for(int i = 0; i < N; ++i) {
			int X = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();

			if((X > (R*C)) || ((R*C) % X!= 0)) {
				out.println("Case #" + (i+1) + ": RICHARD");
			}
			else {
				if( (X == 4 && (C == 2 || C == 1 || R == 2|| R==1) ) || (X==3 && (R==1 || C==1)))
					out.println("Case #" + (i+1) + ": RICHARD");
				else 
					out.println("Case #" + (i+1) + ": GABRIEL");
			}
		}



		out.close();

	}
}