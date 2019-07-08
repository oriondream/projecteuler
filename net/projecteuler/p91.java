package net.projecteuler;

public class p91 {
	static boolean[] isSquare = new boolean[10000];
	static {
		for (int i = 1; i*i < isSquare.length; i++) {
			isSquare[i*i] = true;
		}
	}
	
	public int atO(final int M, final int N) {
		System.out.println("Right angle is at O:    " + (M*N));
		return M*N;
	}
	
	public int onEdge(final int M, final int N) {
		System.out.println("Right angle is on edge: " + (2*M*N));
		return 2*M*N;
	}
	
	public int count(final int M, final int N) {
		int count = 0;

		count += atO(M, N);     // right angle is at O 
		
		count += onEdge(M,N); // right angle is on edge
		
		for (int i = 2; i <= M; i++)
			for (int j = 1; j < i; j++)
				for (int n = 1; n <= N; n++)
					if (j*(i-j)%n == 0 && j*(i-j)/n <= n)
						++count;
		
		for (int i = 2; i <= N; i++)
			for (int j = 1; j < i; j++)
				for (int n = 1; n <= M; n++)
					if (j*(i-j)%n == 0 && j*(i-j)/n <= n) {
						System.out.println("[0,0] ["+j+","+n+"] ["+i+","+(n - j*(i-j)/n)+"]");
						++count;					
					}

		return count;
	}
	public p91() {
		System.out.println(count(50,50));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p91();
	}

}
