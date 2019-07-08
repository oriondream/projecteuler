package net.projecteuler;

import java.math.BigInteger;

public class p113 {
	final int MAX_DIGITS = 100;
	
	BigInteger[][] inc = new BigInteger[MAX_DIGITS+1][9+1];
	BigInteger[][] dec = new BigInteger[MAX_DIGITS+1][9+1];
	
	void initInc() {
		System.out.println("inc table");
		for (int i = 0; i < inc.length; i++)
			for (int j = 0; j < inc[i].length; j++)
				inc[i][j] = BigInteger.ZERO;
		
		for (int i = 1; i <= 9; i++) {
			inc[1][i] = BigInteger.ONE;
		}
		for (int i = 2; i <= MAX_DIGITS; i++) {
			for (int j = 1; j <= 9; j++) {
				inc[i][j] = BigInteger.ZERO;
				for (int t = 1; t <= j; t++)
					inc[i][j] = inc[i][j].add(inc[i-1][t]);
			}
		}
		for (int d = 0; d <= 9; d++) {
			for (int l = 1; l <= MAX_DIGITS; l++)
				System.out.print(inc[l][d]+"\t");
			System.out.println();
		}
	}
	
	void initDec() {
		for (int i = 0; i < dec.length; i++)
			for (int j = 0; j < dec[i].length; j++)
				dec[i][j] = BigInteger.ZERO;

		dec[1][0] = BigInteger.ZERO;
		for (int i = 1; i <= 9; i++) {
			dec[1][i] = BigInteger.ONE;
		}
		for (int l = 2; l <= MAX_DIGITS; l++)
			for (int d = 0; d <= 9; d++) {
				dec[l][d] = BigInteger.ZERO;
				for (int pd = d; pd <= 9; pd++)
					dec[l][d] = dec[l][d].add(dec[l-1][pd]);
			}
		
		System.out.println("dec table");
		for (int d = 0; d <= 9; d++) {
			for (int l = 1; l <= MAX_DIGITS; l++)
				System.out.print(dec[l][d]+"\t");
			System.out.println();
		}
	}
	
	void tinh() {
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= MAX_DIGITS; i++) {
			for (int j = 1; j <= 9; j++) {
				sum = sum.add(inc[i][j]);
			}
		}
		
		for (int l = 1; l <= MAX_DIGITS; l++) {
			for (int j = 0; j <= 9; j++) {
				sum = sum.add(dec[l][j]);
			}
		}
		
		sum = sum.subtract(new BigInteger(Integer.toString(9*MAX_DIGITS)));
		
		System.out.println(sum);
	}
	
	public p113() {
		initInc();
		initDec();
		tinh();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p113();
	}

}
