import java.util.*;
import java.io.*;
import java.lang.*;

class decimalCut {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);


		String a = sc.next();
		int b = sc.nextInt();


		while(b > 0) {
			boolean removed = false;
			for(int i = 1; i < a.length(); ++i) {
				if(a.charAt(i) > a.charAt(i-1)) {
					a = a.substring(0, i-1) + a.substring(i);
					removed = true;
					--b;
					break;
				}
			}
			if(!removed)
				break;
		}

		System.out.println(a.substring(0, a.length() - b));
	}
}
