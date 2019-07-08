package net.projecteuler;

import lib.Utils;
/**
 * Find n such that the equation
 * 1/x + 1/y = 1/n
 * has more than 4M solutions (x <= y).
 * 
 * Note that x must be > n and le 2*n.
 * 
 * y = (x*n) / (x-n)
 * 
 * let (x-n) be u so x = (n+u)
 * 
 * y must be an integer so (n+u)*n | u => n*n | u
 * 
 * The problem turns to finding n such that n*n has more than 2*4M divisible 
 * 
 * @author Administrator 
 *
 */
public class p110 {
	final long UPPER = 13082761331670030L;
	
	long limit = UPPER;
	
	long powerProduct = 1;
	long number = 1;
	
	void bruteForce(int level) {
		if (level < 14)
			for (int i = 1; i <= 10; i++) {
				int ai = 2*i + 1;
				powerProduct *= ai;
				number *= (long)Math.pow(Utils.primes[level], i);
				if (number < limit) {
					if (powerProduct <= 8000000)
						bruteForce(level+1);
					else {
						limit = number;
						System.out.println(number+" -> " +powerProduct);
					}
					
					number /= (long) Math.pow(Utils.primes[level], i);
					powerProduct /= ai;
				}
				else {
					number /= (long) Math.pow(Utils.primes[level], i);
					powerProduct /= ai;
					break;
				}
			}
	}
	
	public p110() {
		bruteForce(0);
	}
	
	public static void main(String[] args) {
		long n = 1;
		for (int i = 1; i < 20; i++) {
			n *= 3;
			System.out.println(i + ": "+n);
		}	
		long product = 1;
		for (int i = 0; i < 14; i++) {
			System.out.print(Utils.primes[i]+" ");
			product *= Utils.primes[i];
		}
		System.out.println(product);
		new p110();
	}	
}
