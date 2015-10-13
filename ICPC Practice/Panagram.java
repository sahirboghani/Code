import java.util.*;

class Panagram {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String a;
		sc.nextLine();

		while(N-- > 0) {

			a = sc.nextLine();

			a = a.toLowerCase();

			boolean[] arr = new boolean[26];

			Arrays.fill(arr, false);

			for(int i = 0; i != a.length(); ++i) {
				char ch = a.charAt(i);
				int b = ch - 'a';
				if(b > -1 && b < 27)
					arr[b] = true;
			}

			boolean good = true;
			String ans = "";

			for(int i = 0; i != 26; ++i) {
				if(!arr[i])	{
					good = false;
					ans += (char)(i + 'a');
				}
			}

			if(good) {
				System.out.println("pangram");
			}
			else {
				System.out.println("missing " + ans);
			}

		}


	}
}