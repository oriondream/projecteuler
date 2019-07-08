package net.projecteuler;

import java.math.BigInteger;

class p80 {
	int PRECISION = 99;
	String integer = "", decimal = "";
	
	BigInteger r = BigInteger.ZERO;
	BigInteger p = BigInteger.ZERO;
	BigInteger x = null;
	BigInteger _20 = new BigInteger("20");

	BigInteger res = BigInteger.ZERO;
	
	void findDigit() {
		x = BigInteger.ZERO;
		
		while (p.multiply(_20).add(x).multiply(x).compareTo(r) <= 0)
			x = x.add(BigInteger.ONE);
		
		x = x.subtract(BigInteger.ONE);		
		r = r.subtract(p.multiply(_20).add(x).multiply(x));
		p = p.multiply(BigInteger.TEN).add(x);
		
		res = res.add(x);
	}
	
	BigInteger sqrt(String N) {
		String integer = "", decimal = "";
		
		r = BigInteger.ZERO;
		p = BigInteger.ZERO;
		x = null;

		if (N.indexOf('.') != -1) {
			integer = N.substring(0, N.indexOf('.') - 1);
			decimal = N.substring(N.indexOf('.') + 1, N.length()-1);
		}
		else  {
			integer = N;
		}
		
		if (integer.length() % 2 != 0)
			integer = '0' + integer;
		
		BigInteger t = BigInteger.ONE;
		
		do {
			System.out.println(integer);
			r = new BigInteger(r.toString() + integer.charAt(0) + integer.charAt(1));
			integer = integer.substring(2, integer.length());

			findDigit();
			t = t.multiply(BigInteger.TEN);
		} while(!integer.equals(""));

		
		if (!decimal.equals("") || r.compareTo(BigInteger.ZERO) != 0) {
			while (decimal.length() < 2*PRECISION)
				decimal = decimal + '0';

			int precision = 0;
			
			while (r.compareTo(BigInteger.ZERO) == 0 || precision != PRECISION) {
				++precision;
				r = new BigInteger(r.toString() + decimal.charAt(0) + decimal.charAt(1));
				decimal = decimal.substring(2, decimal.length());
				
				findDigit();
			}
		}
		
		return p;	
	}
	
	public p80() {
		for (int i = 1; i <= 100; i++) {
			long sqrt = Math.round(Math.sqrt(i));
			if (sqrt*sqrt != i) {
				System.out.println(sqrt(Integer.toString(i)));
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new p80();
	}
}