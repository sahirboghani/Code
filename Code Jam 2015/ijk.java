import java.util.Scanner;
import java.io.*;

class ijk {

	public static void main(String args[]) throws IOException {

		File file = new File("C-small-attempt1.in");

		Scanner sc = new Scanner(file);

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("o.out")));

		int N = sc.nextInt();
		
		for(int i = 0; i < N; ++i) {
			int L = sc.nextInt();
			int X = sc.nextInt();
			System.out.println(L + " " + X);
			String temp = sc.next();
			String test = "" + temp;
			System.out.println(test.length());
			if(L == 1 || (temp.length()*X < 3)) 
				out.println("Case #" + (i+1) + ": NO");
			else {
				while(--X > 0) {
					test += temp;
				}
				boolean done = false;
				int len = test.length();

				outerloop:
				for(int x = 0; x < len-1; ++x) {
					System.out.println(x);
					for(int y = x; y < len; ++y) {
						if( h(test.substring(0,x)).equals("i") && h(test.substring(x,y)).equals("j") && h(test.substring(y, len)).equals("k") ) {
								done = true;
								out.println("Case #" + (i+1) + ": YES");				
								break outerloop;
						}
					}
				}
				if(!done) 
					out.println("Case #" + (i+1) + ": NO");	
			}
		}

		out.close();
	}


	public static String h(String s) {
		if(s == null || s.length() <= 1) 
			return s;
		String[] temp = new String[s.length()];
		for(int i = 0; i < temp.length; ++i) {
			temp[i] = "" + s.charAt(i);
		}
		return help(temp);
	}

	public static String help(String[] s) {
		String res = help2(s[0], s[1]);
		for(int i = 2; i < s.length; ++i) {
			res = help2(res, s[i]);
		}
		return res; 
	}
	public static String help2(String s1, String s2) {
		if(s1.length() == 2) {
			if(s2.length() == 2) {
				return help2(s1.substring(1,2), s2.substring(1,2));
			}
			else {
				String t = help2(s1.substring(1,2), s2);
				return t.charAt(0) == '-' ? t.substring(1,2) : ("-" + t);
			}
		}
		else if(s2.length() == 2) {
			String t = help2(s1, s2.substring(1,2));
			return t.charAt(0) == '-' ? t.substring(1,2) : ("-" + t); 
		}
		else {
			if(s1.equals("1")) {
				if(s2.equals("1"))
					return "1";
				else if(s2.equals("i"))
					return "i";
				else if(s2.equals("j"))
					return "j";
				else 
					return "k";
			}
			else if(s1.equals("i")) {
				if(s2.equals("1"))
					return "i";
				else if(s2.equals("i"))
					return "-1";
				else if(s2.equals("j"))
					return "k";
				else 
					return "-j";	
			}
			else if(s1.equals("j")) {
				if(s2.equals("1"))
					return "j";
				else if(s2.equals("i"))
					return "-k";
				else if(s2.equals("j"))
					return "-1";
				else 
					return "i";
			}
			else {	// s1 = "k"
				if(s2.equals("1"))
					return "k";
				else if(s2.equals("i"))
					return "j";
				else if(s2.equals("j"))
					return "-i";
				else 
					return "-1";
			}
		}
	}
}