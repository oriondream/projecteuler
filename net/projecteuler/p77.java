package net.projecteuler;

import static lib.Utils.primes;

public class p77 {
	
	long calc(int N, int P) {
		if (f[N][P] != -1)
			return f[N][P];
		
		long sum = 0;
		
		if (N == P) {
			f[N][P] = 1;
		}
		else { 
			for (int i = 0; primes[i] <= P && primes[i] <= N-P; i++) {
				sum += calc(N - P, primes[i]);
			}
			f[N][P] = sum;
		}
		 // f(N,P) = so cach viet N thanh tong cac so nguyen to bat dau voi so nguyen to P
		 // f(N,P) = sum[ f(N-P, pi) ]  where pi <= P && pi <= N-P		
		
		return f[N][P];
	}
	
	long[][] f = new long[1000][1000];

	public p77() {
		for (int i = 0; i < f.length; i++)
			for (int j = 0; j < f.length; j++)
				f[i][j] = -1;

		for (int N = 2; ; ++N) {
			int i = 0;
			int sum = 0;
			while (primes[i] <= N) {
				f[N][primes[i]] = calc(N, primes[i]);
				sum += f[N][primes[i]];
				++i;
			}
			System.out.println(N+" "+sum);
			if (sum >= 5000) {
				System.exit(0);
			}
		}
		/**
		 * f(N,P) = so cach viet N thanh tong cac so nguyen to bat dau bang so nguyen to P
		 * f(N,P) = sum[ f(N-pi, pi) ]  where pi <= P
		 * 
		 * Khoi tao mang cac so nguyen to
		 * for N = 2
		 *     i = 1;
		 *     while pi < N
		 *         tinh f(N, pi)
		 *         if ( f(N,pi) >= 5000 )
		 *             println(N)
		 *             exit
		 *         else
		 *         ++i;
		 */
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p77();
	}
}