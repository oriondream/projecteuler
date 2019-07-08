package net.projecteuler;

import static lib.Utils.isSpanDigital;

public class p38 {
	static boolean checkOK(long N, final long K, final long digit) {
		//System.out.println(N + " " + K + " " + digit);
		long head = digit * K;
		
		if (N == head) {
			return true;
		}
		
		long tens = 1;
		while (head * 10 <= N) { 
			head *= 10;
			tens *= 10;
		}
		//System.out.println(tens);
		if (N/tens == digit * K) {
			N %= tens;
			if (N == 0)
				return true;
			else
				return checkOK(N, K, digit+1);
		}
		else 
			return false;
	}
	
	public static void main (String[] args) {
		//System.out.println(checkOK(918273645, 9, 1));
		//System.exit(0);
		
		int[] headTens = {
			100000000,
			10000000,
			1000000,
			100000
		};
		
		for (int i = 987654321; i >= 918273645; i--) {
			if (isSpanDigital(i)) {
				for (int t = 0; t < headTens.length; t++) {
					int head = i / headTens[t];
					if (checkOK(i, head, 1)) {
						System.out.println(i);
					}
				}
			}
		}
	}
}
