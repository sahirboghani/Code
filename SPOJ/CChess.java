import java.util.*;
import java.io.*;
import java.lang.Integer;

class CChess {

   static int[][] board = new int[8][8];

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      int xa, ya, xb, yb;

      while(sc.hasNext()) {

         xa = sc.nextInt();
         ya = sc.nextInt();
         xb = sc.nextInt();
         yb = sc.nextInt();

         for(int[] a: board)
            Arrays.fill(a, Integer.MAX_VALUE);

         PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

         Vertex start = new Vertex(xa, ya);
         Vertex end = new Vertex(xb, yb);

         board[xa][ya] = 0;

         pq.add(start);

         boolean found = false;

         while(pq.peek() != null && !found) {
            Vertex curr = pq.poll();

            if(curr.eq(end)) {
               System.out.println(board[xb][yb]);
               found = true;
               break;
            }

            ArrayList<Vertex> neighbors = curr.getNeighbors();

            int currDist = board[curr.c.x][curr.c.y];

            for(Vertex n: neighbors) {
               int dist = curr.c.x * n.c.x + curr.c.y * n.c.y;
               if(currDist + dist < board[n.c.x][n.c.y]) {
                  board[n.c.x][n.c.y] = dist + currDist;
                  n.dist = dist + currDist;
                  pq.add(n);
               }
            }                     
         }
      
         if(!found)
            System.out.println("-1");
      }
   }
}

class Vertex implements Comparable<Vertex> {

   public Coordinate c;
   public int dist;
   
   public Vertex(int x, int y) {
      c = new Coordinate(x, y);
      dist = Integer.MAX_VALUE;
   }

   @Override
   public int compareTo(Vertex v) {
      return this.dist < v.dist ? -1 : 1;
   }

   public boolean eq(Vertex v) {
      return c.x == v.c.x && c.y == v.c.y;
   }

   public ArrayList<Vertex> getNeighbors() {
      ArrayList<Vertex> n = new ArrayList<Vertex>();
      int x = c.x;
      int y = c.y;

      if(x-1 >= 0) {
         if(y-2 >= 0)
            n.add(new Vertex(x-1, y-2));
         if(y+2 < 8)
            n.add(new Vertex(x-1, y+2));
      }
      if(x+1 < 8) {
         if(y-2 >= 0)
            n.add(new Vertex(x+1, y-2));
         if(y+2 < 8)
            n.add(new Vertex(x+1, y+2));
      }
      if(x-2 >= 0) {
         if(y-1 >= 0)
            n.add(new Vertex(x-2, y-1));
         if(y+1 < 8)
            n.add(new Vertex(x-2, y+1));
      }
      if(x+2 < 8) {
         if(y-1 >= 0)
            n.add(new Vertex(x+2, y-1));
         if(y+1 < 8)
            n.add(new Vertex(x+2, y+1));
      }

      return n;
   }
}

class Coordinate {
   public int x;
   public int y;

   public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
   }
}