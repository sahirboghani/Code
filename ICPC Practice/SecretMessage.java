import java.util.*;

class SecretMessage {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();


		String a;

		while(N-- > 0) {

			a = sc.next();

			int n = a.length();

			int limit = n;

			int runner = 0;

			n = (int)(Math.ceil(Math.sqrt(n)));

			char[][] ch = new char[n][n];

			for(int i = 0; i != n; ++i) {
				for(int j = 0; j != n; ++j) {
					if(runner == limit)
						ch[i][j] = '*';
					else
						ch[i][j] = a.charAt(runner++);
				}
			}

			for(int i = 0; i != n; ++i) {
				for(int j = n-1; j >= 0; --j) {
					char temp = ch[j][i];
					if(temp != '*')
						System.out.print(temp);
				}
			}

			System.out.println();
		}



	}
}