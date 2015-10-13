import java.util.*;
import java.io.*;
import java.lang.Integer;

class Party {

   static int C;
   static int N;
   static int[] weight;
   static int[] value;
   static int[] ans;


   public static void main(String[] args) throws Exception {

      Parser sc = new Parser(System.in);
   
      while(true) {
         C = sc.nextInt();
         N = sc.nextInt();

         if(C == 0 && N == 0)
            break;

         weight = new int[N];
         value = new int[N];

         for(int i = 0; i < N; ++i) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
         }
         
         int ans1 = solve(0, C);
         int ans2 = C;
         int i = C;

         while(i >= 0 && ans[i] == ans1) {
            --i;
         }

         System.out.println((i+1) + " " + ans1);
      }
   }

   static int solve(int index, int wR) {

      ans = new int[C+1];

      for(int i = 0; i < N; ++i) {
         for(int j = C; j >= 0; --j) {
            ans[j] = weight[i] <= j ? Math.max(ans[j], ans[j-weight[i]] + value[i]) : ans[j];
         }
      }

      return ans[C];
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