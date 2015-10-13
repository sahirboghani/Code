import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

class B {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<String> a = grams("aaa");
		
		String in;

		while(sc.hasNext()) {

			in = sc.next();
		
			solve(in);
		}
	}

	public static void solve(String in) {

		int removed = 0;
		int numPals = 0;

		int len = in.length();

		boolean found = false;

		if(len == 1) {
			System.out.println("0,1");
			return;
		}
		else {
			ArrayList<String> gs = grams(in);
			for(String s: gs) {
				if(isPalin(s)) {
					found = true;
					++numPals;
				}
			}
		}

		if(found) {
			System.out.println(removed + "," + numPals);
		}

	}


	public static ArrayList<String> grams(String a) {
		ArrayList<String> c = new ArrayList<String>();
		grams("", a, c);
		return c;
	}

	public static void grams(String a, String b, ArrayList<String> c) {
		if(b.length() < 1) {
			if(!c.contains(a))
			c.add(a);
		}
		else {
			for(int i = 0; i != b.length(); ++i) {
				grams(a + b.charAt(i), b.substring(0,i) + b.substring(i+1, b.length()) ,c);
			}
		}
	}

	public static boolean isPalin(String a) {
		int i = 0;
		int j = a.length()-1;

		while(i < j) {

			if(a.charAt(i) != a.charAt(j))
				return false;

			++i;
			--j;
		}

		return true;
	}
}