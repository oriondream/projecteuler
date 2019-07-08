package net.projecteuler;

import java.math.BigInteger;
public class p56 {
	public p56() {
		int max = 0;
		for (Integer a = 2; a < 100; a++) {
			BigInteger A = new BigInteger(a.toString());
			BigInteger N = new BigInteger("1");
			for (int b = 1; b < 100; b++) {
				N = N.multiply(A);
				//System.out.println(N.toString());
				String str = N.toString();
				int value = 0;
				for (int i = 0; i < str.length(); i++)
					value += str.charAt(i) - '0';
				if (value > max) max = value;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		new p56();
	}

}
