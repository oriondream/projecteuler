package net.projecteuler;

import static lib.Utils.primes;

import java.util.ArrayList;
import java.util.HashSet;


public class p87 {
	static final long LIMIT = 50000000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Long> square = new ArrayList<Long>();
		ArrayList<Long> cube = new ArrayList<Long>();
		ArrayList<Long> forth = new ArrayList<Long>();
		
		for (int i = 0; ;i++) {
			long p = primes[i];
			if (p*p < LIMIT) square.add(p*p);
			else
				break;
			if (p*p*p < LIMIT) cube.add(p*p*p);
			if (p*p*p*p < LIMIT) forth.add(p*p*p*p);
		}
		
		HashSet<Long> unique = new HashSet<Long>();
		
		for (Long X:square)
			for (Long Y:cube)
				for (Long Z:forth)
					if (X+Y+Z < LIMIT) {
						unique.add(X+Y+Z);
					}
		System.out.println(unique.size());
	}

}
