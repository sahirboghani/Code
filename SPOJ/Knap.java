import java.util.*;
import java.lang.Integer;
import java.io.*;

class Knap {

   static int[] weight;
   static int[] value;
   static int[][] memo;
   static int N;
   
   public static void main(String[] args) throws Exception {

      Parser sc = new Parser(System.in);

      int C = sc.nextInt(); 
      N = sc.nextInt();

      weight = new int[N];
      value = new int[N];
      memo = new int[N][C+1];

      for(int[] a: memo)
         Arrays.fill(a, -1);

      for(int i = 0; i < N; ++i) {
         weight[i] = sc.nextInt();
         value[i] = sc.nextInt();
      }

      System.out.println(solve(0, C));
   }

   public static int solve(int index, int remainingWeight) {
      if(remainingWeight == 0)
         return 0;
      if(index == N)
         return 0;

      if(weight[index] > remainingWeight)
         return solve(index+1, remainingWeight);

      if(memo[index][remainingWeight] != -1)
         return memo[index][remainingWeight];

      return memo[index][remainingWeight] = Math.max(solve(index+1, remainingWeight), value[index] + solve(index+1, remainingWeight - weight[index]));
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