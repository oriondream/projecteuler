package net.projecteuler;

import java.math.BigInteger;

class Fraction {
	private BigInteger numerator, denominator;
	
	public Fraction(long det, long ter) {
		this.numerator = new BigInteger(((Long) det).toString());
		this.denominator = new BigInteger(((Long) ter).toString());
	}
	public Fraction(BigInteger det, BigInteger ter) {
		this.numerator = det;
		this.denominator = ter;
	}
	public Fraction invert() {
		return new Fraction(denominator, numerator);
	}
	public Fraction plus(long n) {
		BigInteger newDet = numerator.add(denominator.multiply(new BigInteger(((Long) n).toString())));
		BigInteger gcd = newDet.gcd(denominator);
		
		return new Fraction(newDet.divide(gcd), denominator.divide(gcd));
	}
	public BigInteger getNumerator() {
		BigInteger gcd = numerator.gcd(denominator);
		return numerator.divide(gcd);			
	}
	public BigInteger getDenominator() {
		BigInteger gcd = numerator.gcd(denominator);
		return denominator.divide(gcd);
	}
}

public class p57 {
	
	int desireDepth = 1;
	
	Fraction series(int depth) {
		if (depth == 1) {
			return new Fraction(3,2);
		}
		else 
			return series(depth-1).plus(1).invert().plus(1); 
	}
	public p57() {
		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			Fraction f = series(i);
			if (f.getNumerator().toString().length() > f.getDenominator().toString().length())
				++count;
			System.out.println(i);
		}
		System.out.println(count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p57();
	}

}
