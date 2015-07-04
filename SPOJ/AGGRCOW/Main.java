import java.util.Arrays;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i = 0; i < t; i++) {
			String st = in.readLine();
			String s1 = "";
			String s2 = "";
			int x = 0;
			int len = st.length();
			while(st.charAt(x) != ' ')
				s1+=st.charAt(x++);
			x++;
			while(x<len)
				s2+=st.charAt(x++);
			int N = Integer.parseInt(s1);
			int C = Integer.parseInt(s2);
			int[] slots = new int[N];

			for(int j = 0; j < N; j++) {
				slots[j] = Integer.parseInt(in.readLine());
			}
			Arrays.sort(slots);
			System.out.printf(binCowSearch(slots, C, N)+"\n");
		}
	}
	public static boolean works(int[] stalls, int numCow, int numStall, int distance) {
		// drop the first cow at the first stall
		int nC = numCow-1;

		// keep track of where you last placed a cow
		int lastCowDrop = 0;

		for(int i = 1; i < stalls.length; i++) {
			if(stalls[i] - stalls[lastCowDrop] >= distance) {
				nC--;
				lastCowDrop = i;
			}
		}

		// did you drop all cows
		return nC <= 0;
	}
	public static int binCowSearch(int[] stalls, int numCow, int numStall) {
		int minD = 1, maxD = stalls[numStall-1] - stalls[0];
		int middle = 0;
		while(minD < maxD) {
			middle = (minD+maxD)/2+1;
			if(works(stalls, numCow, numStall, middle))
				minD = middle;
			else
				maxD = middle-1;
		}
		return minD;
	}
}
