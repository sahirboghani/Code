import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.IOException;

class ABSYS {

	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(in.readLine());

		String[] line = new String[3];
		int N = Integer.parseInt(token.nextToken());
		int A, B, C;

		while(N-- != 0) {
			in.readLine();
			token = new StringTokenizer(in.readLine());
			line[0] = token.nextToken();
			token.nextToken();
			line[1] = token.nextToken();
			token.nextToken();
			line[2] = token.nextToken();

			if(line[0].contains("m")) {
				B = Integer.parseInt(line[1]);
				C = Integer.parseInt(line[2]);
				A = C-B;
			}
			else if(line[1].contains("m")) {
				A = Integer.parseInt(line[0]);
				C = Integer.parseInt(line[2]);
				B = C-A;	
			}
			else {
				A = Integer.parseInt(line[0]);
				B = Integer.parseInt(line[1]);
				C = A+B;
			}

			builder.append(A + " + " + B + " = " + C + "\n");
		}

		out.write(builder.toString());
		out.flush();
		in.close();
		out.close();
	}
}