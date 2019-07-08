package net.projecteuler;

import static lib.Utils.primes;
import static lib.Utils.erathosten;
public class p51 {
	int[] p = {10, 100, 110, 1000, 1010, 1100, 1110, 10010, 10100, 10110, 11000, 11010, 11100, 11110, 
			100010, 100100, 100110, 101000, 101010, 101100, 101110, 110010, 110100, 110110, 111000, 111010, 111100, 111110};
	static int getBase(final int N, final int mul) {
		int t = N;
		int[] digit = new int[10];
		int count = 0;
		int m = mul;
		while (t != 0) {
			if (m % 2 == 0)
				digit[count++] = t%10;
			else 
				digit[count++] = 0;
			t /= 10;
			m /= 10;
		}
		int result = 0;
		int tens = 1;
		for (int i = 0; i < digit.length; i++) {
			result += digit[i]*tens;
			tens *= 10;
		}
		return result;
	}
	public p51() {
		int i = 0;
		while (primes[i] < 10) 
			++ i;
		do {
			int iStar = 0; 
			while (iStar < p.length && p[iStar] < primes[i]) {
				int base = getBase(primes[i], p[iStar]);
				int count = 0;
				for (int digit = 0; digit <= 9; digit++) {
					if (erathosten[base + p[iStar]*digit]) {
						++count;
					}
				}
				if (count == 8) {
					for (int digit = 0; digit <= 9; digit++) {
						if (erathosten[base + p[iStar]*digit]) {
							System.out.print(base + p[iStar]*digit + " ");
						}
					}
					System.out.println();
					break;
				}
				++iStar;
			}
			++i;
		} while (i < primes.length);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(getBase(12345, 1100));
		new p51();
	}

}
