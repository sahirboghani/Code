import java.util.*;

class SwampHack {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int maxCredits = sc.nextInt();	// number of credits
		int numClasses = sc.nextInt();	// number of classes

		int creditsActual[] = new int[numClasses];
		int priorityActual[] = new int[numClasses];

		for(int i = 0; i < numClasses; i++) {
			creditsActual[i] = sc.nextInt();
			priorityActual[i] = sc.nextInt();
		}

		boolean ranFirst = false;

		for(int x = 0; x < numClasses; x++) {


			int credits[] = creditsActual.clone();	
			int priority[] = priorityActual.clone();

			if(!ranFirst)
				ranFirst = true;
			else 
				credits[x] = priority[x] = 0;

			int accumulatedPriority[] = new int[maxCredits+1];
			Arrays.fill(accumulatedPriority, 0);

			String tookClasses[] = new String[maxCredits+1];
			Arrays.fill(tookClasses, "");		

			for(int i = 0; i < numClasses; i++) {
				for(int j = maxCredits; j >= 0; j--) {
					if(j >= credits[i]) {	// does this class's credits fit in this "sack"
						if( accumulatedPriority[j] < ((accumulatedPriority[j-credits[i]]) + priority[i]) ) {
							accumulatedPriority[j] = accumulatedPriority[j-credits[i]] + priority[i];
							tookClasses[j] = (i+1) + " " + tookClasses[j-credits[i]];
						}
					}
				}
			}
			int c = 0;
			String temp[];
			if(tookClasses[maxCredits] != "") {
				temp = tookClasses[maxCredits].split(" ");
				for(int i = 0; i < temp.length; i++) {
					int t = Integer.parseInt(temp[i]);
					c += credits[t-1];
				}
			}
			System.out.println("Total Priority: " + accumulatedPriority[maxCredits]);
			System.out.println("Took classes: " + tookClasses[maxCredits]);
			System.out.println("Credits: " + c);
		}
	}

		public boolean overlap(String days1, String periods1, String days2, String periods2) {
			String[] days1array = days1.split(" ");
			String[] days2array = days2.split(" ");
			String[] periods1.split(" ");
			String[] periods2.split(" ");

			for(int i = 0; i < days1array.length; i++) {
				if()	
			}
		}
		//public String[][] scheduleMaker(int maxCredits, int numClasses, int[] classCredits, int[] classPriorities) {

		//}

}