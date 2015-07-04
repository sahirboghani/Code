/*
ID: sboghani
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;

class ride {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		StringTokenizer st2 = new StringTokenizer(f.readLine());

		String first = st.nextToken();
		String second = st2.nextToken();

		int count1 = 1;
		int count2 = 1;

		for(int i = 0; i < first.length(); ++i) {
			count1 *= (int)(first.charAt(i))-64;
		}
		for(int i = 0; i < second.length(); ++i) {
			count2 *= (int)(second.charAt(i))-64;
		}

		if(count1%47 == count2%47)
			out.println("GO");
		else 
			out.println("STAY");
		out.close();
		System.exit(0);
	}
}