import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

class Polling {

	public static void main(String args[]) {

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer token;

		Scanner in = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();

		int N = in.nextInt();
		String s;

		while(N-- > 0) {

			s = in.next();
			if(map.containsKey(s))
				map.put(s,map.get(s)+1);
			else {
				map.put(s, 1);
			}
		}

		candidate[] c = new candidate[map.size()];
		int i = 0;

		for(String name: map.keySet())
			c[i++] = new candidate(name, map.get(name));

		Arrays.sort(c, new Comparator<candidate>() {
			@Override
			public int compare(candidate a, candidate b) {
				return b.votes - a.votes;
			}
		});

		String answer = c[0].name;
		i = 1;
		int limit = c.length;
		while(i != limit && c[i].votes == c[i-1].votes)
			answer += " " + c[i++].name;
		// System.out.println(answer + answer.length());
		String[] ans = answer.split(" ");
		Arrays.sort(ans);
		for(i = 0; i != ans.length; ++i)
			System.out.println(ans[i]);
	}
}

class candidate {
	public String name;
	public int votes;
	
	public candidate(String name, int votes) {
		this.name = name;
		this.votes = votes;
	}
}
