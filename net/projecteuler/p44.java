package net.projecteuler;

import static java.lang.Math.abs;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
public class p44 {
	static final int SIZE = 1000000;
	boolean[] marker = new boolean[SIZE];
	
	boolean check(long P) {
		if (P<1)
			return false;
		
		long n=(round(sqrt(6*P))+1)/3;
		
		if (n*(3*n-1)/2 == P)
			return true;
		else
			return false;
	}
	
	long p(long i) {
		return i*(3*i-1)/2;
	}
	
	public p44() {
		long k = 2;
		boolean found = false; 
		do {
			long Pk = p(k);
			long Pk_1 = p(k-1);
			int di = 1;
			while (p(k+di) - p(k) <= Pk_1) {
				long Pj = p(k+di) - Pk;
				if (check(Pj) && check(Pk-Pj)) {
					System.out.println(Pj + " " + Pk + ":" + check(Pj) + " " + check(Pk) + " " + check(Pj+Pk) + " " + check(abs(Pj-Pk)));
				}
				++di;
			}
			++k;
		} while (!found);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p44();
	}

}
