package net.projecteuler;

import static lib.Utils.Totient;

public class p69 {
	public p69() {
		double max = 0;
		int i_max = 0;
		for (int i = 10; i <= 1000000; i++) {
			System.out.println(i);
			long totient_i = Totient(i);
			if ((double)i/totient_i > max) {
				max = (double)i/totient_i;
				i_max = i;
			}
		}
		System.out.println(i_max);
	}
	public static void main(String[] args) {
		new p69();
	}
}
