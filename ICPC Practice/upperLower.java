import java.util.*;
import java.io.*;
import java.lang.*;

class upperLower {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		char[] in = sc.nextLine().toCharArray();

		int i = 0;

		int end = in.length;

		char curr;

		boolean isEmp = true, isUpper = true, isCase = false;

		String ans = "";

		Stack<Integer> s = new Stack<Integer>();

		while(i < end) {

			curr = in[i];

			if(curr != '<') {
				if(isCase) {
					if(isUpper) {
						ans += u(curr);
					}
					else 
						ans += l(curr);
				}
				else
					ans += curr;
				++i;
			}

			else {
				if(in[i+1] == '/') {
					isCase = false;
					if(!s.empty()) {
						int temp = s.pop();
						isUpper = temp == 1;
						isCase = true;
					}
					if(in[i+2] == 'U')
						i += 5;
					else
						i += 7;
				}
				else {
					if(!isCase) {
						isCase = true;
					}
					else {
						if(isUpper) {
							s.push(1);
						}
						else
							s.push(0);
					}
					isUpper = in[i+1] == 'U'; 
					if(isUpper)
						i += 4;
					else
						i += 6;
				} 
			}

		}

		System.out.println(ans);

	}

	public static char u(char c) {
		if(c >= 'a')
			return (char)('A' + c - 'a');
		return c;
	}

	public static char l(char c) {
		if(c <= 'Z')
			return (char)('a' + c - 'A');
		return c;
	}
}
