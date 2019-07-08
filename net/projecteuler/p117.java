package net.projecteuler;

import java.math.BigInteger;

public class p117 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int MAX = 50;
		BigInteger[] A = new BigInteger[MAX+1];
		A[0] = BigInteger.ZERO;
		A[1] = BigInteger.ONE;
		A[2] = new BigInteger("2");
		A[3] = new BigInteger("4");
		A[4] = new BigInteger("8");
		for (int i = 5; i <= MAX; i++) {
			A[i] = A[i-1].add(A[i-2]).add(A[i-3]).add(A[i-4]); 
		}
		System.out.println(A[MAX]);
	}

}
