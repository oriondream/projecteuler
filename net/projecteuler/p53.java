package net.projecteuler;


public class p53 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] A = new double[101];
		A[0] = 1;
		A[1] = 1;
		int count = 0;
		for (int n = 2; n <= 100; n++) {
			A[n] = 1;
			for (int r = n-1; r >= 1; r--) {
				A[r] += A[r-1];
				if (A[r] > 1000000) ++count;
			}
			/*
			for (int i = 0; i <= n; i++)
				System.out.print(A[i] + " ");
			System.out.println();
			*/
		}
		System.out.println(count);
	}

}
