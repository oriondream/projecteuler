package net.projecteuler;

import java.math.BigInteger;
import static lib.Utils.pentagon;

/**
 * http://en.wikipedia.org/wiki/Integer_partition#Generating_function
 * @author Administrator
 *
 */
public class p78 {
	static final int MAX = 50000;
	
	static long[] pNumbers = new long[MAX*2];
	
	static BigInteger[] cache = new BigInteger[100000];
	
	static void calPenNum() {
		pNumbers[0] = 1;
		for (int i = 0; i < MAX; i++) {
			pNumbers[i*2] = pentagon(i+1);
			pNumbers[i*2+1] = pentagon(-(i+1));
		}
	}

	static BigInteger p(int k) {
		if (cache[(int)k] != null)
			return cache[k];
		else {
			BigInteger sum = new BigInteger("0");
			int i = 0;
			while (pNumbers[i] <= k) {
				if (i % 4 < 2)
					sum = sum.add(p(k - (int) pNumbers[i]));
				else 
					sum = sum.add(p(k - (int) pNumbers[i]).negate());
				++ i;
			}
			
			cache[k] = sum;
			
			return sum;
		}
	}
	
	static final BigInteger ONE_MILLION = new BigInteger("1000000");
	static final BigInteger ZERO = new BigInteger("0");
	
	public static void main(String[] args) {
		calPenNum();
		cache[0] = new BigInteger("1");
		int i = 0;
		
		while (!p(i).mod(ONE_MILLION).equals(ZERO)) ++i;
		
		System.out.println(i);
		System.out.println(p(i));
	}
}
