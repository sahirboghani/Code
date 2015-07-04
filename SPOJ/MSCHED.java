import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;


class MSCHED {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(token.nextToken());
		Session[] sessions = new Session[N];
		int i = 0;
		int[] times = new int[10_001];
		Arrays.fill(times, 0);

		while(N-- > 0) {
			token = new StringTokenizer(in.readLine());
			sessions[N] = new Session(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		
/*		System.out.println(sessions.length);

		for(int j = 0; j < sessions.length; ++j) {
			System.out.println("Iteration: " + j);
			System.out.println(sessions[j].gallons + " " + sessions[j].timeLimit);
		}	
*/
		Arrays.sort(sessions, new Comparator<Session>() {
			@Override 
			public int compare(Session s1, Session s2) {
				return s1.gallons - s2.gallons;
			}
		});

		int sum = 0;

		for(i = sessions.length-1 ; i != -1; --i) {
			int tL = sessions[i].timeLimit;
			while(tL > 0) {
				if(times[tL] == 0) {
					++times[tL];
					sum += sessions[i].gallons;
					break;
				}
				--tL;
			}
		}

		out.write(String.valueOf(sum));

		out.flush();
		in.close();
		out.close();		
	}

	static class Session {
		public int gallons;
		public int timeLimit;

		public Session(int g, int tL) {
			this.gallons = g;
			this.timeLimit = tL;
		}
	}
}