package net.projecteuler;

import java.math.BigInteger;
import static lib.Utils.*;

public class p55 {
	public p55() {
		int Lychrel = 0;
		for (Integer i = 0; i < 10000; i++) {
			//System.out.print(i+":");
			BigInteger N = new BigInteger(i.toString());
			int count = 0;
			do {
				N = N.add(reverse(N));
				//System.out.print("->" +N.toString());
				++count;
				if (count == 50) {
					++Lychrel;
					break;
				}
			} while (!isPalindrom(N));
			/*
			if (isPalindrom(N))
				System.out.println(" -- " + N.toString());
			else 
				System.out.println();
				*/
		}
		System.out.println(Lychrel);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p55();
	}

}
