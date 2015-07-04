import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		boolean first = true;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String newLine = "";
			for(int i = 0; i < line.length(); ++i) {
				char ch = line.charAt(i);
				if(ch == '"') {
					if(first) {
						newLine += "``";
						first = false;
					}
					else {
						newLine += "''";
						first = true;
					}
				}
				else 
					newLine += ch;
			}
			System.out.println(newLine);
		}
		sc.close();
	}
}