/*
ID: sboghani
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

class beads {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

		StringTokenizer s = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(s.nextToken());
		char[] beads = new char[N];
		s = new StringTokenizer(f.readLine());
		String beadstring = s.nextToken();
		for(int i = 0; i < beadstring.length(); ++i) {
			beads[i] = beadstring.charAt(i);
		}

		int max = helper(beads, N-1, 0, N);
		
		for(int i = 1; i < N; ++i) {
			int left = i-1;
			int right = i;
			int temp = helper(beads, left, right, N);
			max = temp > max ? temp : max;
		}

		out.println(max);
		out.close();
		System.exit(0);
	}

	public static int helper(char[] beads, int left, int right, int N) {
		boolean moreRight = true, moreLeft = true;
		char leftChar = beads[left];
		
		int temp = left;
		while(beads[temp] == 'w') { 
			temp = temp == 0 ? N-1 : temp-1;
			if(temp == right)
				return N;	
		}
		leftChar = beads[temp];

		char rightChar = beads[right];
		temp = right;
		while(beads[temp] == 'w') {
			temp = temp == N-1 ? 0 : temp+1;
		}
		rightChar = beads[temp];

		int count = 2;
		while(moreRight || moreLeft) {
			if(moreRight) {
				right = right == N-1 ? 0 : right+1;
				if(right == left) {
					if(leftChar == rightChar && beads[left] != leftChar && beads[left] != 'w')
						return N-1;
					else 
						return N;
				}
				if(rightChar == beads[right] || beads[right] == 'w')
					++count;
				else 
					moreRight = false;
			}
			if(moreLeft) {
				left = left == 0 ? N-1 : left-1;
				if(right == left) {
					if(leftChar == rightChar && beads[left] != leftChar && beads[left] != 'w')
						return N-1;
					else 
						return N; 
				}
				if(leftChar == beads[left] || beads[left] == 'w')
					++count;
				else 
					moreLeft = false;
			}
		}
		return count;
	}
}