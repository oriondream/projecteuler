package net.projecteuler;

import java.math.BigInteger;
import static lib.Utils.sqrt;

public class p100a {
	static BigInteger LIMIT = new BigInteger("1000000000000");
	
	public static boolean check(BigInteger u1, BigInteger u2) {
		BigInteger v = u1.multiply(u2);
		BigInteger k = v.multiply(v).subtract(v).multiply(new BigInteger("2"));
		BigInteger p = new BigInteger(sqrt(k.toString(),0));
		BigInteger q = p.add(BigInteger.ONE);
		if (p.multiply(q).equals(k)) {
			System.out.println(v+" "+v.subtract(BigInteger.ONE)+" "+p+" "+q);
			if (q.compareTo(LIMIT) > 0)
				System.exit(0);
			return true;
		}
		else
			return false;
	}
	public static void main(String[] args) {
		BigInteger u1 = new BigInteger("3");
		BigInteger u2;
		do {
			u2 = u1;
			do {
				u2 = u2.add(BigInteger.ONE);
			} while (!check(u1, u2));
			u1 = u2;
		} while (true);
	}
}
