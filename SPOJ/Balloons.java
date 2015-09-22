import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Balloons {
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);

		int N, A, B;

		while(true) {

			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			if(N == 0 && A == 0 && B == 0)
				break;

			long answer = 0;
		
			Team[] acm = new Team[N--];

			while(N != -1) {

				acm[N] = new Team(sc.nextInt(), sc.nextInt(), sc.nextInt());
				
				--N;
			}

			Arrays.sort(acm, new Comparator<Team>() {

				@Override
				public int compare(Team a, Team b) {
					return b.diff - a.diff;

				}	

			});			
		
			//for(Team t: acm)
			//	System.out.println(t.diff);

			// if you're positive, give you as much of B balloons as possible

			int i = 0;
				
			while(B != 0 && i != acm.length && acm[i].diff >= 0) {
	
				if(B >= acm[i].balloons) {
					acm[i].done = true;
					B -= acm[i].balloons;
					answer += acm[i].bDistance * acm[i].balloons;
					++i;				
				}
				else {
					answer += acm[i].bDistance * B;
					acm[i].balloons -= B;					
					B = 0;
				}
			}

			// once negative, go upwards, giving you as much of A balloons as possible
			
			i = acm.length-1;
	
			while(A != 0 && i != -1 && !acm[i].done) {
										
				if(A >= acm[i].balloons) {

					acm[i].done = true;
					A -= acm[i].balloons;
					answer += acm[i].aDistance * acm[i].balloons;
					--i;
				}

				else {
					answer += acm[i].aDistance * A;
					acm[i].balloons -= A;
					A = 0;
				}								

			}

			if(B != 0) {

				while(i != -1 && !acm[i].done) {

					acm[i].done = true;
					answer += acm[i].bDistance * acm[i].balloons;
					--i;

				}

			}

			System.out.println(answer);
		}
	}
}

class Team {

	public int balloons;
	public int aDistance;
	public int bDistance;
	public int diff;
	public boolean done;

	public Team(int n, int a, int b) {
		balloons = n;
		aDistance = a;
		bDistance = b;
		diff = a - b;	
		done = false;
	}
	
}


