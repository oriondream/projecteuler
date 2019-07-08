package net.projecteuler;

import static lib.Utils.isPrime;
import static lib.Utils.primes;

public class p46 {
	boolean check(long N) {
		int i = 1;
		while (primes[i] < N) {
			long s = (N - primes[i])/2;
			long root = Math.round(Math.sqrt(s));
			if (root * root == s) {
				return true;
			}
			++i;
		}
		return false;
	}
	
	public p46() {
		long N = 9;
		while (check(N)) {
			do {
				N += 2;
			} while (isPrime(N));
			System.out.println(N);
		}
		System.out.println("Result: "+N);
	}	
	public static void main(String[] args) {
		new p46();
	}
}
