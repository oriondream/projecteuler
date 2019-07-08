package net.projecteuler;


public class p206 {

	/**
	 * @param args
	 */
	static boolean ok(long i) {
		String s = Long.toString(i);
		for (char p = 0, q = '1'; p <= 16;) {
			if (s.charAt(p) != q) {
				return false;
			}
			p += 2;
			q += 1;
		}
		return true;
	}
	public static void main(String[] args) {
		long i = 1000000030;
		long j = 1000000070;
		do {
			if (ok(i*i)) {
				System.out.println("Here =>" + i);
				System.exit(0);
			}
			else
				i+= 100;
			if (ok(j*j)) {
				System.out.println("Here =>" + j);
				System.exit(0);
			}
			else
				j+= 100;
		} while (i*i < 1929394959697989900l);
	}
}

