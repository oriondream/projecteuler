package net.projecteuler;

import java.util.HashMap;
import static lib.Utils.getPrimeDivisors;

public class p179 {
	
	boolean check(int i) {
		HashMap<Long, Integer> di, di1;
		di = new HashMap<Long, Integer>();
		di1 = new HashMap<Long, Integer>();
		getPrimeDivisors(i, di);
		getPrimeDivisors(i+1, di1);
		int count = 1, count1 = 1;
		for (Integer v:di.values()) {
			count *= (v+1);
		}
		for (Integer v:di1.values()) {
			count1 *= (v+1);
		}
		return count == count1;
	}
	
	public p179() {
		//System.out.println(check(21));
		//System.exit(0);
		int count = 0;
		for (int i = 1; i <= 10000000; i++) {
			if (check(i)) {
				++count;
			}
		}
		System.out.println(count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p179();
	}

}
