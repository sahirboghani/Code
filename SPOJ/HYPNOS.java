import java.util.*;
import java.io.*;

class HYPNOS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(in.readLine());
		StringBuilder builder = new StringBuilder();

		long N = Long.parseLong(token.nextToken());	
		long temp;

		List<Long> list = new ArrayList<Long>();

		int i = 0;
		while(true) {
			if(N == 1) {
				builder.append(i).append("\n");
				break;
			}
			if(list.contains(N)) {
				builder.append("-1\n");
				break;
			}
			list.add(N);
			temp = 0;
			while(N > 0) {
				temp += (N%10) * (N%10);
				N /= 10; 
			}
			N = temp;
			++i;
		}
		out.write(builder.toString());
		out.flush();
		out.close();
		in.close();
	}
}