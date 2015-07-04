import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
		String s = in.readLine();
		System.out.printf("Ready\n");
		while(!(s.charAt(0) == ' ' && s.charAt(1) == ' ')) {
			if(s.charAt(0) == 'p') {
				if(s.charAt(1) == 'q') 
					System.out.printf("Mirrored pair\n");
			}
			else if(s.charAt(0) == 'q') {
				if(s.charAt(1) == 'p') 
					System.out.printf("Mirrored pair\n");
			}
			else if(s.charAt(0) == 'd') {
				if(s.charAt(1) == 'b') 
					System.out.printf("Mirrored pair\n");
			}
			else if(s.charAt(0) == 'b') { 
				if(s.charAt(1) == 'd') 
					System.out.printf("Mirrored pair\n");
			}
			else 
				System.out.printf("Ordinary pair\n");
			s = in.readLine();
		}
	}
}