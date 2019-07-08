package net.projecteuler;

import java.math.BigInteger;

public class p66 {
	static boolean isSquare(long D) {
		long D_root = Math.round(Math.floor(Math.sqrt(D)));
		if (D_root * D_root == D)
			return true;
		else
			return false;
	}
	static BigInteger[] a = new BigInteger[10000];
	
	static BigInteger[] p = new BigInteger[10000];
	static BigInteger[] q = new BigInteger[10000];
	static BigInteger[] P = new BigInteger[10000];
	static BigInteger[] Q = new BigInteger[10000];
	
	/**
	 * 
	 * @param N
	 * @return
	 */
	public static void find2(int N) {
		if (isSquare(N))
			return;

		final double SQRT = Math.sqrt(N);
		a[0] = new BigInteger(Long.toString((long) Math.floor(SQRT)));
		
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		BigInteger bigN = new BigInteger(Integer.toString(N));
		
		P[0] = zero;
		P[1] = a[0];
		Q[0] = one;
		Q[1] = a[0].multiply(a[0]).negate().add(bigN);
		a[1] = a[0].add(P[1]).divide(Q[1]);
		
		p[0] = a[0];
		p[1] = a[0].multiply(a[1]).add(one);
		q[0] = one;
		q[1] = a[1];

		
		for (int i = 2; i <= 100; i++) {
			P[i] = a[i-1].multiply(Q[i-1]).subtract(P[i-1]);
			Q[i] = P[i].multiply(P[i]).negate().add(bigN).divide(Q[i-1]);
			
			a[i] = a[0].add(P[i]).divide(Q[i]); 

			p[i] = a[i].multiply(p[i-1]).add(p[i-2]);
			q[i] = a[i].multiply(q[i-1]).add(q[i-2]);
			
			if (p[i].multiply(p[i]).equals(q[i].multiply(q[i]).multiply(bigN).add(one))) {
				System.out.println(N+": x="+p[i]);
				if (p[i].compareTo(max) == 1) {
					max = p[i];
					choice = N;
					System.out.println("candidate");
				}
				break;
			}
		}		
	}
	
	static BigInteger max = new BigInteger("0");

	static int choice;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//find2(61);
		for (int D = 1; D <= 1000; D++) {
			find2(D);
		}
		System.out.println(choice);
	}
}
