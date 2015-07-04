import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		if(cases == 1)
			algo(sc.nextInt(), sc.nextInt());
		else {
			for(int i = 0; i < cases; i++) {
				algo(sc.nextInt(), sc.nextInt());
				if(i != cases-1)
					System.out.println();
			}
		}
	}

	public static void algo(int a, int b) {
		if(a%2 == 0 && a != 2) {
			for(int i = a+1; i <= b; i++) {
				if(isPrime(i))
					System.out.println(i);
			}		
		}
		else {
			for(int i = a; i <= b; i++) {
				if(isPrime(i))
					System.out.println(i);
			}
		}
	}
	public static boolean isPrime(int a) {
		if(a == 2 || a == 3)
			return true;
		if(a % 2 == 0 || a == 1)
			return false;
		for(int i = 3; i*i <= a; i+=2) {
			if(a%i == 0)
				return false;
		} 
		return true;
	}
}