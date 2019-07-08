package net.projecteuler;

public class p94 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 0;
		for (long n = 3; n <= 333333333; n++) {
			long h1 = 2*n+1;
			long m1 = (long)Math.floor(Math.sqrt(h1*h1 - n*n));
			if (m1*m1+n*n==h1*h1) {
				long p = 2*n + 2*h1;
				if (p <= 1e9)
					sum += p;
				else
					break;
			}
			
			long h2 = 2*n-1;
			long m2 = (long)Math.floor(Math.sqrt(h2*h2 - n*n));
			if (m2*m2+n*n==h2*h2) {
				long p = 2*n + 2*h2;
				if (p <= 1e9)
					sum += p;
				else
					break;
			}
		}
		System.out.println(sum);
	}

}
