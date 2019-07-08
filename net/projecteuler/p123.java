package net.projecteuler;

import static lib.Utils.primes;

public class p123 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int t = 0; t < primes.length; t++) {
			long n = t+1;
			long pn = primes[t]; 
			if (n%2==1 && 2*n*pn > 1e10) {
				System.out.println(n);
				System.out.println(2*n*pn);
				break;
			}
		}
	}

}
