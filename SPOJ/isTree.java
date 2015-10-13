import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class isTree {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		Stack<Integer> stack = new Stack<Integer>();

		boolean[] visited;

		int N, E;

		N = scan(sc);
		E = scan(sc);

		visited = new boolean[N+1];

		int i;

		for(i = 0; i != N+1; ++i) {
			graph.add(new ArrayList<Integer>());
			visited[i] = false;
		}
		int a, b;

		for(i = 0; i != E; ++i) {
			a = scan(sc);
			b = scan(sc);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		if(E != N-1)
			System.out.println("NO");
		else if(N < 2)
			System.out.println("YES");
		else {
			stack.push(1);

			int temp;
			ArrayList<Integer> l;

			while(!stack.empty()) {

				temp = stack.pop();
				
				visited[temp] = true;
				l = graph.get(temp);

				for(int j: l)
					if(!visited[j])
						stack.push(j);
			}

			boolean answer = true;

			for(i = 1; i != N+1; ++i)
				if(!visited[i])
					answer = false;
		
			if(answer)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}

	}

	public static int scan(Scanner sc) throws Exception{
		return sc.nextInt();
	}
}