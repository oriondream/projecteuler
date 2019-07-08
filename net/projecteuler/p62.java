package net.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;

public class p62 {
	BigInteger ten = new BigInteger("10");
	long hash(BigInteger n) {
		short[] digit = new short[10];
		String s = n.toString();
		for (int i = 0; i < s.length(); i++)
			++digit[s.charAt(i) - '0'];
		long H = 0;
		for (int i = 0; i <= 9; i++)
			H = H*10 + digit[i];
		return H;
	}
	
	public p62() {
		HashMap<Long, Long> HM = new HashMap<Long, Long>();
		BigInteger i = new BigInteger("8384");
		BigInteger one = new BigInteger("1");
		while (true) {
			System.out.println(i);
			BigInteger N = i.multiply(i).multiply(i);
			long H = hash(N);
			if (HM.containsKey(H)) {
				HM.put(H, HM.get(H)+1);
				System.out.println(HM.get(H));
				if (HM.get(H) == 5) {
					System.out.println("Found");
					System.out.println(i + " " + N);
					break;
				}
			}
			else {
				HM.put(H, 1l);
			}
			i = i.subtract(one);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p62();
	}

}
