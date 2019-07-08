package net.projecteuler;

import static lib.Utils.isSpanDigital;
import static lib.Utils.isPrime;

public class p41 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPrime(41));
		System.out.println(isPrime(40));
		for (long n = 987654321; n > 0; n--) {
			if (isSpanDigital(n) && isPrime(n)) {
				System.out.println(n);
				break;
			}
		}		
	}
}
