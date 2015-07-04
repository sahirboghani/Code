/*
ID: sboghani
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

class friday {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		StringTokenizer n = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(n.nextToken());

		int[] count = new int[7];
		int[] reg = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] leap = {31,29,31,30,31,30,31,31,30,31,30,31};

		int day = 1;

		for(int i = 0; i < N; ++i) {
			if(isLeap(i+1900)) { // leap year
				for(int j = 0; j < 12; ++j) {
					day+= 12;
					++count[day%7];
					day+= leap[j]-12;
				}
			}
			else {
				for(int j = 0; j < 12; ++j) {
					day+= 12;
					++count[day%7];
					day+= reg[j]-12;
				}
			}
		}

		out.print(count[6] + " ");
		for(int i = 0; i < 5; ++i)
			out.print(count[i] + " ");
		out.println(count[5]);
		out.close();
		System.exit(0);
	}

	public static boolean isLeap(int year) {
		if(year%100==0) {
			if(year%400 == 0)
				return true;
			return false;
		}
		if(year%4==0)
			return true;
		return false;
	}
}