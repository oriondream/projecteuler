package net.projecteuler;

import static lib.Utils.Totient;
import static lib.Utils.digitStat;

public class p70 {
	public p70() {
		double min = 2;
		for (int i = 10000000; i >=2 ; i--) {
			long di = digitStat(i);
			long ti = Totient(i);
			long dt = digitStat(ti); 
			if (di == dt) {
				if ((double)i / ti < min) {
					min = (double) i / ti;
					System.out.println(i + " " + Totient(i));
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p70();
	}

}
