package net.projecteuler;

import static lib.Utils.primes;
/**
 * Cho Pi la cac so nguyen to tu 2 den sqrt(N)
 * Ta dem cac so nguyen to Pj thoa man Pi <= Pj <= N/Pi
 * @author Administrator
 *
 */
public class p187 {
	boolean isPrime(long N) {
		int t = 0;

		long sqrt = (long) Math.floor(Math.sqrt(N));
		
		while (primes[t] <= sqrt && N%primes[t] != 0) {
			++t;
		}
		return primes[t] > sqrt;
	}
	
	boolean check(int i) {
		int t = 0;

		long sqrt = Math.round(Math.floor(Math.sqrt(i)));
		
		while (primes[t] <= sqrt && i%primes[t] != 0) {
			++t;
		}
		
		if (primes[t] <= sqrt)
			return isPrime(i/primes[t]);
		else
			return false;
	}
	
	public p187() {
		//System.out.println(check(4));
		//System.exit(0);
		int count = 0;
		for (int i = 1; i < 1e8; i++) {
			if (check(i)) {
				if (count % 10000 == 0)
					System.out.println(i);
				++count;
			}
		}
		System.out.println(count);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p187();
	}

}
