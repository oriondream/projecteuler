package net.projecteuler;

import static lib.Utils.isPrime;
import static lib.Utils.primes;
public class p72 {
	long gcd(long x, long y) {
		if (x == 0)
			return y;
		else
			if (x < y)
				return gcd(y%x,x);
			else 
				return gcd(x%y,y);
	}
	
	long[] findDivisors(long K) {
		long saveK = K;
		int i = 0;
		int unique_primes = 0;
		// Count the number of unique primes
		while (K != 1) {
			 while (primes[i] <= K && K % primes[i] != 0) ++i;
			 
			 ++unique_primes;
			 
			 while (K % primes[i] == 0 && K != 1) K = K/primes[i];
			 ++i;
		}
		

		long[] result = new long[unique_primes];
		i = 0;
		unique_primes = 0;
		K = saveK;
		// Count the number of unique primes
		while (K != 1) {
			 while (K % primes[i] != 0) ++i;
			 result[unique_primes++] = primes[i];
			 while (K % primes[i] == 0 && K != 1) K = K/primes[i];
			 ++i;
		}
		return result;
	}
	
	long[] D;

	long total = 0;
	
	void scan(final long N, long product, int K, long level) {
		if (K == D.length)
			if (level % 2 == 0)
				total -= N/product;
			else
				total += N/product;
		else {
			scan(N, product, K+1, level);
			scan(N, product * D[K], K+1, level + 1);
		}
	}	
	
	long find(long K) {
		D = findDivisors(K);
		total = 0;
		for (int i = 0; i < D.length; i++)
			scan(K, D[i], i+1, 1);
		return total;
	}
	
	static final long n = 1000000;

	public p72() {
		long count = 0;
		for (long i = 2; i <= n; i++) {
			if (isPrime(i))
				count += i-1;
			else 
				count += i-find(i);
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		new p72();
	}
}
