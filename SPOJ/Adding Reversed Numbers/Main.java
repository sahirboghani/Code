import java.io.*;

class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		while(N-- > 0) {
			String st = in.readLine();
			String s1 = "";
			String s2 = "";
			int x = 0;
			int len = st.length();
			while(st.charAt(x) != ' ')
				s1 += st.charAt(x++);
			x++;
			while(x<len)
				s2 += st.charAt(x++);

			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(s2);

			algo(n1, n2);
			System.out.printf("\n");
		}
	}

	public static void algo(int n1, int n2) {
		String s1 = "" + n1;
		String s2 = "" + n2;

		int i1 = s1.length()-1;
		int i2 = s2.length()-1;

		while(s1.charAt(i1) == '0')
			i1--;
		while(s2.charAt(i2) == '0')
			i2--;

		String s11 = "";
		String s22 = "";

		for(int i = i1; i >= 0; i--)
				s11 += s1.charAt(i);
		for(int i = i2; i >= 0; i--)
				s22 += s2.charAt(i);

		String s3 = "" + (Integer.parseInt(s11) + Integer.parseInt(s22));
		int i3 = s3.length()-1;

		while(s3.charAt(i3) == '0')
			i3--;

		for(int i = i3; i >= 0; i--)
			System.out.printf("%c", s3.charAt(i));
	}
}
