import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			String line = sc.nextLine();
			int count = 0;
			boolean check = false;
			for(int i = 0; i < line.length(); ++i) {
				if(isLetter(line.charAt(i))) {
					check = true;
					if(i == line.length()-1) ++count;
				}
				else {
					if(check) {
						++count;
						check = false;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static boolean isLetter(char index) {
		if(index >= 65 && index <= 90 || index >= 97 && index <= 122)
				return true;
		return false;
	}
}