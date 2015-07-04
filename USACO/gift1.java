/*
ID: sboghani
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;

class gift1 {
	
	static String[] people;
	static int[] amount;
	static int N;

	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		StringTokenizer n = new StringTokenizer(f.readLine());
		N = Integer.parseInt(n.nextToken());

		people = new String[N];
		amount = new int[N];

		for(int i = 0; i < N; ++i) {
			n = new StringTokenizer(f.readLine());
			people[i] = n.nextToken();
			amount[i] = 0;
		}

		for(int i = 0; i < N; ++i) {
			n = new StringTokenizer(f.readLine());
			String person = n.nextToken();
			n = new StringTokenizer(f.readLine());
			int amt = Integer.parseInt(n.nextToken());
			int ppl = Integer.parseInt(n.nextToken());
			if(amt != 0) {
				amount[getIndex(person)] -= amt/ppl*ppl;
				amt /= ppl;
			}
			for(int j = 0; j < ppl; ++j) {
				n = new StringTokenizer(f.readLine());
				person = n.nextToken();
				amount[getIndex(person)] += amt;
			}
		}

		for(int i = 0; i < N; ++i) {
			out.println(people[i] + " " + amount[i]);
		}
		out.close();
		System.exit(0);
	}

	public static int getIndex(String name) {
		for(int i = 0; i < N; ++i) {
			if(people[i].equals(name))
				return i;
		}
		return -1;
	}
}