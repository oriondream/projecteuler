package net.projecteuler;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

class Coeff {
	private int k;
	private int n;
	public Coeff(int k, int n) {
		this.k = k;
		this.n = n;
	}
}

public class p203 {
	final int LIMIT = 51;

	LinkedList<Coeff> compute(int prime, int limit) {
		LinkedList<BigInteger> list = new LinkedList<BigInteger>();
		TreeSet<BigInteger> S = new TreeSet<BigInteger>();
		list.add(BigInteger.ONE);
		for (int i = 2; i <= limit; i++) {
			ListIterator<BigInteger> li = list.listIterator(0);
			BigInteger prev = BigInteger.ZERO;
			while (li.hasNext()) {
				BigInteger v = li.next();
				BigInteger new_v = v.add(prev);
				li.set(new_v);
				prev = v;
			}
			list.addLast(BigInteger.ONE);
			for (int t = 0; t < list.size(); t++) {
				System.out.print(list.get(t) + " ");
				boolean squareFree = true;
				for (int p = 2; p <= 49; p++)
					if (list.get(t).mod(new BigInteger(Long.toString(p*p))).equals(BigInteger.ZERO)) {
						squareFree = false;
						break;
					}
				if (squareFree)
					S.add(list.get(t));
			}
			System.out.println();
		}
		BigInteger sum = BigInteger.ZERO;
		for (BigInteger l:S) {
			sum = sum.add(l);
		}
		System.out.println(sum);
		return null;
	}
	
	public p203() {
		compute(5,LIMIT);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p203();
	}

}
