import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.IOException;

class ABCPath {

	static int[][] graph;
	static boolean[][] visited;
	static int H, W, MAX;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token;

		String temp;
		int run = 0;

		while(true) {
			token = new StringTokenizer(in.readLine());
			H = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());

			if(H == 0 || W == 0)
				break;

			graph = new int[H][W];
			visited = new boolean[H][W];
			MAX = 0;

			for(int i = 0; i < H; ++i) {
				token = new StringTokenizer(in.readLine());
				temp = token.nextToken();
				for(int j = 0; j < W; ++j) {
					graph[i][j] = temp.charAt(j);
					visited[i][j] = false;
				}
			}
			for(int i = 0; i < H; ++i)
				for(int j = 0; j < W; ++j)
					if(graph[i][j] == 'A') {
						solve(i, j, 1);
						visited[i][j] = true;
					}
			out.write("Case " + (++run) + ": " + MAX + "\n");
		}

		out.flush();
		in.close();
		out.close();
	}

	public static void solve(int i, int j, int max) {
		for(int a = -1; a != 2; ++a) {
			for(int b = -1; b != 2; ++b) {
				if(a==0 && b==0)
					continue;
				if(isValid(i+a, j+b) && !visited[i+a][j+b] && graph[i+a][j+b] == graph[i][j]+1) {
					visited[i+a][j+b] = true;
					solve(i+a, j+b, max+1);
				}
			}
		}
		MAX = Math.max(MAX, max);
		/*if((j != W-1) && (graph[i][j+1] == graph[i][j] + 1))
			solve(i, j+1, max+1);
		if((j != 0) && (graph[i][j-1] == graph[i][j] + 1))
			solve(i, j-1, max+1);
		if((i != 0) && (graph[i-1][j] == graph[i][j] + 1))
			solve(i-1, j, max+1);
		if((i != H-1) && (graph[i+1][j] == graph[i][j] + 1))
			solve(i+1, j, max+1);
		if((i != 0 && j != W-1) && (graph[i-1][j+1] == graph[i][j] + 1))
			solve(i-1, j+1, max+1);
		if((i != 0 && j != 0) && (graph[i-1][j-1] == graph[i][j] + 1))
			solve(i-1, j-1, max+1);
		if((i != H-1 && j != W-1) && (graph[i+1][j+1] == graph[i][j] + 1))
			solve(i+1, j+1, max+1);
		if((i != H-1 && j != 0) && (graph[i+1][j-1] == graph[i][j] + 1))
			solve(i+1, j-1, max+1);
		MAX = Math.max(max, MAX);*/
	}

	public static boolean isValid(int i, int j) {
		if(i < 0 || i >= H || j < 0 || j >= W)
			return false;
		return true;
	}
/*
	public static boolean adjacentRight(int i, int j) {
		if(j == W-1)
			return false;
		return graph[i][j+1] == graph[i][j] + 1;
	}
	public static boolean adjacentLeft(int i, int j) {
		if(j == 0)
			return false;
		return graph[i][j-1] == graph[i][j] + 1;
	}
	public static boolean adjacentTop(int i, int j) {
		if(i == 0)
			return false;
		return graph[i-1][j] == graph[i][j] + 1;
	}
	public static boolean adjacentBottom(int i, int j) {
		if(i == H-1)
			return false;
		return graph[i+1][j] == graph[i][j] + 1;
	}
	public static boolean adjacentTopRight(int i, int j) {
		if(i == 0 || j == W-1)
			return false;
		return graph[i-1][j+1] == graph[i][j] + 1;
	}
	public static boolean adjacentTopLeft(int i, int j) {
		if(i == 0 || j == 0)
			return false;
		return graph[i-1][j-1] == graph[i][j] + 1;
	}
	public static boolean adjacentBottomRight(int i, int j) {
		if(i == H-1 || j == W-1)
			return false;
		return graph[i+1][j+1] == graph[i][j] + 1;
	}
	public static boolean adjacentBottomLeft(int i, int j) {
		if(i == H-1 || j == 0)
			return false;
		return graph[i+1][j-1] == graph[i][j] + 1;
	}
*/
}