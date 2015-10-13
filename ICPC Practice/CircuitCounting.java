// Credz to Nick


import java.util.*;

class CircuitCounting {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int minX = 0, maxX = 0, minY = 0, maxY = 0;

		int[][] vectors = new int[N][2];

		int i = 0, n = N;

		int a, b;

		while(n-- > 0) {

			a = sc.nextInt();
			b = sc.nextInt();

			vectors[i][0] = a;
			vectors[i++][1] = b;

			if(a < 0)
				minX += a;
			else
				maxX += a;

			if(b < 0)
				minY += b;
			else 
				maxY += b;

		}

		long[][][] arr = new long[N][maxX-minX + 1][maxY-minY + 1];

		for(i = minX; i <= maxX; ++i) {
			for (int j = minY; j <= maxY; j++) {
				if (vectors[0][0] == i && vectors[0][1] == j) {
					arr[0][i-minX][j-minY] = 1;
				} else {
					arr[0][i-minX][j-minY] = 0;
				}
			}
		}

		for (i = 1; i < N; i++) {
			for (int j = minX; j <= maxX; j++) {
				for (int k = minY; k <= maxY; k++) {
					arr[i][j-minX][k-minY] = arr[i-1][j-minX][k-minY];
					if (vectors[i][0] == j && vectors[i][1] == k)
						arr[i][j-minX][k-minY] += 1;
					try {
						arr[i][j-minX][k-minY] += arr[i-1][j-vectors[i][0]-minX][k-vectors[i][1]-minY];
					} catch (Exception e) {

					}
				}
			}
		}

		System.out.println(arr[N-1][0 - minX][0 - minY]);
	}
}