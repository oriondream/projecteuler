package net.projecteuler;

import static lib.Utils.primes;
import static lib.Utils.isPrime;
public class p50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxLength = 1;
		int limit = 1000000;
		for (int i = 0; i < primes.length - maxLength; i++) {
			
			int j;
			
			long sum = 0;
			
			for (j = 0; j < maxLength && sum < limit; j++) {
				sum += primes[i+j];
			}

			while (i+j < primes.length && sum + primes[i+j] < limit) {
				sum += primes[i+j];
				if (isPrime(sum)) {
					maxLength = j+1;
					System.out.println(sum + ": "+maxLength+" From " + i+" to "+(i+j));
				}
				++j;
			}
		}
	}
}
