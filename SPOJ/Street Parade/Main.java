import java.util.Scanner;

class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    while(N != 0) {
		
    	Integer[] floats = new Integer[N];
    	for(int i = N-1; i >= 0; i--) 
    		floats[i] = sc.nextInt();

    	int nextFloat = N-1;
		int nextValidFloat = 1;
		Stack st = new Stack();

		st.push(floats[nextFloat--]);
		while(!(st.empty())) {

			// empty as much as possible
			if(!(st.empty())) {
				while((!(st.empty())) && st.peek() == nextValidFloat) {
					st.pop();
					nextValidFloat++;
				}
			}

			// if empty just push
			if(st.empty()) {
				if(nextFloat >= 0) {
					st.push(floats[nextFloat--]);
				}
			}
			// else check if we've reached impossible case
			else {
				if(st.peek() > floats[nextFloat]) {
					st.push(floats[nextFloat--]);
				}
				else {
					System.out.printf("no\n");
					break;
				}
			}

		}
		if(st.empty()) 
			System.out.printf("yes\n");
		N = sc.nextInt();     
    }
  }

  private static class Stack {
  	private int capacity;
  	private int[] stack;
  	private int size;
  	private int top;

  	public Stack() {
  		capacity = 1000;
  		stack = new int[capacity];
  		size = 0;
  		top = -1;
  	}
  	public void push(int a) {
  		if(top == -1) {
  			top = 0;
  			stack[top] = a;
  			size++;
  		}
  		else {
  			for(int i = size-1; i>=0; i--)
  				stack[i+1] = stack[i];
  			stack[top] = a;
  			size++;
  		}
  	}
  	public int pop() {
  		if(empty()) {
  			return 0;
  		}
  		else {
  			int a = stack[top];
  			if(size == 1) 
  				top = -1;
  			else {
  				for(int i = 0; i<size-1; i++)
  					stack[i] = stack[i+1];
  				stack[size-1] = 0;
  			}
  			size--;
  			return a;
  		}
  	}
  	public int peek() {
  		if(empty())
  			return 0;
  		else 
  			return stack[top];
  	}
  	public boolean empty() {
  		return size == 0;
  	}
  }
}