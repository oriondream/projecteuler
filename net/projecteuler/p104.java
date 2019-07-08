package net.projecteuler;

import java.math.BigInteger;

public class p104 {
	static BigInteger Bi = new BigInteger("1000000000");
	
	static boolean checkTail(BigInteger bi) {
		String s = bi.toString();
		
		boolean[] digit = new boolean[10];
		
		digit[0] = true;
		
		if (s.length() < 9) {
			return false;
		}
		
		for (int i = 1; i <= 9; i++)
			if (digit[s.charAt(s.length() - i) - '0']) {
				return false;
			}
			else
				digit[s.charAt(s.length() - i) - '0'] = true;
		
		return true;
	}
	
	static boolean checkHead(BigInteger bi) {
		String s = bi.toString();
		
		if (s.length() < 9) {
			return false;
		}		

		boolean[] digit = new boolean[10];
		digit[0] = true;
		for (int i = 0; i < 9; i++) {
			if (digit[s.charAt(i) - '0']) {
				return false;
			}
			else
				digit[s.charAt(i) - '0'] = true;
		}
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(checkHead(new BigInteger("143726895533514372689")));
		
		BigInteger FnTail  = BigInteger.ONE;
		BigInteger Fn1Tail = BigInteger.ONE;
		BigInteger Fn2Tail = BigInteger.ONE;
		BigInteger FnHead  = BigInteger.ONE;
		BigInteger Fn1Head = BigInteger.ONE;
		BigInteger Fn2Head = BigInteger.ONE;

		int n = 2;

		BigInteger tenP5 = new BigInteger("100000");
		
		do {
			++n;
			FnHead  = Fn1Head.add(Fn2Head); 
			Fn2Head = Fn1Head;
			Fn1Head = FnHead;
			
			if (Fn1Head.toString().length() >= 20) {
				Fn1Head = Fn1Head.divide(tenP5);
				Fn2Head = Fn2Head.divide(tenP5);
			}
			
			FnTail  = Fn1Tail.add(Fn2Tail).mod(Bi);
			Fn2Tail = Fn1Tail;
			Fn1Tail = FnTail;
		} while (!checkTail(FnTail) || !checkHead(FnHead));
		System.out.println(FnHead);
		System.out.println(FnTail);

		System.out.println(n);
	}

}
