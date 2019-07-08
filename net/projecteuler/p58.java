package net.projecteuler;


public class p58 {
	boolean isPrime(long N) {
		for (long i = 2; i < Math.sqrt(N); i++) {
			if (N%i == 0)
				return false;
		}
		return true;
	}
	public p58() {
		int n = 1;
		boolean found = false;
		int count = 0;
		while (!found) {
			if (isPrime(4*n*n + 2*n + 1)) ++count;
			if (isPrime(4*n*n + 1)) ++count;
			if (isPrime(4*n*n - 2*n + 1)) ++count;
			if (count*10 < (4*n+1)) {
				System.out.println(2*n+1);
				break;
			}
			++n;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p58();
	}

}
