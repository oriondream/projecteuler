package net.projecteuler;

public class p114 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int LIMIT = 50;
		long[] A = new long[LIMIT + 1];
		A[0] = 0;
		A[1] = 0;
		A[2] = 0;
		A[3] = 1;
		for (int i = 4; i <= LIMIT; i++) {
			for (int j = 1; j <= i - 4; j++) {
				A[i] += A[j] * (i-j-3);
			}
			A[i] += i-2;
		}
		long sum = 0;
		for (int i = 1; i <= LIMIT; i++) {
			System.out.println(A[i]);
			sum += A[i];
		}
		System.out.println(sum+1);
	}

}
