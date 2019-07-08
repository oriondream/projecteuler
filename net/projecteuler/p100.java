package net.projecteuler;

import java.util.HashMap;

import lib.Utils;

public class p100 {
	
	public static void main(String[] args) {
		//long l = 1000000000002L;
		long l = 23662L;
		long u = (long)Math.floor(l/Math.sqrt(2))+1;
		
		boolean found = false;
		
		HashMap<Long, Integer> iL   = new HashMap<Long, Integer>();
		HashMap<Long, Integer> iL_1 = new HashMap<Long, Integer>();
		HashMap<Long, Integer> iU   = new HashMap<Long, Integer>();
		HashMap<Long, Integer> iU_1 = new HashMap<Long, Integer>();

		Utils.getPrimeDivisors(l-1, iL);
		Utils.getPrimeDivisors(u-1, iU);
		
		while (!found) {
			u = (long)Math.floor(l/Math.sqrt(2))+1;
			
			iL_1 = (HashMap<Long, Integer>) iL.clone();
			Utils.getPrimeDivisors(l, iL);
			
			for (Long k:iL.keySet()) {
				Integer v = iL.get(k);
				if (iL_1.containsKey(k)) {
					iL_1.put(k, v+iL_1.get(k));
				}
				else {
					iL_1.put(k, v);
				}
			}
			
			boolean notDivisible = false;

			Utils.getPrimeDivisors(u, iU);

			for (Long k:iU.keySet()) {
				if (iL_1.containsKey(k)) {
					if (iL_1.get(k) < iU.get(k)) {
						notDivisible = true;
						break;
					}
					else {
						iL_1.put(k, iL_1.get(k) - iU.get(k));
					}
				}
				else {
					notDivisible = true;
					break;
				}
			}
			if (notDivisible) {
				++l;
				continue;
			}
			
			Utils.getPrimeDivisors(u-1, iU_1);
			
			for (Long k:iU_1.keySet()) {
				if (iL_1.containsKey(k)) {
					if (iL_1.get(k) < iU_1.get(k)) {
						notDivisible = true;
						break;
					}
					else {
						iL_1.put(k, iL_1.get(k) - iU_1.get(k));
					}
				}
				else {
					notDivisible = true;
					break;
				}
			}

			if (notDivisible) {
				++l;
			}
			else {
				System.out.println("U = "+u);
				System.out.println("L = "+l);
				System.exit(0);
			}
		}
	}
}
