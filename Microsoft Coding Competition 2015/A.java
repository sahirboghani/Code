import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

class A {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] in;

		String in2;

		int r1, r2;

		while(sc.hasNext()) {

			in = sc.next().split(",");
			r1 = Integer.parseInt(in[1]);
			r2 = Integer.parseInt(in[2]);

			in2 = in[0];

			boolean valid = true;

			if(r1 < 2 || r1 > 36 || r2 < 2 || r2 > 36)
				valid = false;

			if(valid) {
				for(int i = 0; i != in2.length(); ++i) {
					char temp = in2.charAt(i);
					if(temp < '0')
						valid = false;
					else if(temp > 'z')
						valid = false;
					else if(temp < 'a' && temp > '9')
						valid = false;
					else if(!isValid(temp, r1))
						valid = false;
				}
			}
			if(valid)
				System.out.println(convertVal(getVal(in[0], r1), r2));
			else
				System.out.println("Invalid Input");
		}
	}

	public static int getVal(String a, int b) {
		
		int returnVal = 0;
		int runner = 0;
		int temp;

		for(int i = a.length()-1; i != -1; --i) {
			char ch = a.charAt(i);
			if(ch >= '0' && ch <= '9')
				temp = ch - '0';
			else 
				temp = ch - 'a' + 10;

			returnVal += temp * Math.pow(b, runner++);
		}

		return returnVal;
	}

	public static String convertVal(int val, int b) {
		String ans = "";
			
		int temp;

		char temp2;

		while(val != 0) {
			temp = val%b;
			if(temp < 10) 
				temp2 = (char)(temp + '0');
			else 
				temp2 = (char)('a' + temp - 10);

			ans = temp2 + ans;

			val /= b;
		}

		return ans;
	}

	public static boolean isValid(char ch, int b) {
		if(ch > '0' && ch <= '9')
			return ch < (b+'0');
		return ch < (b - 10 +'a');
	}
}