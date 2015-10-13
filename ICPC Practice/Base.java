import java.util.*;

class Base {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String a, b, c, d, e;

		while(N-- > 0) {

			a = sc.next();
			b = sc.next();
			c = sc.next();
			d = sc.next();
			e = sc.next();

			String res = "";

			int oneCountA = 0;
			int oneCountB = 0;
			int oneCountC = 0;

			boolean oneWorks = true;


			for(int i = 0; i != a.length(); ++i)
				if(a.charAt(i) == '1') 
					++oneCountA;
				else 
					oneWorks = false;
			for(int i = 0; i != c.length(); ++i)
				if(c.charAt(i) == '1')
					++oneCountB;
				else 
					oneWorks = false;

			for(int i = 0; i != e.length(); ++i)
				if(e.charAt(i) == '1')
					++oneCountC;
				else 
					oneWorks = false;

			if(oneWorks) {
			
				switch(b) {
					case "+":
								if(oneCountA + oneCountB == oneCountC) 
									res += '1';
								break;
					case "-":
								if(oneCountA - oneCountB == oneCountC) 
								res += '1';
								break;

					case "*":	
								if(oneCountA * oneCountB == oneCountC) 
								res += '1';
								break;

					case "/":

								if(oneCountC * oneCountB == oneCountA) 
								res += '1';
								break;
				}
			}
			for(int i = 2; i != 37; ++i) {
						
				char base;


				if(i < 10)
					base = (char)(i + '0');
				else if(i == 36)
					base = '0';
				else
					base = (char)(i - 10 + 'a');
				try {
					int val1 = Integer.valueOf(a, i);
					int val2 = Integer.valueOf(c, i);
					int val3 = Integer.valueOf(e, i);

					switch(b) {
						case "+":
									if(val1 + val2 == val3) 
										res += base;
									break;
						case "-":
									if(val1 - val2 == val3) 
									res += base;
									break;

						case "*":	if(val1 * val2 == val3) 
									res += base;
									break;

						case "/":

									if(val3 * val2 == val1) 
									res += base;
									break;
					}
				}
				catch(Exception eeeeee) {
				}
			}

			if(res.equals(""))
				System.out.println("invalid");
			else
				System.out.println(res);
		}


	}
}