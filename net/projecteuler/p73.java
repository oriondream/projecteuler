package net.projecteuler;

import static lib.Utils.GCD;

public class p73 {
	public p73() {
		int count = 0;
		for (int d = 4; d <= 12000; d++) {
			System.out.println(d);
			for (int n = d/3+1; n <= d/2; n++)
				if (GCD(d,n) == 1)
					++count;
		}
		System.out.println(count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p73();
	}

}
