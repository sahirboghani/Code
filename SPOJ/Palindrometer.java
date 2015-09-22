import java.util.Scanner;

class Palindormeter {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
	
		String in;
		
		while(true) {

			in = sc.next();
			if(in.length() == 1)
				break;

			char[] input = in.toCharArray();

			int left = 0;
			int right = in.length()-1;

			int e = 0;
			int ans = 0;

			while(left < right) {
			
				int l = input[left] - 48;
				int r = input[right] - 48;

				if(l != r) {
				
					if(l > r) {
						ans += (l-r)*Math.pow(10,e);
						input[right] += (l-r);
					}
					else {
 					
						ans += (10-r+l)*Math.pow(10,e);	
						input[right] = input[left];
				
						int temp = right-1;
						while(temp != -1 && input[temp] == '9') {
							input[temp] = '0';
							--temp;
						} 
						if(temp != -1)
							++input[temp];

						// System.out.println(input[left] + " " + input[right]);
					}
				}
				else {
					++left;
					--right;
					++e;
				}
			}

			System.out.println(ans);
		}

	}
}
