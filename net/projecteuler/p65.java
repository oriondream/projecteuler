package net.projecteuler;

import java.math.BigInteger;


public class p65 {
	static int num(int k) {
		if (k % 3 == 0)
			if (k == 0)
				return 2;
			else 
				return (k/3)*2;
		else
			return 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger u = new BigInteger("1");
		BigInteger v = new BigInteger("0");
		BigInteger temp;
		for (int i = 100; i >= 1; i--) {
			temp = u;
			u = v;
			v = temp;
			
			u = u.add(v.multiply(new BigInteger(Long.toString(num(i)))));
		}		
		u = u.add(v);
		String s = u.toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}
