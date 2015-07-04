import java.util.*;

class SwampHack {
	public static void main(String args[]) {
		


		// Class Name, Section Number, priority, credits, MS, MF, TS, TF...

		String test[][] = { {"AFS4905", "03A5", "1","3","4","5","","","4","5","","","4","5"},
							{"AGR5321", "159F", "3","3","","","5","6","","","6","8","",""},
							{"CKJDNKC", "2D45", "2","2","","","7","9","","","7","9","",""},
							{"CKDBKCD", "1042", "3","4","","","2","4","","","2","4","",""}

		};

		test = scheduleMaker(test, 18);
		if(test != null) {
			for(int i = 0; i < test.length; i++) {
				if(test[i]==null)
					break;
				for(int j = 0; j < test[i].length; j++) {
					if(test[i][j]== null)
						break;
					System.out.println(test[i][j]);
				}
				System.out.println("\n");


			}
			System.out.println("\n");
		}

	}
		/*Scanner sc = new Scanner(System.in);
		

	AFS4905,03A5,1,3,4,5,,,4,5,,,4,5]
[AGR5321C,159F,3,3,,,5,6,,,6,8,,]
[ACG6685,2D45,2,2,,,7,9,,,7,9,,]
[ABE5646,1042,4,3,,,2,4,,,2,4,,]



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

	public boolean overlap(String periods1, String periods2) {		// structured "M8 W8 R4 F8 "	<== note space at end
		String periods1array = periods1.split(" ");
		
		for(int i = 0; i < periods1array.length; i++) {
			if(periods2.contains(periods1array[i] + " ") || periods2.contains(" " + periods1array[i]))
				return true;
		}
		return false;
	}
*/
	public static String[][] scheduleMaker(String databaseData[][], int numberOfCredits) {
		// Class Name, Section Number, priority, credits, MS, MF, TS, TF...

		String schedules[][] = new String[100][];
		int curr = 0;

		for(int x = -1; x < databaseData.length; x++) {
			
			int numClassOnSchedule = 0;
			String dbD_changing[][] = new String[databaseData.length][14];
			for(int i = 0; i < dbD_changing.length; i++) {
				for(int j = 0; j < dbD_changing[i].length; j++) {
					dbD_changing[i][j] = databaseData[i][j];
				}
			}

			if(x!=-1) {
				for(int i = 2; i < 14; i++)
					dbD_changing[x][i] = ""+0;	// ignore the xth class given
			}

			boolean schedule[][] = new boolean[14][5];
			for(int m = 0; m < schedule.length; m++) {
				for(int n = 0; n < schedule[m].length; n++) {
					schedule[m][n] = false;
				}
			}
			int accumulatedPriority[] = new int[numberOfCredits+1];
			Arrays.fill(accumulatedPriority, 0);

			String tookClasses[] = new String[numberOfCredits+1];
			Arrays.fill(tookClasses, "");

			for(int i = 0; i < dbD_changing.length; i++) {
				for(int j = numberOfCredits; j >= 0; j--) {

					// does this class's number of credits fit in with the "sack's" current size
					if( j >= Integer.parseInt(dbD_changing[i][3]) ) {
						// can you take this class
						boolean canTakeThisClass = true;
						// first, are any periods already taken i.e. would cause an overlap
						if(canTake(schedule, dbD_changing[i][4],dbD_changing[i][5],dbD_changing[i][6],dbD_changing[i][7],dbD_changing[i][8],
						dbD_changing[i][9],dbD_changing[i][10],dbD_changing[i][11],dbD_changing[i][12],dbD_changing[i][13])) {
							// now check have you already picked up this class in the current schedule

							/*for(int k = 0; k < currentClasses.length; k++) {
								for(int l = 0; l < dbD_changing.length; l++) {
									if(dbD_changing[Integer.parseInt(currentClasses[k])-1][0].equals(dbD_changing[l][0]))
										canTakeThisClass = false;
								}
							}	*/						

							if( canTakeThisClass ) {
								// now add it to your list

								if( accumulatedPriority[j] < ((accumulatedPriority[j-Integer.parseInt(dbD_changing[i][3])]) + Integer.parseInt(dbD_changing[i][2])) ) {
									accumulatedPriority[j] = accumulatedPriority[j-Integer.parseInt(dbD_changing[i][3])] + Integer.parseInt(dbD_changing[i][2]);
									tookClasses[j] = (i+1) + " " + tookClasses[j-Integer.parseInt(dbD_changing[i][3])];
									numClassOnSchedule++;

									
									try {// update current schedule
									for(int f = Integer.parseInt(dbD_changing[i][4])-1; f < Integer.parseInt(dbD_changing[i][5])-1; f++) {
										schedule[0][f] = true;
									}
									for(int f = Integer.parseInt(dbD_changing[i][6])-1; f < Integer.parseInt(dbD_changing[i][7])-1; f++) {
										schedule[1][f] = true;
									}
									for(int f = Integer.parseInt(dbD_changing[i][8])-1; f < Integer.parseInt(dbD_changing[i][9])-1; f++) {
										schedule[2][f] = true;
									}
									for(int f = Integer.parseInt(dbD_changing[i][10])-1; f < Integer.parseInt(dbD_changing[i][11])-1; f++) {
										schedule[3][f] = true;
									}
									for(int f = Integer.parseInt(dbD_changing[i][12])-1; f < Integer.parseInt(dbD_changing[i][13])-1; f++) {
										schedule[4][f] = true;
									}
								}catch(Exception e) {}
								}
							}
						}
					}
				}
			}
			String tt[] = tookClasses[numberOfCredits].split(" ");
			

			//System.out.println(tt.length);
			
			if(tt.length>0)
			schedules[curr] = new String[tt.length];
			else 
				return schedules;
			try {
				for(int i = 0; i < tt.length; i++) {
					String a = databaseData[Integer.parseInt(tt[i])-1][1];
					schedules[curr][i] = a;
				}
			}catch(Exception e) {

			}
			curr++;
			
		}
		return schedules;

	}

	public static boolean canTake(boolean[][] sch, String mS, String mF, String tS, String tF, String wS, String wF, String rS, String rF, String fS, String fF) {
		int ms=0, mf=0, ts=0, tf=0, ws=0, wf=0, rs=0, rf=0, fs=0, ff=0;
		if( mS != "") 
			ms = Integer.parseInt(mS);
		if( mF != "") 
			mf = Integer.parseInt(mF);
		if( tS != "") 
			ts = Integer.parseInt(tS);
		if( tF != "") 
			tf = Integer.parseInt(tF);
		if( wS != "") 
			ws = Integer.parseInt(wS);
		if( wF != "") 
			wf = Integer.parseInt(wF);
		if( rS != "") 
			rs = Integer.parseInt(tS);
		if( rF != "") 
			rf = Integer.parseInt(tF);
		if( fS != "") 
			fs = Integer.parseInt(fS);
		if( fF != "") 
			ff = Integer.parseInt(fF);
try{
		for(int i = ms-1; i<mf-1; ++i) {
			if(sch[0][i]) 
				return false;
		}
		for(int i = ts-1; i<tf-1; ++i) {
			if(sch[0][i]) 
				return false;
		}
		for(int i = ws-1; i<wf-1; ++i) {
			if(sch[0][i]) 
				return false;
		}
		for(int i = rs-1; i<rf-1; ++i) {
			if(sch[0][i]) 
				return false;
		}
		for(int i = fs-1; i<ff-1; ++i) {
			if(sch[0][i]) 
				return false;
		} 
	} catch(Exception e) {}
		return true; 
	}

}