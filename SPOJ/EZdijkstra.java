import java.util.*;
import java.lang.Integer;
import java.io.*;

class EZdijkstra {
	public static void main(String args[]) throws Exception {

		Parser sc = new Parser(System.in);

		int N = sc.nextInt();

		int[][] costMatrix;
		Vertex[] graph;

		while(N-- != 0) {
			int V = sc.nextInt();
			int K = sc.nextInt();

			graph = new Vertex[V+1];
			costMatrix = new int[V+1][V+1];

			for(int i = 0; i != V+1; ++i)
				graph[i] = new Vertex(i);


			for(int i = 0; i != K; ++i) {

				int from = sc.nextInt();
				int to = sc.nextInt();
				int cost = sc.nextInt();

				graph[from].neighbors.add(to);
				costMatrix[from][to] = cost;
			}

			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

			int start = sc.nextInt();
			int end = sc.nextInt();

			graph[start].dist = 0;

			pq.add(graph[start]);

			while(pq.peek() != null) {

				Vertex curr = pq.poll();

				if(curr.id == end)
					break;

				ArrayList<Integer> neighbors = curr.neighbors;

				for(Integer neighbor: neighbors) {
					if(curr.dist + costMatrix[curr.id][neighbor] < graph[neighbor].dist) {
						pq.remove(graph[neighbor]);
						graph[neighbor].dist = curr.dist + costMatrix[curr.id][neighbor];
						pq.add(graph[neighbor]);
					}
				}

				// pq.remove(curr);
			}

			if(graph[end].dist != Integer.MAX_VALUE)
				System.out.println(graph[end].dist);
			else
				System.out.println("NO");
		}
	}
}

class Vertex implements Comparable<Vertex> {
	public int id;
	public int dist;
	public ArrayList<Integer> neighbors = new ArrayList<Integer>();

	public Vertex(int id) {
		this.id = id;
		dist = Integer.MAX_VALUE;
		neighbors = new ArrayList<Integer>();
	}

	public int compareTo(Vertex v) {
		return this.dist < v.dist ? -1 : 1;
	}
}
















class Parser
{
   final private int BUFFER_SIZE = 1 << 16;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }
 
   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret =  new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }
 
   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }
 
   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}